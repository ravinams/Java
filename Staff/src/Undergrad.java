public class Undergrad extends Student{
    
    private int numOfCoursesTaken;
    
    private double scholarShipAmount;

    public Undergrad(int numOfCoursesTaken, double scholarShipAmount, int StudentID, String Major, String Minor, boolean classOutstanding) {
        super(StudentID, Major, Minor, classOutstanding);
        this.numOfCoursesTaken = numOfCoursesTaken;
        this.scholarShipAmount = scholarShipAmount;
    }

    public Undergrad(int numOfCoursesTaken, double scholarShipAmount, int StudentID, String Major, String Minor, boolean classOutstanding, String Name, int Age, String address, int phoneNumber, int Year) {
        super(StudentID, Major, Minor, classOutstanding, Name, Age, address, phoneNumber, Year);
        this.numOfCoursesTaken = numOfCoursesTaken;
        this.scholarShipAmount = scholarShipAmount;
    }
   
    /**
     * Get the value of scholarShipAmount
     *
     * @return the value of scholarShipAmount
     */
    public double getScholarShipAmount() {
        return scholarShipAmount;
    }

    /**
     * Set the value of scholarShipAmount
     *
     * @param scholarShipAmount new value of scholarShipAmount
     */
    public void setScholarShipAmount(double scholarShipAmount) {
        this.scholarShipAmount = scholarShipAmount;
    }

    

    /**
     * Get the value of numOfCoursesTaken
     *
     * @return the value of numOfCoursesTaken
     */
    public int getNumOfCoursesTaken() {
        return numOfCoursesTaken;
    }

    /**
     * Set the value of numOfCoursesTaken
     *
     * @param numOfCoursesTaken new value of numOfCoursesTaken
     */
    public void setNumOfCoursesTaken(int numOfCoursesTaken) {
        this.numOfCoursesTaken = numOfCoursesTaken;
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
               +" | numOfCoursesTaken = "+getNumOfCoursesTaken()+" | scholarShipAmount =  "+ getScholarShipAmount()
       );
    }

}
