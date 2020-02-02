/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oracle
 */
public class CompanyClient extends Client {

    public CompanyClient(String name) {
        super(name);
    }

    public float makeClaim(int polNum) {

        Policy p = getPolicy(polNum);
        float amt = 0;

        if (p == null) {
            amt = 0;
        } else {
          amt = getPolicy(polNum).handleClaim() ;
        }

        return amt;

    }
}
