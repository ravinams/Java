public class FullProfessor extends Faculty {
 private int yearsUntilRetirement;

    public FullProfessor(int yearsUntilRetirement,int FacultyId, String department, double yearlySalary, int numOfPapers) {
        super(FacultyId, department, yearlySalary, numOfPapers);
        yearsUntilRetirement = this.yearsUntilRetirement ;
    }

    public FullProfessor(int yearsUntilRetirement,int FacultyId, String department, double yearlySalary, int numOfPapers, String Name, int Age, String address, int phoneNumber, int Year) {
        super(FacultyId, department, yearlySalary, numOfPapers, Name, Age, address, phoneNumber, Year);
        yearsUntilRetirement = this.yearsUntilRetirement ;
    }

    /**
     * Get the value of yearsUntilRetirement
     *
     * @return the value of yearsUntilRetirement
     */
    public int getYearsUntilRetirement() {
        return yearsUntilRetirement;
    }

    /**
     * Set the value of yearsUntilRetirement
     * 
     * @param yearsUntilRetirement new value of yearsUntilRetirement
     */
    public void setYearsUntilRetirement(int yearsUntilRetirement) {
        this.yearsUntilRetirement = yearsUntilRetirement;
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
                 +" | yearsUntilRetirement = "+ getYearsUntilRetirement());
    }
}
