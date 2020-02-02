/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package police;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author oracle
 */
public class PoliceDatabase {

    public static final int MAX_DRIVERS = 2000;
    public static final int MAX_VEHICLES = 1000;
    public static final int MAX_INFRACTIONS = 800;

    Vehicle[] vehicles;
    int numVehicles = 0;
    Driver[] drivers;
    int numDrivers = 0;
    Infraction[] infractions;
    int numInfractions = 0;

    public PoliceDatabase() {

        vehicles = new Vehicle[MAX_VEHICLES];
        drivers = new Driver[MAX_DRIVERS];
        infractions = new Infraction[MAX_INFRACTIONS];

    }

    public void registerDriver(Driver aDriver) {
        if (numDrivers < MAX_DRIVERS) {
            drivers[numDrivers++] = aDriver;
        } else {
            System.out.println("Unable to register Driver as database is full");
        }
    }

    public void registerVehicle(Vehicle aVehicle, String license) {

        if (numVehicles < MAX_VEHICLES) {
            aVehicle.owner = findDriver(license);
            vehicles[numVehicles++] = aVehicle;

        } else {
            System.out.println("Unable to register as Vehicle database is full");
        }

    }

    public void unregisterVehicle(String plate) {
        int vehicleIndex = 0;
        for (int i = 0; i < numVehicles; i++) {
            if (vehicles[i].hasPlate(plate)) {
                vehicleIndex = i;
                break;
            }
        }

        if (vehicleIndex > 0) {
            for (int j = vehicleIndex; j < numVehicles - 1; j++) {
                vehicles[j] = vehicles[j + 1];
            }

            numVehicles--;
        }

    }

    public void reportStolen(String plate) {
        Vehicle vehicle = findVehicle(plate);
        if (vehicle != null) {
            vehicle.reportedStolen = true;
        }
    }

    public void changeOwner(String plate, String license) {

        Vehicle vehicle = findVehicle(plate);
        Driver driver = findDriver(license); 
        vehicle.owner = driver ;
        
    }

    private Driver findDriver(String license) {
        for (int i = 0; i < numDrivers; i++) {
            if (drivers[i].hasLicense(license)) {
                return drivers[i];
            }
        }

        return null;
    }

    private Vehicle findVehicle(String plate) {
        for (int i = 0; i < numVehicles; i++) {
            if (vehicles[i].hasPlate(plate)) {
                return vehicles[i];
            }
        }

        return null;
    }

    public Infraction issueInfraction(String license, float amount, String description, Date date) {

        if (numInfractions < MAX_INFRACTIONS) {

            Infraction infraction = new Infraction(amount, description, date);
            infraction.driver = findDriver(license);

            infractions[numInfractions++] = infraction;

            return infraction;
        } else {
            System.out.println("Unable to issue Infraction as Vehicle database is full");
        }

        return null;
    }

    public boolean hasOutstandingInfractions(Driver d) {

        for (int i = 0; i < numInfractions; i++) {
            if (infractions[i].hasDriver(d)) {
                return true;
            }
        }

        return false;
    }

    public boolean shouldStopVehicle(String plate) {
        
        Vehicle vehicle = findVehicle(plate);
        
        if ( vehicle!=null && ( vehicle.reportedStolen || hasOutstandingInfractions(vehicle.owner) ) )
            return true;
        else
            return false ;
    }

    public void showInfractionsFor(String license) {
        
         Driver driver = findDriver(license);
         
          for (int i = 0; i < numInfractions; i++) {
            if (infractions[i].hasDriver(driver)) {
               System.out.println(infractions[i]) ;
            }
        }
    }

    private int cleanDriversCount()
    {
        int count = 0 ;
        for (int i = 0; i < numDrivers; i++) {
            if (! hasOutstandingInfractions(drivers[i])) {
               count ++ ; 
            }
        }
         return count ; 
    }
    
    public Driver[] cleanDrivers() {
        
       
        Driver []cleanDrivers = new Driver[cleanDriversCount()];
        int cleanDriversCount = 0 ;
         for (int i = 0; i < numDrivers; i++) {
            if (!hasOutstandingInfractions(drivers[i])) {
                cleanDrivers[cleanDriversCount++] = drivers[i] ;
            }
        }
         return cleanDrivers ;
    }

    public void showInfractionReport() {

       HashMap<String , Integer> infractionCount= new HashMap<String , Integer>() ;
       HashMap<String , Float> infractionAount= new HashMap<String , Float>() ;
       
       for (int i = 0; i < numInfractions && infractions[i].driver!=null; i++) {
                 
                 String license = infractions[i].driver.license ;
                 Float amount = infractions[i].amount ;
                
                if (infractionCount.containsKey(license)) 
                {
                    Integer count = infractionCount.get(license) ;
                    Float totalAmount = infractionAount.get(license) ;
                    
                    infractionCount.put(license , ++ count) ;
                    infractionAount.put(license, totalAmount+ amount) ; 
                }
                else
                {
                    infractionCount.put(license , 1) ;
                    infractionAount.put(license, amount) ;
                    
                }
             
            
       }
       
        for(Map.Entry m:infractionCount.entrySet()){  
             // System.out.println(findDriver((String)m.getKey()).name+": "+m.getValue() + " " + infractionAount.get((String)m.getKey()));  
                String license = (String)m.getKey() ;
                Driver d = findDriver(license) ;
                System.out.println( String.format("%20s",d.name ) +": "+infractionCount.get(license) + " infractions, total paid = " + String.format("$%6.2f",infractionAount.get(license) ) );  
  }  
        
    }
    

    public static PoliceDatabase example() { // Register all drivers and their vehicles 
        PoliceDatabase pdb = new PoliceDatabase();
        pdb.registerDriver(new Driver("L1567-34323-84980", "Matt Adore", "1323 Kenaston St.", "Gloucester", "ON"));
        pdb.registerDriver(new Driver("L0453-65433-87655", "Bob B. Pins", "32 Rideau Rd.", "Greely", "ON"));
        pdb.registerDriver(new Driver("L2333-45645-54354", "Stan Dupp", "1355 Louis Lane", "Gloucester", "ON"));
        pdb.registerDriver(new Driver("L1234-35489-99837", "Ben Dover", "2348 Walkley Rd.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L8192-87498-27387", "Patty O'Lantern", "2338 Carling Ave.", "Nepean", "ON"));
        pdb.registerDriver(new Driver("L2325-45789-35647", "Ilene Dover", "287 Bank St.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L1213-92475-03984", "Patty O'Furniture", "200 St. Laurant Blvd.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L1948-87265-34782", "Jen Tull", "1654 Stonehenge Cres.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L0678-67825-83940", "Jim Class", "98 Oak Blvd.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L0122-43643-73286", "Mark Mywords", "3 Third St.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L6987-34532-43334", "Bob Upandown", "434 Gatineau Way", "Hull", "QC"));
        pdb.registerDriver(new Driver("L3345-32390-23789", "Carrie Meehome", "123 Thurston Drive", "Kanata", "ON"));
        pdb.registerDriver(new Driver("L3545-45396-88983", "Sam Pull", "22 Colonel By Drive", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L1144-26783-58390", "Neil Down", "17 Murray St.", "Nepean", "ON"));
        pdb.registerDriver(new Driver("L5487-16576-38426", "Pete Reedish", "3445 Bronson Ave.", "Ottawa", "ON"));
        pdb.registerVehicle(new Vehicle("Honda", "Civic", 2015, "yellow", "W3EW4T"), "L0453-65433-87655");
        pdb.registerVehicle(new Vehicle("Pontiac", "Grand Prix", 2007, "dark green", "GO SENS"), "L0453-65433-87655");
        pdb.registerVehicle(new Vehicle("Mazda", "RX-8", 2004, "white", "OH YEAH"), "L2333-45645-54354");
        pdb.registerVehicle(new Vehicle("Nissan", "Altima", 2017, "bergundy", "Y6P9O7"), "L1234-35489-99837");
        pdb.registerVehicle(new Vehicle("Saturn", "Vue", 2002, "white", "9R6P2P"), "L2325-45789-35647");
        pdb.registerVehicle(new Vehicle("Honda", "Accord", 2018, "gray", "7U3H5E"), "L2325-45789-35647");
        pdb.registerVehicle(new Vehicle("Chrysler", "PT-Cruiser", 2006, "gold", "OLDIE"), "L2325-45789-35647");
        pdb.registerVehicle(new Vehicle("Nissan", "Cube", 2010, "white", "5Y6K8V"), "L1948-87265-34782");
        pdb.registerVehicle(new Vehicle("Porsche", "959", 1989, "silver", "CATCHME"), "L0678-67825-83940");
        pdb.registerVehicle(new Vehicle("Kia", "Soul", 2018, "red", "J8JG2Z"), "L0122-43643-73286");
        pdb.registerVehicle(new Vehicle("Porsche", "Cayenne", 2014, "black", "EXPNSV"), "L6987-34532-43334");
        pdb.registerVehicle(new Vehicle("Nissan", "Murano", 2010, "silver", "Q2WF6H"), "L3345-32390-23789");
        pdb.registerVehicle(new Vehicle("Honda", "Element", 2008, "black", "N7MB5C"), "L3545-45396-88983");
        pdb.registerVehicle(new Vehicle("Toyota", "RAV-4", 2010, "green", "R3W5Y7"), "L3545-45396-88983");
        pdb.registerVehicle(new Vehicle("Toyota", "Celica", 2006, "red", "FUNFUN"), "L5487-16576-38426");
        return pdb;
    }
}
