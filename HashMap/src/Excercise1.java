
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oracle
 */
public class Excercise1 {
    
     //public static void main(String args[]) {
      void test() {
         
        Map<String,String> userPwds = new HashMap() ;
        Map<String,String> userNames = new HashMap() ;
        
        try {
         
            FileInputStream fis = new FileInputStream("/scratch/work/java/HashMap/src/Students.txt");
            Scanner sc = new Scanner(fis); 
         
            while (sc.hasNextLine()) {
                String line = sc.nextLine() ;
                if (line!=null)
                {
                    String[] userSring = line.split("\t");
                    userNames.put(userSring[1], userSring[0]);
                    userPwds.put(userSring[1], userSring[2]);
                }
                  
                
            }
            sc.close();     //closes the scanner  
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Scanner inputsc = new Scanner(System.in) ;
        String userName, password ;
        
        int loginAttempt = 3 ;
        while(loginAttempt-- > 0 )
        {
        System.out.print("Login:");
        userName=inputsc.next();
        System.out.print("Password:");
        password=inputsc.next();
        
        if (userPwds.containsKey(userName) &&  password.equals(userPwds.get(userName)))
        {
            System.out.println("Login succesful");
            System.out.println("Welcome "+userNames.get(userName));
            break ;
        }
        else
        {
            if (loginAttempt > 0)
              System.out.println("\n Either username or passowrd is incorrect.You have "+loginAttempt+" more attempts");
            else
              System.out.println("Sorry.Incorrect login. Please contact the system administrator . ");
        }
        }
           
    }
    
}
