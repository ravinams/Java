/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oracle
 */
public class Graduate extends Student{
    
    
        private int numOfPapers;
        
       private String thesisAdvisor;

    public Graduate(int numOfPapers, String thesisAdvisor, int StudentID, String Major, String Minor, boolean classOutstanding) {
        super(StudentID, Major, Minor, classOutstanding);
        this.numOfPapers = numOfPapers;
        this.thesisAdvisor = thesisAdvisor;
    }

    public Graduate(int numOfPapers, String thesisAdvisor, int StudentID, String Major, String Minor, boolean classOutstanding, String Name, int Age, String address, int phoneNumber, int Year) {
        super(StudentID, Major, Minor, classOutstanding, Name, Age, address, phoneNumber, Year);
        this.numOfPapers = numOfPapers;
        this.thesisAdvisor = thesisAdvisor;
    }
       
       

    /**
     * Get the value of thesisAdvisor
     *
     * @return the value of thesisAdvisor
     */
    public String getThesisAdvisor() {
        return thesisAdvisor;
    }

    /**
     * Set the value of thesisAdvisor
     *
     * @param thesisAdvisor new value of thesisAdvisor
     */
    public void setThesisAdvisor(String thesisAdvisor) {
        this.thesisAdvisor = thesisAdvisor;
    }


    /**
     * Get the value of numOfPapers
     *
     * @return the value of numOfPapers
     */
    public int getNumOfPapers() {
        return numOfPapers;
    }

    /**
     * Set the value of numOfPapers
     *
     * @param numOfPapers new value of numOfPapers
     */
    public void setNumOfPapers(int numOfPapers) {
        this.numOfPapers = numOfPapers;
    }

    
       
     @Override
    public int compareTo(Affiliate o) 
    {
       return Integer.compare(getYear(), o.getYear()) ;
    }
    
    @Override
    public void print()
    {
         System.out.println("Name = "+getName()+"| Age = "+getAge()+"| address = "+getAddress()
               +" | phoneNumber = "+getPhoneNumber()+"! Year = "+getYear()+"| StudentID = "+getStudentID()
               +" | Major = "+getMajor()+" | Minor = "+getMinor()+" | classOutstanding = "+isClassOutstanding()
               +" | numOfPapers = "+getNumOfPapers()+" | thesisAdvisor =  "+ getThesisAdvisor()
       );
    }
    
}
