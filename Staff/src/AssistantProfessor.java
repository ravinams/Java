public class AssistantProfessor extends Faculty {
    
     private int yearsUntilTenure;

    public AssistantProfessor(int yearsUntilTenure,int FacultyId, String department, double yearlySalary, int numOfPapers) {
        super(FacultyId, department, yearlySalary, numOfPapers);
        yearsUntilTenure = this.yearsUntilTenure ;
    }

    public AssistantProfessor(int yearsUntilTenure,int FacultyId, String department, double yearlySalary, int numOfPapers, String Name, int Age, String address, int phoneNumber, int Year) {
        super(FacultyId, department, yearlySalary, numOfPapers, Name, Age, address, phoneNumber, Year);
        yearsUntilTenure = this.yearsUntilTenure ;
    }

    /**
     * Get the value of yearsUntilTenure
     *
     * @return the value of yearsUntilTenure
     */
    public int getYearsUntilTenure() {
        return yearsUntilTenure;
    }

    /**
     * Set the value of yearsUntilTenure
     *
     * @param yearsUntilTenure new value of yearsUntilTenure
     */
    public void setYearsUntilTenure(int yearsUntilTenure) {
        this.yearsUntilTenure = yearsUntilTenure;
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
                 +" | yearsUntilTenure = "+getYearsUntilTenure() );
        
    }
    
    
}
