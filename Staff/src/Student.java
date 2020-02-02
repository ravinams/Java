// student id, major, minor, class standing

public abstract class Student extends Affiliate {

    private int StudentID;

    private String Major;

    private String Minor;

    private boolean classOutstanding;

    public Student(int StudentID, String Major, String Minor, boolean classOutstanding) {
        this.StudentID = StudentID;
        this.Major = Major;
        this.Minor = Minor;
        this.classOutstanding = classOutstanding;
    }

    public Student(int StudentID, String Major, String Minor, boolean classOutstanding, String Name, int Age, String address, int phoneNumber, int Year) {
        super(Name, Age, address, phoneNumber, Year);
        this.StudentID = StudentID;
        this.Major = Major;
        this.Minor = Minor;
        this.classOutstanding = classOutstanding;
    }
    
    
    /**
     * Get the value of classOutstanding
     *
     * @return the value of classOutstanding
     */
    public boolean isClassOutstanding() {
        return classOutstanding;
    }

    /**
     * Set the value of classOutstanding
     *
     * @param classOutstanding new value of classOutstanding
     */
    public void setClassOutstanding(boolean classOutstanding) {
        this.classOutstanding = classOutstanding;
    }

    /**
     * Get the value of Minor
     *
     * @return the value of Minor
     */
    public String getMinor() {
        return Minor;
    }

    /**
     * Set the value of Minor
     *
     * @param Minor new value of Minor
     */
    public void setMinor(String Minor) {
        this.Minor = Minor;
    }

    /**
     * Get the value of Major
     *
     * @return the value of Major
     */
    public String getMajor() {
        return Major;
    }

    /**
     * Set the value of Major
     *
     * @param Major new value of Major
     */
    public void setMajor(String Major) {
        this.Major = Major;
    }

    /**
     * Get the value of StudentID
     *
     * @return the value of StudentID
     */
    public int getStudentID() {
        return StudentID;
    }

    /**
     * Set the value of StudentID
     *
     * @param StudentID new value of StudentID
     */
    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

}
