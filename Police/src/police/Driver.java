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
public class Driver {
    String license,name,street ,city,province ;
    
    public Driver()       
    {
    }
    
    public Driver(String l , String n , String s , String c , String p)
    {
       license = l ;
       name = n ;
       street = s ;
       city = c ;
       province = p ;             
    }
    
    /* Returns the string representation of the Driver object*/
    @Override
    public String toString() {
        return  "#"+license+" "+name+" living at "+street+" ,"+city +" ,"+ province  ;
    }
    
    public boolean hasLicense(String alicense)
    {
      if (license !=null && license.equals(alicense))   
          return true ;
      else
          return false ;
    }
}


