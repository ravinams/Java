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
public class Ticket {
    Theatre theatre ;
    public Ticket(Theatre t)
    {
       this.theatre = t ; 
       theatre.seatsSold ++ ;       
    }
            
            
}
