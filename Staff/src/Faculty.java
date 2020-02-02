
public abstract class Faculty extends Affiliate {

    private int FacultyId;

    private String department;

    private double yearlySalary;

    private int numOfPapers;

    public Faculty(int FacultyId, String department, double yearlySalary, int numOfPapers) {
        this.FacultyId = FacultyId;
        this.department = department;
        this.yearlySalary = yearlySalary;
        this.numOfPapers = numOfPapers;
    }

    public Faculty(int FacultyId, String department, double yearlySalary, int numOfPapers, String Name, int Age, String address, int phoneNumber, int Year) {
        super(Name, Age, address, phoneNumber, Year);
        this.FacultyId = FacultyId;
        this.department = department;
        this.yearlySalary = yearlySalary;
        this.numOfPapers = numOfPapers;
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

    /**
     * Get the value of yearlySalary
     *
     * @return the value of yearlySalary
     */
    public double getYearlySalary() {
        return yearlySalary;
    }

    /**
     * Set the value of yearlySalary
     *
     * @param yearlySalary new value of yearlySalary
     */
    public void setYearlySalary(double yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    /**
     * Get the value of department
     *
     * @return the value of department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Set the value of department
     *
     * @param department new value of department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Get the value of FacultyId
     *
     * @return the value of FacultyId
     */
    public int getFacultyId() {
        return FacultyId;
    }

    /**
     * Set the value of FacultyId
     *
     * @param FacultyId new value of FacultyId
     */
    public void setFacultyId(int FacultyId) {
        this.FacultyId = FacultyId;
    }

}
