/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oracle
 */
public class AcademicStaff extends Staff {

    private String academicUnit;

    private int payGrade;

    public AcademicStaff(String academicUnit, int payGrade, int StaffID, String Building, int SupervisorID, boolean FullTime, String Title, double hourlySalary) {
        super(StaffID, Building, SupervisorID, FullTime, Title, hourlySalary);
        this.academicUnit = academicUnit;
        this.payGrade = payGrade;
    }

    public AcademicStaff(String academicUnit, int payGrade, int StaffID, String Building, int SupervisorID, boolean FullTime, String Title, double hourlySalary, String Name, int Age, String address, int phoneNumber, int Year) {
        super(StaffID, Building, SupervisorID, FullTime, Title, hourlySalary, Name, Age, address, phoneNumber, Year);
        this.academicUnit = academicUnit;
        this.payGrade = payGrade;
    }

    /**
     * Get the value of payGrade
     *
     * @return the value of payGrade
     */
    public int getPayGrade() {
        return payGrade;
    }

    /**
     * Set the value of payGrade
     *
     * @param payGrade new value of payGrade
     */
    public void setPayGrade(int payGrade) {
        this.payGrade = payGrade;
    }

    /**
     * Get the value of academicUnit
     *
     * @return the value of academicUnit
     */
    public String getAcademicUnit() {
        return academicUnit;
    }

    /**
     * Set the value of academicUnit
     *
     * @param academicUnit new value of academicUnit
     */
    public void setAcademicUnit(String academicUnit) {
        this.academicUnit = academicUnit;
    }

    @Override
    public int compareTo(Affiliate o) {
        return 1;
    }

    @Override
    public void print() {

         System.out.println("Name = "+getName()+"| Age = "+getAge()+"| address = "+getAddress() +" | phoneNumber = "+getPhoneNumber()
                 + "| Year = "+getYear()+"| StaffID = "+getStaffID() +" | Building = "+getBuilding()+" | SupervisorID = "+getSupervisorID()                 
                 +" | FullTime = "+isFullTime() +" | payGrade = "+getPayGrade()+" | academicUnit =  "+ getAcademicUnit());    
         
    }

}
