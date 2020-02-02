/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxoffice;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oracle
 */
public class BoxOffice {

    /**
     * @param args the command line arguments
     */
    
    Theatre theatreA;
    Theatre theatreB ;
    
    List<Patron> patrons = new ArrayList<Patron>();
    
    public BoxOffice(int capacity1, int capacity2)
            
    {
        theatreA= new Theatre(capacity1) ;
        theatreB= new Theatre(capacity2) ;
        
    }
    public void openMovie(String title , Theatre t)
    {
       
        Movie m = new Movie(title); 
        
        if (t.equals(theatreA))
        {
            theatreA.moviePlaying = m ;
            theatreA.seatsSold = 0 ;
        }
        else if (t.equals(theatreB))
        {
            theatreB.moviePlaying = m ; 
             theatreB.seatsSold = 0 ;
        }
                    
    }
    
    public void sellTicket(Patron p , String title)
    {
        
        // opted for theatreA  movie
        if (title.equals(theatreA.moviePlaying.title))
        {
           if (theatreA.isFull())
               System.out.println("Movie is sold out");
           else
           {
           p.ticket = new Ticket(theatreA) ;
           theatreA.moviePlaying.earnings =  theatreA.moviePlaying.earnings + p.ticketRate() ;
           patrons.add(p) ;
           }
        }
        // opted for theatreB  movie
        else if (title.equals(theatreB.moviePlaying.title))
            
        {
            
             if (theatreB.isFull())
               System.out.println("Movie is sold out");
           else
           {
               
            p.ticket = new Ticket(theatreB) ;
            theatreB.moviePlaying.earnings =  theatreB.moviePlaying.earnings + p.ticketRate() ;
             patrons.add(p) ;
             }
        }
        else
            
        {
            System.out.println("Movie is not currently playing");
        }
            
            
    }
    
    public void returnTicket(Patron p){
        if( patrons.contains(p) )
        {
           p.ticket.theatre.moviePlaying.earnings = p.ticket.theatre.moviePlaying.earnings - p.ticketRate() ;
           p.ticket.theatre.seatsSold -- ;            
           patrons.remove(p) ;
        }
        else
          System.out.println("Patron does not have a ticket") ;
        
    }
    
    
    
    public Movie bestMovie()   
    {                  
       return  ( theatreA.moviePlaying.earnings > theatreB.moviePlaying.earnings ? theatreA.moviePlaying : theatreB.moviePlaying );      
    }
    
   
            
}
