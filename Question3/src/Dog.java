
public class Dog {

    private String name;
    private int age;
    private String color;
    static int number=0;

    public Dog() {
       name ="Tommy" ;
       age=1;
       color="Black" ;
       number++;
    }
    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
        number++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static int getNumber() {
        return number;
    }   
}
