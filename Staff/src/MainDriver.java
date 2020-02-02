
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author oracle
 */
public class MainDriver {

    public static void addStudent(Map affiliates, String name, int age, String address, int phone, int year) {
        Affiliate af = null;
        Scanner myInput = new Scanner(System.in);

        System.out.print("Enter the Student ID :");
        int aid = myInput.nextInt();
        System.out.print("Enter the Major :");
        String major = myInput.next();
        System.out.print("Enter the Minor :");
        String minor = myInput.next();
        System.out.print("Enter the Class outstanding (true or false) :");
        Boolean outstanding = myInput.nextBoolean();

        String studentType;
        while (true) {
            System.out.print("Enter the student type (Graduate or Undergraduate) :");
            studentType = myInput.next().toUpperCase();
            switch (studentType) {
                case "GRADUATE":
                    System.out.print("Enter the numbers of papers published :");
                    int numPapers = myInput.nextInt();
                    System.out.print("Enter the thesis advisor :");
                    String advisor = myInput.next();
                    af = new Graduate(numPapers, advisor, aid, major, minor, outstanding, name, age, address, phone, year);
                    break;
                case "UNDERGRADUATE":
                    System.out.print("Enter the number of courses taken  :");
                    int numOfCoursesTaken = myInput.nextInt();
                    System.out.print("Enter the scholorship amount :");
                    Double scholarShipAmount = myInput.nextDouble();
                    af = new Undergrad(numOfCoursesTaken, scholarShipAmount, aid, major, minor, outstanding, name, age, address, phone, year);
                    break;
                default:
                    System.out.print("Invalid student type  :");
                    break;

            }

            if (studentType.equalsIgnoreCase("Graduate") || studentType.equalsIgnoreCase("Undergraduate")) {
                break;
            }
        }

        affiliates.put(aid, af);
    }

    public static void addFaculty(Map affiliates, String name, int age, String address, int phone, int year) {

        Affiliate af = null;
        Scanner myInput = new Scanner(System.in);

        System.out.print("Enter the faculty id  :");
        int aid = myInput.nextInt();
        System.out.print("Enter the department :");
        String department = myInput.next();
        System.out.print("Enter the yearly salary :");
        double yearlySalary = myInput.nextDouble();
        System.out.print("Enter the number of papers :");
        int numOfPapers = myInput.nextInt();

        String facultyType;
        while (true) {
            System.out.print("Enter the Faculty type ( Assistant or Associate or Full )");
            facultyType = myInput.next().toUpperCase();
            switch (facultyType) {
                case "ASSISTANT":
                    System.out.print("Enter the years until tenure");
                    int yearsUntilTenure = myInput.nextInt();
                    af = new AssistantProfessor(yearsUntilTenure, aid, department, yearlySalary, numOfPapers, name, age, address, phone, year);
                    break;
                case "ASSOCIATE":
                    System.out.print("Enter the years since tenure");
                    int yearsSinceTenure = myInput.nextInt();
                    af = new AssociateProfessor(yearsSinceTenure, aid, department, yearlySalary, numOfPapers, name, age, address, phone, year);
                    break;
                case "FULL":
                    System.out.print("Enter the years until retirement");
                    int yearsUntilRetirement = myInput.nextInt();
                    af = new FullProfessor(yearsUntilRetirement, aid, department, yearlySalary, numOfPapers, name, age, address, phone, year);
                    break;
                default:
                    System.out.print(" Invalid Faculty type (Assistant or Associate or Full )");
            }
            if (facultyType.equals("ASSISTANT") || facultyType.equals("ASSOCIATE") || facultyType.equals("FULL")) {
                break;
            }
        }

        affiliates.put(aid, af);

    }

    public static void addStaff(Map affiliates, String name, int age, String address, int phone, int year) {
        Affiliate af = null;
        Scanner myInput = new Scanner(System.in);

        System.out.print("Enter the Staff ID.");
        int StaffID = myInput.nextInt();
        System.out.print("Enter the Building.");
        String Building = myInput.next();
        System.out.print("Enter the SupervisorID");
        int SupervisorID = myInput.nextInt();
        System.out.print("Enter the Title");
        String Title = myInput.next() ;
        System.out.print("Enter the hourly salary");
        double hourlySalary = myInput.nextDouble();
        System.out.print("Enter the FullTime (True or False)");
        boolean FullTime = myInput.nextBoolean();
        String staffType;

        while (true) {
            System.out.print("Enter the Staff type ( Executive or Academic or Student )");
            staffType = myInput.next().toUpperCase();
            switch (staffType) {

                case "EXECUTIVE":

                    System.out.print("Enter the Parking Space.");
                    String parkingSpace = myInput.next();
                    System.out.print("Enter the Rank.");
                    String rank = myInput.next();
                    af = new ExecutiveStaff(parkingSpace, rank,StaffID, Building, SupervisorID, FullTime, Title, hourlySalary, name, age, address, phone,year);
                    break;
                case "ACADEMIC":

                    System.out.print("Enter the Academic Unit.");
                    String academicUnit = myInput.next();
                    System.out.print("Enter the Pay Grade.");
                    int payGrade = myInput.nextInt();
                    af = new AcademicStaff(academicUnit, payGrade,StaffID, Building, SupervisorID, FullTime, Title, hourlySalary, name, age, address, phone,year);
                    break;
                case "STUDENT":

                    System.out.print("Enter the Major");
                    String major = myInput.next();
                    System.out.print("Enter the Academic Unit.");
                    boolean workStudy = myInput.nextBoolean();
                    af = new StudentWorker(major, workStudy, StaffID, Building, SupervisorID, FullTime, Title, hourlySalary, name, age,address, phone, year);
                                        
                    break;
                default:
                    break;

            }

            if (staffType.equals("EXECUTIVE") || staffType.equals("ACADEMIC") || staffType.equals("STUDENT")) {
                break;
            }
        }

        affiliates.put(StaffID, af);
    }

    public static void main(String[] args) {
        Map<Integer, Affiliate> affiliates = new HashMap();
        Scanner myInput = new Scanner(System.in);
        int choice, id;
        do {
            System.out.println("\n1) Create an affiliate record\n"
                    + "2) Print information for an Affiliate given the id\n"
                    + "3) List all affiliates in order of seniority\n"
                    + "4) Delete a record given the id\n"
                    + "5) Exit\n");

            System.out.print("Enter your choice : ");
            choice = myInput.nextInt();
            switch (choice) {
                case 1:
                    //name, age, address, phone number, year came to Chapman
                    int aid = 0;
                    Affiliate af = null;

                    System.out.print("Enter the name :");
                    String name = myInput.next();
                    System.out.print("Enter the age :");
                    int age = myInput.nextInt();
                    System.out.print("Enter the address :");
                    String address = myInput.next();
                    System.out.print("Enter the phone number :");
                    int phone = myInput.nextInt();
                    System.out.print("Enter the 'year came to Chapman' :");
                    int year = myInput.nextInt();
                    String affiliateType = null;
                    while (true) {
                        System.out.print("Enter the type of the affiliate (Student or  Faculty or  Staff ) : ");
                        affiliateType = myInput.next().toUpperCase();
                        if (affiliateType.equalsIgnoreCase("Student") || affiliateType.equalsIgnoreCase("Faculty") || affiliateType.equalsIgnoreCase("Staff")) {
                            break;
                        } else {
                            System.out.println("Invalid affiliate type");
                        }

                    }

                    switch (affiliateType) {
                        case "STUDENT":
                            addStudent(affiliates,name,age,address,phone,year);
                            break;
                        case "FACULTY":
                            addFaculty(affiliates,name,age,address,phone,year);
                            break;
                        case "STAFF":
                            addStaff(affiliates,name,age,address,phone,year);
                            break;
                        default:
                            break;
                    }

                    break;
                case 2:

                    System.out.print("Enter the Affiliate Id :");
                    id = myInput.nextInt();

                    if (affiliates.containsKey(id)) {
                        affiliates.get(id).print();
                    } else {
                        System.out.println("Affiliate does not exist with given ID");
                    }

                    break;
                case 3:

                    Collection<Affiliate> affiliateValues = affiliates.values();
                    //Creating an ArrayList of values 
                    ArrayList<Affiliate> affiliateValuesList = new ArrayList<Affiliate>(affiliateValues);
                    Collections.sort(affiliateValuesList);
                    Iterator itr = affiliateValuesList.iterator();
                    System.out.println("-----------------------------");
                    while (itr.hasNext()) {
                        Affiliate a = (Affiliate) itr.next();
                        a.print();
                    }
                    System.out.println("-----------------------------");
                    break;
                case 4:
                    System.out.print("Enter the Affiliate Id :");
                    id = myInput.nextInt();

                    if (affiliates.containsKey(id)) {
                        affiliates.remove(id);
                        System.out.println("Affiliate successfully deleted.");
                    } else {
                        System.out.println("Affiliate does not exist with given ID.");
                    }
                    break;
                case 5:
                    System.out.println("Thank you , exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice, please choose between 1 and 5.");

            }
        } while (choice != 5);
    }

}


/*



1) Create an affiliate record
2) Print information for an Affiliate given the id
3) List all affiliates in order of seniority
4) Delete a record given the id
5) Exit


 */
