public class AssociateProfessor extends Faculty {

    private int yearsSinceTenure;

    public AssociateProfessor(int yearsSinceTenure,int FacultyId, String department, double yearlySalary, int numOfPapers) {
        super(FacultyId, department, yearlySalary, numOfPapers);
        yearsSinceTenure = this.yearsSinceTenure ;
    }

    public AssociateProfessor(int yearsSinceTenure, int FacultyId, String department, double yearlySalary, int numOfPapers, String Name, int Age, String address, int phoneNumber, int Year) {
        super(FacultyId, department, yearlySalary, numOfPapers, Name, Age, address, phoneNumber, Year);
        yearsSinceTenure = this.yearsSinceTenure ;
    }

    /**
     * Get the value of yearsSinceTenure
     *
     * @return the value of yearsSinceTenure
     */
    public int getYearsSinceTenure() {
        return yearsSinceTenure;
    }

    /**
     * Set the value of yearsSinceTenure
     *
     * @param yearsSinceTenure new value of yearsSinceTenure
     */
    public void setYearsSinceTenure(int yearsSinceTenure) {
        this.yearsSinceTenure = yearsSinceTenure;
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
                 + "| Year = "+getYear()+"| FacultyId = "+getFacultyId() +" | department = "+getDepartment()+" | yearlySalary = "+getYearlySalary()
                 +" | yearsSinceTenure = "+ getYearsSinceTenure() );
    }
}
