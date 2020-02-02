/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oracle
 */
public class ExecutiveStaff extends Staff {
    
    private String parkingSpace;
    
    private String rank;

    public ExecutiveStaff(String parkingSpace, String rank, int StaffID, String Building, int SupervisorID, boolean FullTime, String Title, double hourlySalary) {
        super(StaffID, Building, SupervisorID, FullTime, Title, hourlySalary);
        this.parkingSpace = parkingSpace;
        this.rank = rank;
    }

    public ExecutiveStaff(String parkingSpace, String rank, int StaffID, String Building, int SupervisorID, boolean FullTime, String Title, double hourlySalary, String Name, int Age, String address, int phoneNumber, int Year) {
        super(StaffID, Building, SupervisorID, FullTime, Title, hourlySalary, Name, Age, address, phoneNumber, Year);
        this.parkingSpace = parkingSpace;
        this.rank = rank;
    }
    
    

    /**
     * Get the value of rank
     *
     * @return the value of rank
     */
    public String getRank() {
        return rank;
    }

    /**
     * Set the value of rank
     *
     * @param rank new value of rank
     */
    public void setRank(String rank) {
        this.rank = rank;
    }


    /**
     * Get the value of parkingSpace
     *
     * @return the value of parkingSpace
     */
    public String getParkingSpace() {
        return parkingSpace;
    }

    /**
     * Set the value of parkingSpace
     *
     * @param parkingSpace new value of parkingSpace
     */
    public void setParkingSpace(String parkingSpace) {
        this.parkingSpace = parkingSpace;
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
                 +" | FullTime = "+isFullTime() +" | parkingSpace = "+getParkingSpace()+" | rank =  "+ getRank());               
    }
}
