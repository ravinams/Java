/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxoffice;

/**
 *
 * @author oracle
 */
public class Patron {
    int age  ;
    Ticket ticket ;   
    public Patron(int a )            
    {
       age = a ; 
    }
    
     public Double ticketRate()            
    {
        
        if (age < 12)
           return 6.25 ;
        else if (age >= 65)
            return 5.75 ;
        else
            return 12.50 ;
    }
    
}
