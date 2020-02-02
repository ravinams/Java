/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oracle
 */
public class StudentWorker extends Staff{
    
    private String major;
    
    private boolean workStudy;

    public StudentWorker(String major, boolean workStudy, int StaffID, String Building, int SupervisorID, boolean FullTime, String Title, double hourlySalary) {
        super(StaffID, Building, SupervisorID, FullTime, Title, hourlySalary);
        this.major = major;
        this.workStudy = workStudy;
    }

    public StudentWorker(String major, boolean workStudy, int StaffID, String Building, int SupervisorID, boolean FullTime, String Title, double hourlySalary, String Name, int Age, String address, int phoneNumber, int Year) {
        super(StaffID, Building, SupervisorID, FullTime, Title, hourlySalary, Name, Age, address, phoneNumber, Year);
        this.major = major;
        this.workStudy = workStudy;
    }
       

    /**
     * Get the value of workStudy
     *
     * @return the value of workStudy
     */
    public boolean isWorkStudy() {
        return workStudy;
    }

    /**
     * Set the value of workStudy
     *
     * @param workStudy new value of workStudy
     */
    public void setWorkStudy(boolean workStudy) {
        this.workStudy = workStudy;
    }


    /**
     * Get the value of major
     *
     * @return the value of major
     */
    public String getMajor() {
        return major;
    }

    /**
     * Set the value of major
     *
     * @param major new value of major
     */
    public void setMajor(String major) {
        this.major = major;
    }

    
   @Override
    public int compareTo(Affiliate o) 
    {
       return Integer.compare(getYear(), o.getYear()) ;
    }
    
    @Override
    public void print()
    {
        
        
         System.out.println("Name = "+getName()+"| Age = "+getAge()+"| address = "+getAddress() +" | phoneNumber = "+getPhoneNumber()
                 + "| Year = "+getYear()+"| StaffID = "+getStaffID() +" | Building = "+getBuilding()+" | SupervisorID = "+getSupervisorID()                 
                 +" | FullTime = "+isFullTime() +" | major = "+getMajor()+" | workStudy =  "+ isWorkStudy());    
    }
}
