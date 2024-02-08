import javax.swing.JOptionPane;
import java.util.*; //ArrayList, Scanner, StringTokenizer;
import java.io.*;
import java.text.DecimalFormat;


public class TheDriver{

   public static void main (String [] args)throws IOException{
   
      ArrayList< Ride > rides = new ArrayList<Ride> ();
      ArrayList< Employee > tripInfo = new ArrayList<Employee> ();
     
      File infile = new File("rideInfo.csv");
      File infile2 = new File("finalProjectData.csv");
     
      Scanner scan = new Scanner(infile);
      Scanner scan2 = new Scanner(infile2);
    
      buildArrayList(rides, scan);
      buildArrayList2(rides, tripInfo, scan2);
      
      menu(tripInfo);
      
      /*
      for(Employee e: tripInfo){
         System.out.println(e + "\n---------------------------------------");
      }//end for
     
      //test(rides);
      */
      
   
   
      scan.close();
      scan2.close();
      
   
   }//end main
 //Menu**********************************************************************  
   
   public static void menu(ArrayList<Employee> tripInfo){
   
      int option = Utilities.rideSearch(); // priming read
      while(option != 5){
         switch(option){
            case 0: displayAll(tripInfo);
               break;
               
            case 1: displayNameByDep(tripInfo);
               break;
                    
            case 2: totalAllTripsByDep(tripInfo);
               break;
                     
            case 3: displayNameByDestination(tripInfo);
               break;
                    
            case 4: searchEmployee(tripInfo);
               break;
         
         }//end switch
         
         option = Utilities.rideSearch();
         
      }//end while
      
      
      JOptionPane.showMessageDialog(null, "Menu Closed...Goodbye...");
   }//end menu
     
   public static void buildArrayList(ArrayList<Ride> rides, Scanner scan)throws IOException{
   
      String line = "";
      line = scan.nextLine();
      StringTokenizer st;
      
      //variable
      String location = "";
      double distance = 0.0;
      double timeTraveled = 0.0;
      
      
      
      while (scan.hasNext()){
         line = scan.nextLine();
         st = new StringTokenizer(line, ",");
         location = st.nextToken();
         distance = Double.parseDouble(st.nextToken());
         timeTraveled = Double.parseDouble(st.nextToken());
         
         rides.add(new UberRide(location, distance, timeTraveled));
         rides.add(new LyftRide(location, distance, timeTraveled));
            
      
      }//end while 
   
   }//end
     
   public static void buildArrayList2(ArrayList<Ride> rides, ArrayList<Employee> tripInfo, Scanner scan2)throws IOException{
   
      String line = "";
      line = scan2.nextLine();
      StringTokenizer st;
      int size = rides.size();
      
      //Variables
      String name = "";
      String department = "";
      String destination = "";
      String rideService = "";
      int duration = 0;
      double hotelCost = 0.0;
      double mealExpenses = 0.0;
      Trip businessTrip = null;
      Ride groundTransportation = null;
   
      while(scan2.hasNext()){
         
         line = scan2.nextLine();
         st = new StringTokenizer(line, ",");
         name = st.nextToken();
         department = st.nextToken();
         destination = st.nextToken();
         rideService = st.nextToken();
         duration = Integer.parseInt(st.nextToken() );
         hotelCost = Double.parseDouble(st.nextToken() );
         mealExpenses = Double.parseDouble(st.nextToken() );
      
         for(int i = 0; i < size; i++) {
            if(rideService.equalsIgnoreCase("Uber")){
               if (rides.get(i) instanceof UberRide && rides.get(i).getLocation().equals(destination))
                  groundTransportation = rides.get(i);
            }
            else if(rideService.equalsIgnoreCase("Lyft")){
               if (rides.get(i) instanceof LyftRide && rides.get(i).getLocation().equals(destination))
                  groundTransportation = rides.get(i);
            }  
               
         }//end for 
         
         businessTrip = new Trip(destination, rideService, duration, hotelCost, 
                                    mealExpenses, groundTransportation); 
      
         tripInfo.add(new Employee(name, department, businessTrip) );
      
      }//end while
   
   
   }//end
   
   /**
   Displays everything stored in ArrayList
   @param tripInfo is reference to arrayList of Employee objects
   
   */
   
   public static void displayAll(ArrayList<Employee> tripInfo){
   
      System.out.printf("%-25s%-30s%-25s%-20s%-15s%-15s%-20s%-15s%-10s%-10s", "Name", "Department", "Destination", "Ride Service", 
                        "Duration", "Hotel Cost", "Meal Expenses", "Distance", "Fare", "Total Cost");
      
      System.out.println();
      
      for (Employee e: tripInfo)
         System.out.printf("%-25s%-30s%-25s%-20s%-15s%-15s%-20s%-15s%-10s%-10s\n", 
                           e.getName(), e.getDepartment(), e.getBusinessTrip().getDestination(), e.getBusinessTrip().getRideService(), 
                           (e.getBusinessTrip().getDuration() + " days"),
                           String.format("$%.2f", e.getBusinessTrip().getHotelCost()) ,  
                           String.format("$%.2f", e.getBusinessTrip().getMealExpenses()) ,
                           (e.getBusinessTrip().getGroundTransportation().getDistance() + " miles") , 
                           String.format("$%.2f", e.getBusinessTrip().getGroundTransportation().calculateFare() ) ,
                           String.format("$%.2f", e.getBusinessTrip().getTotalCost() ) );
   
   
   }//end displayAll()
   
   
   /**
   Displays names of Employees by department by asking user for Employee name or portion of name
   @param tripInfo is reference to arrayList of Employee objects
   
   */
    
   public static void displayNameByDep(ArrayList<Employee> tripInfo){
   
      int departmentChoice = Utilities.DepartmentChoices();
      String department = "";
      
      for (Employee e: tripInfo) {
         
         if (departmentChoice == 0){
            department = "Customer service";
            if(e.getDepartment().equalsIgnoreCase(department) ){
               System.out.println("Department: Customer service");
               System.out.println(e.getName() );
            }
         }
         
         else if (departmentChoice == 1){
            department = "Accounting and finance";
            if(e.getDepartment().equalsIgnoreCase(department) ){
               System.out.println("Department: Accounting and finance");
               System.out.println(e.getName() );
            }
         }
         
         else if (departmentChoice == 2){
            department = "Marketing and sales";
            if(e.getDepartment().equalsIgnoreCase(department) ){
               System.out.println("Department: Marketing and sales");
               System.out.println(e.getName() );
            }
         }
         
         else if (departmentChoice == 3){
            department = "Human resources";
            if(e.getDepartment().equalsIgnoreCase(department) ){
               System.out.println("Department: Human resources");
               System.out.println(e.getName() );
            }
         }
         
         else if (departmentChoice == 4){
            department = "Research and development";
            if(e.getDepartment().equalsIgnoreCase(department) ){
               System.out.println("Department: Research and development");
               System.out.println(e.getName() );
            }
         }
         else if (departmentChoice == 5){
            departmentChoice = Utilities.rideSearch();
         }
         
      }
         
   
   
   }//end displayNameByDep()
   
   /**
   Displays the total cost of trips by department, user asked to pick department
   @param tripInfo is reference to arrayList of Employee objects
   
   */
   
   public static void totalAllTripsByDep(ArrayList<Employee> tripInfo){
   
      int departmentChoice = Utilities.DepartmentChoices();
      String department = "";
      double cost = 0.0;
      double total = 0.0;
      
      for (Employee e: tripInfo) {
         if (departmentChoice == 0){
            department = "Customer service";
            if(e.getDepartment().equalsIgnoreCase(department) ){
               cost = e.getBusinessTrip().getTotalCost();
               total = total + cost;
            }
         }
         
         
         else if (departmentChoice == 1){
            department = "Accounting and finance";
            if(e.getDepartment().equalsIgnoreCase(department) ){
               cost = e.getBusinessTrip().getTotalCost();
               total = total + cost;
            }
         }
         
         else if (departmentChoice == 2){
            department = "Marketing and sales";
            if(e.getDepartment().equalsIgnoreCase(department) ){
               cost = e.getBusinessTrip().getTotalCost();
               total = total + cost;
            }
         }
         
         else if (departmentChoice == 3){
            department = "Human resources";
            if(e.getDepartment().equalsIgnoreCase(department) ){
               cost = e.getBusinessTrip().getTotalCost();
               total = total + cost;
            }
         }
         
         else if (departmentChoice == 4){
            department = "Research and development";
            if(e.getDepartment().equalsIgnoreCase(department) ){
               cost = e.getBusinessTrip().getTotalCost();
               total = total + cost;
            }
         }
         
         else if (departmentChoice == 5){
            departmentChoice = Utilities.rideSearch();
         }
      
      }
      System.out.println("Total Cost of Trips for the...");
      System.out.println("Department: " + department);
      System.out.println(String.format("$%.2f", total));
   
   
   }//end 
   
   /**
   Displays Employee names by destination, user asked to input destination name or portion of name
   @param tripInfo is reference to arrayList of Employee objects
   
   */
   
   public static void displayNameByDestination(ArrayList<Employee> tripInfo){
   
      String str = JOptionPane.showInputDialog("Enter Employee Destination");
      str = str.toLowerCase();
   
      boolean found = false;
      
      System.out.println("Employees that have traveled to a destination that contains " + str);
      System.out.println();
      
      for (Employee e: tripInfo){
         if(e.getBusinessTrip().getDestination().toLowerCase().contains(str) ){
            System.out.println("Destination: " + e.getBusinessTrip().getDestination() );
            System.out.println(e.getName() );
            found = true;
         }//end if
      }//end for
   
      if (!found)
         System.out.println("No employees found in destination that contains " + str); 
   
   }
   
   /**
   Displays name of Employee, user asked to input name or portion of name
   @param tripInfo is reference to arrayList of Employee objects
   
   */
   
   public static void searchEmployee(ArrayList<Employee> tripInfo){
   
      String str = JOptionPane.showInputDialog("Enter Employee name");
      str = str.toLowerCase();
      boolean found = false;
   
      for (Employee e: tripInfo){
         if(e.getName().toLowerCase().contains(str) ){
            System.out.println("\nFound: " + e.getName());
            System.out.println("\nEmployee Info: ");
            System.out.println(e);
            System.out.println("----------------------------");
            found = true;
         }//end if
      }//end for
   
      if (!found)
         System.out.println("No employees found with name that contains " + str); 
   
   
   
   
   }//end searchEmployee()
   
   
     
     
     
     
}//end TheDriver()










/* 

//comparing costs using comparable

   
   public static void test( ArrayList<Ride> rides) {
   
      String str = "baltimore"; //this would be a joptionpane
      
      for (int i =0; i < rides.size(); i++){
         if(rides.get(i).getLocation().equalsIgnoreCase(str) ){
            if(rides.get(i).compareTo(rides.get(i+1)) < 0){
               System.out.println("Uber in " + rides.get(i).getLocation() + " cheaper");
            } 
            else if(rides.get(i).compareTo(rides.get(i+1)) > 0){
               System.out.println("Lyft in " + rides.get(i).getLocation() + " cheaper");
         }
            else
               System.out.println("Uber and Lyft " + rides.get(i).getLocation() + " are equal");
         }
   
   
   
      }//end
   
   }


//displays rides objects
      
      for(Ride r: rides){
         System.out.println(r.getClass());
         System.out.println(r + "\n---------------------------------------");
      }//end for
      

      
      
      

*/
