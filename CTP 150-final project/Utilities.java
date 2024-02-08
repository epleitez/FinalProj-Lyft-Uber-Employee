import javax.swing.JOptionPane;
import javax.swing.ImageIcon;


public class Utilities {
   
   
//Final project Menu-------------------------------  
   
   public static int rideSearch(){
     //Custom button text
      Object[] options = {"Display All", "Names By Department", "Trips Total By Department",
                          "Name By Destination", "Search Employee", "Exit"};
      ImageIcon icon = new ImageIcon("rideService.jpeg");
      int n = JOptionPane.showOptionDialog(null,
         "Which option? ",
         "Trip Search",
         JOptionPane.DEFAULT_OPTION,
         JOptionPane.PLAIN_MESSAGE,
         icon,
         options,
         options[0]);
    
    
      return n;
      
   }//end rideSearch
   
    public static int DepartmentChoices(){
     //Custom button text
      Object[] options = {"Customer Service","Accounting & Finance", "Marketing & Sales", 
                           "Human Resources","Research & Development", "return"};
      ImageIcon icon = new ImageIcon("rideService.jpeg");
      int n = JOptionPane.showOptionDialog(null,
         "Which Department? ",
         "Trip Search",
         JOptionPane.DEFAULT_OPTION,
         JOptionPane.PLAIN_MESSAGE,
         icon,
         options,
         options[0]);
    
    
      return n;
   
   }//end ratingSearch()
   
   
//-------------------------------------------------  

   
   public static int hotelSearch(){
     //Custom button text
      Object[] options = {"maximum price", " minimum rating", 
                          "state", "display all", "highest rate","search by Manager last name",
                          "search for employee", "exit"};
      ImageIcon icon = new ImageIcon("hotel.png");
      int n = JOptionPane.showOptionDialog(null,
         "Which option? ",
         "Hotel Search",
         JOptionPane.DEFAULT_OPTION,
         JOptionPane.PLAIN_MESSAGE,
         icon,
         options,
         options[0]);
    
    
      return n;
      
   }//end hotelSearch
   
   public static int ratingSearch(){
     //Custom button text
      Object[] options = {"*****", "****", "***", "**", "*","exit"};
      ImageIcon icon = new ImageIcon("hotel.png");
      int n = JOptionPane.showOptionDialog(null,
         "Which rating? ",
         "Hotel Search",
         JOptionPane.DEFAULT_OPTION,
         JOptionPane.PLAIN_MESSAGE,
         icon,
         options,
         options[0]);
    
    
      return n;
   
   }//end ratingSearch()
   
   public static int moviesSearch(){
     //Custom button text
      Object[] options = {"Display all", "Title", "Year", 
                          "Rotten Tomato Score","Rating", "More Options", "Exit"};
      ImageIcon icon = new ImageIcon("movie.gif");
      int n = JOptionPane.showOptionDialog(null,
         "Which option? ",
         "Movies Search",
         JOptionPane.DEFAULT_OPTION,
         JOptionPane.PLAIN_MESSAGE,
         icon,
         options,
         options[0]);
    
    
      return n;
      
   }//end MoviesSearch
   
   public static int moreOptions(){
     //Custom button text
      Object[] options = {"RunTime", "Total Runtime", "Add Movie", 
                          "Highest Earning", "Best Movie", "Worst Movie", "More Options", "Return"};
      ImageIcon icon = new ImageIcon("movie.gif");
      int n = JOptionPane.showOptionDialog(null,
         "Which option? ",
         "Movies Search",
         JOptionPane.DEFAULT_OPTION,
         JOptionPane.PLAIN_MESSAGE,
         icon,
         options,
         options[0]);
    
    
      return n;
   
   }//
   
   public static int moreOptions2(){
     //Custom button text
      Object[] options = {"Search by Director", "Search by Actor", "List all Studios","Return"};
      ImageIcon icon = new ImageIcon("movie.gif");
      int n = JOptionPane.showOptionDialog(null,
         "Which option? ",
         "Movies Search",
         JOptionPane.DEFAULT_OPTION,
         JOptionPane.PLAIN_MESSAGE,
         icon,
         options,
         options[0]);
    
    
      return n;
   
   }//
   
   public static int ratingChoice(){
     //Custom button text
      Object[] options = {"G","PG", "PG-13", "R","Return"};
      ImageIcon icon = new ImageIcon("movie.gif");
      int n = JOptionPane.showOptionDialog(null,
         "Which rating? ",
         "Movies Search",
         JOptionPane.DEFAULT_OPTION,
         JOptionPane.PLAIN_MESSAGE,
         icon,
         options,
         options[0]);
    
    
      return n;
   
   }//end ratingSearch()
   

   
   
} //end class