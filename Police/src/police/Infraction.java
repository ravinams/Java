/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package police;

import java.util.Date;

/**
 *
 * @author oracle
 */
public class Infraction {
    
    float amount ;
    String description ;
    Date dateIssued  ;
    boolean outStanding ;
    Driver driver ;
    
    public Infraction()
    {}
    public Infraction(float a, String dscr , Date d)            
    {
       amount = a;
       description = dscr ;
       dateIssued = d  ;
       outStanding = true ;
    }
    public void pay()
    {
        outStanding = false ;
    }
    
      public boolean hasDriver(Driver aDriver)
    {
      if (aDriver !=null && aDriver.equals(driver))   
          return true ;
      else
          return false ;
    }
      
      @Override
    public String toString() {
        return  String.format("$%6.2f",amount)+" Infraction on "+String.format("%tc",dateIssued)+" "+  String.format("[%s]",outStanding ? "OUTSTANDING": "PAID IN FULL")   ;
      // return  amount+" Infraction on "+dateIssued+" "+ ( outStanding ? "OUTSTANDING": "PAID IN FULL")  ;
    }
}
