public abstract class Affiliate implements Comparable<Affiliate> , Printable{

    public Affiliate() {
    }

    public Affiliate(String Name, int Age, String address, int phoneNumber, int Year) {
        this.Name = Name;
        this.Age = Age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.Year = Year;
    }
    
    
    private String Name;
    
    private int Age;
    
    private String address;
    
    private int phoneNumber;
    
    private int Year;

    /**
     * Get the value of Year
     *
     * @return the value of Year
     */
    public int getYear() {
        return Year;
    }

    /**
     * Set the value of Year
     *
     * @param Year new value of Year
     */
    public void setYear(int Year) {
        this.Year = Year;
    }


    /**
     * Get the value of address
     *
     * @return the value of address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the value of address
     *
     * @param address new value of address
     */
    public void setAddress(String address) {
        this.address = address;
    }

   

    /**
     * Get the value of phoneNumber
     *
     * @return the value of phoneNumber
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set the value of phoneNumber
     *
     * @param phoneNumber new value of phoneNumber
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    

    /**
     * Get the value of Age
     *
     * @return the value of Age
     */
    public int getAge() {
        return Age;
    }

    /**
     * Set the value of Age
     *
     * @param Age new value of Age
     */
    public void setAge(int Age) {
        this.Age = Age;
    }


    /**
     * Get the value of Name
     *
     * @return the value of Name
     */
    public String getName() {
        return Name;
    }

    /**
     * Set the value of Name
     *
     * @param Name new value of Name
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    
}
