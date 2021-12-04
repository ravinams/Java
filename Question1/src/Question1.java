
public class Question1 {

  
    public static void main(String[] args) {
        // TODO code application logic here
        String first="bill";        
        String last="koss";
        System.out.println("first="+first+" last="+last);
        System.out.println("Full Name="+first+" "+last);        
        System.out.println("Full Name="+ first.substring(0,1).toUpperCase()+first.substring(1)+" "+last.substring(0,1).toUpperCase()+last.substring(1));
        
    }
    
}
