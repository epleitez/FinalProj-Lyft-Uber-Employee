public class UberRide extends Ride{

   private double uberFare = 0.0;
      
   public UberRide(){
      super();
   }
   
   public UberRide(String location, double timeTraveled, double distance){
      super(location, timeTraveled, distance);
   }
   
   public UberRide(UberRide copy){
      super(copy.getLocation(), copy.getTimeTraveled(), copy.getDistance());
   }
   
   //setter--------------------------------------------------------
   /**
   
   sets the uber fare of this UberRide to uberFare
   @param uberFare, the new uber fare of this UberRide
   
   */
   
   public void setUberFare(double uberFare){
      this.uberFare = uberFare;
   }
   
   //getter--------------------------------------------------------
   /**
   
   Gets the uberFare of this UberRide
   @returns the uberFare of this UberRide using the calculateFare() method
   
   */ 
   
   public double getUberFare(){
      return calculateFare();
   }
   
   //abstract method from Ride class
   
   public double calculateFare(){
   
      uberFare = RideConstants.UR_BASE_FARE +
                 (RideConstants.UR_COST_MINUTE * getTimeTraveled()) +
                 (RideConstants.UR_COST_MILE * getDistance());
                 
      if (uberFare < RideConstants.UR_MIN_FARE)
         uberFare = RideConstants.UR_MIN_FARE;
      
      return uberFare;
   } 
   
   //CompareTo-------------------------------------------------------
   
   public int compareTo(Ride test){
      
      if (getUberFare() < test.calculateFare()){
         return -1;
      }
      else if (getUberFare() > test.calculateFare() ){
         return 1;
      }
      else 
         return 0; 
   
   
   }//end 

   
   //Equals-------------------------------------------------------
   /**
   
   Checks this UberRide to test UberRide
   @param test UberRide to compare this UberRide to
   @returns true if the same attributes, false otherwise
   
   */ 
   
   public boolean equals(UberRide test){
      boolean same = false;
      
      if ( this.getLocation().equalsIgnoreCase(test.getLocation()) &&
           (int)(this.getTimeTraveled() * 1000) == (int)(test.getTimeTraveled() * 1000) &&
           (int)(this.getDistance() * 1000) == (int)(test.getDistance() * 1000) );
          same = true;
          
      return same;
      
   }
   
   
   //toString-------------------------------------------------------
   
      public String toString(){
      StringBuilder sb = new StringBuilder();
      
      
      
      sb.append(super.toString()); 
      sb.append("\nUber Fare: $" + String.format("%.2f", getUberFare()));

      
      
      return sb.toString(); 
      
   }//end toString
   
   


}//end class UberRide()