/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oracle
 */
public class IndividualClient extends Client {

    public IndividualClient(String name) {
        super(name);
    }

    public float makeClaim(int polNum) {
        
        
        System.out.print("makeClaim FOR : "+polNum)  ;

        Policy p = getPolicy(polNum);
        float amt = 0;

        if (p == null || p.isExpired()) {
            amt = 0;

        } else {
            
             System.out.print("POLICY DETAILS : "+p)  ;

            if (p instanceof DepreciatingPolicy) {
                
                  System.out.println(" ++ DepreciatingPolicy ++")  ;  

                if (p.isExpired()) {
                    amt = 0;
                } else {

                    amt = p.handleClaim();
                }

            } else if (p instanceof ExpiringPolicy) {
                
                  System.out.println(" ++ ExpiringPolicy ++ ")  ;  

                amt = p.handleClaim();
            }
            else if (p instanceof Policy) {

                 System.out.println(" ++ Normal Policy ++")  ;  
                 
                amt = p.handleClaim();
                cancelPolicy(polNum);

            } 

        }

        return amt;
    }

}
