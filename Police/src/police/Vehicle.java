/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package police;

/**
 *
 * @author oracle
 */
public class Vehicle {
    String make , model ,color , plate ;
    int year ;
    Driver owner ;
    boolean reportedStolen ;
    
    public Vehicle()
    {}
    
    public Vehicle(String mke,String mdl,int yr,String clr,String plt)
    {
        make = mke ;
        model = mdl ;
        year = yr ;
        color = clr ;
        plate = plt ;
        reportedStolen = false ;
    }
    
      /* Returns the string representation of the Vehicle object*/
    @Override
    public String toString() {
        return  "A "+color+" "+year+" "+make+" ,"+model +" ,"+ plate  ;
    }
    
     public boolean hasPlate(String aplate)
    {
      if (plate !=null && plate.equals(aplate))   
          return true ;
      else
          return false ;
    }
}
