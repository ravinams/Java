
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author oracle
 */
public class ExpiringPolicy extends Policy {

    Date expiryDate;

    public ExpiringPolicy(float amt, Date eDate) {
        super(amt);
        expiryDate = eDate;
    }

    public ExpiringPolicy(float amt) {
        super(amt);

        GregorianCalendar aCalendar = new GregorianCalendar();
        aCalendar.add(Calendar.YEAR, 1);
        expiryDate = aCalendar.getTime();

    }

    public Date getDate() {
        return expiryDate;
    }

    public String toString() {
       
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMMM dd, yyyy (hh:mm a)");
        String date = simpleDateFormat.format(expiryDate);
        
        String expStr = isExpired()?" expired on: ":" expires: " ;
        
        return String.format("Expiring" + super.toString() + expStr + date);
    }

    public boolean isExpired() {
        return expiryDate.before(new Date());
    }
    
      public float handleClaim()
    {
         if (isExpired())
         {
            
             return  0;
         }
         else
             return getAmount();  
    }

}
