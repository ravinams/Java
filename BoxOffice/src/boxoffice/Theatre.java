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
public class Theatre {
    
    int capacity =0, seatsSold = 0;
    Movie moviePlaying ;
    public Theatre(int c)
    {
       capacity = c ; 
       seatsSold = 0;
    }
      
    public boolean isFull() {
      
       if (( capacity - seatsSold ) == 0)
           return true ;
       else
           return false ;
    }
            
}
