
public abstract class Staff extends Affiliate {

    private int StaffID;
    private String Building;
    private int SupervisorID;
    private boolean FullTime;
    private String Title;
    private double hourlySalary;

    public Staff(int StaffID, String Building, int SupervisorID, boolean FullTime, String Title, double hourlySalary) {
        this.StaffID = StaffID;
        this.Building = Building;
        this.SupervisorID = SupervisorID;
        this.FullTime = FullTime;
        this.Title = Title;
        this.hourlySalary = hourlySalary;
    }

    public Staff(int StaffID, String Building, int SupervisorID, boolean FullTime, String Title, double hourlySalary, String Name, int Age, String address, int phoneNumber, int Year) {
        super(Name, Age, address, phoneNumber, Year);
        this.StaffID = StaffID;
        this.Building = Building;
        this.SupervisorID = SupervisorID;
        this.FullTime = FullTime;
        this.Title = Title;
        this.hourlySalary = hourlySalary;
    }
    
    

    /**
     * Get the value of StaffID
     *
     * @return the value of StaffID
     */
    public int getStaffID() {
        return StaffID;
    }

    /**
     * Set the value of StaffID
     *
     * @param StaffID new value of StaffID
     */
    public void setStaffID(int StaffID) {
        this.StaffID = StaffID;
    }

    /**
     * Get the value of Building
     *
     * @return the value of Building
     */
    public String getBuilding() {
        return Building;
    }

    /**
     * Set the value of Building
     *
     * @param Building new value of Building
     */
    public void setBuilding(String Building) {
        this.Building = Building;
    }

    /**
     * Get the value of SupervisorID
     *
     * @return the value of SupervisorID
     */
    public int getSupervisorID() {
        return SupervisorID;
    }

    /**
     * Set the value of SupervisorID
     *
     * @param SupervisorID new value of SupervisorID
     */
    public void setSupervisorID(int SupervisorID) {
        this.SupervisorID = SupervisorID;
    }

  

    /**
     * Get the value of Title
     *
     * @return the value of Title
     */
    public String getTitle() {
        return Title;
    }

    /**
     * Set the value of Title
     *
     * @param Title new value of Title
     */
    public void setTitle(String Title) {
        this.Title = Title;
    }

   

    /**
     * Get the value of hourlySalary
     *
     * @return the value of hourlySalary
     */
    public double getHourlySalary() {
        return hourlySalary;
    }

    /**
     * Set the value of hourlySalary
     *
     * @param hourlySalary new value of hourlySalary
     */
    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    /**
     * Get the value of FullTime
     *
     * @return the value of FullTime
     */
    public boolean isFullTime() {
        return FullTime;
    }

    /**
     * Set the value of FullTime
     *
     * @param FullTime new value of FullTime
     */
    public void setFullTime(boolean FullTime) {
        this.FullTime = FullTime;
    }

}
