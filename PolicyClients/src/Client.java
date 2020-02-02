/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oracle
 */
import java.util.*;

public abstract class Client {

    private static final int MAX_POLICIES_PER_CLIENT = 10;
    private static int NEXT_CLIENT_ID = 1;
    private String name;
    private int id;
    protected Policy[] policies;
    protected int numPolicies;

    public Client(String nme) {
        name = nme;
        id = NEXT_CLIENT_ID++;
        policies = new Policy[MAX_POLICIES_PER_CLIENT];
        numPolicies = 0;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Policy[] getPolicies() {
        return policies;
    }

    public int getNumPolicies() {
        return numPolicies;
    }

    public String toString() {
        return String.format(this.getClass().getSimpleName() + ": %06d amount: %s", id, name);
    }

    public float totalCoverage() {
        float totCoverage = 0;
        for (int i = 0; i < numPolicies; i++) {
            totCoverage = totCoverage + policies[i].getAmount();
        }
        return totCoverage;
    }

    public Policy addPolicy(Policy p) {
        if (p != null && numPolicies < MAX_POLICIES_PER_CLIENT) {
            policies[numPolicies++] = p;
        }
        return p;
    }

    public Policy openPolicyFor(float amt) {
        Policy p = new Policy(amt);
        return addPolicy(p);
    }

    public Policy openPolicyFor(float amt, float rate) {
        Policy p = new DepreciatingPolicy(amt, rate);
        return addPolicy(p);
    }

    public Policy openPolicyFor(float amt, Date expire) {
        Policy p = new ExpiringPolicy(amt, expire);
        return addPolicy(p);
    }

    public Policy getPolicy(int polNum) {
        Policy p = null;

        for (int i = 0; i < numPolicies; i++) {
            if (policies[i].getPolicyNumber() == polNum) {
                p = policies[i];
                break;
            }
        }

        return p;
    }

    public boolean cancelPolicy(int polNum) {

        boolean cancelled = false;
        for (int i = 0; i < numPolicies; i++) {
            if (policies[i].getPolicyNumber() == polNum) {
                policies[i] = policies[numPolicies - 1];
                cancelled = true;
                numPolicies--;
                break;
            }
        }

        return cancelled;
    }

    public abstract float makeClaim(int polNum);

}
