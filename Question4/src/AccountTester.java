
public class AccountTester {

    public static void main(String[] args) {
        Account A1 = new Account("A1", 1000);
        Account A2 = new Account("A2", 1000);
        Account A3 = new Account("A3", 1000);
        
        //with draw 200
        
        double a1Balance =  A1.getAccountBalance() ;      
        A1.setAccountBalance(a1Balance-200); // withdraw 200
        System.out.println("A1 Balance :="+A1.getAccountBalance());
        
        double a2Balance =  A2.getAccountBalance() ;      
        A2.setAccountBalance(a2Balance-200); // withdraw 200
        System.out.println("A2 Balance :="+A2.getAccountBalance());

        
        double a3Balance =  A3.getAccountBalance() ;      
        A3.setAccountBalance(a3Balance-200); // withdraw 200
        System.out.println("A3 Balance :="+A3.getAccountBalance());
        
    }

}
