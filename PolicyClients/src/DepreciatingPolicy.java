
import java.text.SimpleDateFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author oracle
 */
public class DepreciatingPolicy extends Policy {

    float rate;

    public DepreciatingPolicy(float amt, float rate) {
        super(amt);
        this.rate = rate;

    }

    public float getRate() {
        return rate;
    }

    public String toString() {
        float lRate = 1 / rate;

        return String.format("Depreciating" + super.toString() + " rate:" + lRate) + "%";
    }

    public boolean isExpired() {
        return (amount == 0.0);
    }

    public void depreciate() {
        if (!isExpired()) {
            amount = (amount - (amount * rate));
        }
    }

    public float handleClaim() {

        depreciate();
        return getAmount();
    }
}
