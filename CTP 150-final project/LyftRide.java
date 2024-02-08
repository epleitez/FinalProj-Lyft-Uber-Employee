public class LyftRide extends Ride{

   private double lyftFare = 0.0;
  
   
   public LyftRide(double lyftFare){
      super();
   }
   
   public LyftRide(String location, double timeTraveled, double distance){
      super(location, timeTraveled, distance);
   }
   
   public LyftRide(LyftRide copy){
      super(copy.getLocation(), copy.getTimeTraveled(), copy.getDistance());
   }
   
   //setter-------------------------------------------------------------------
   /**
   
   sets the lyft fare of this LyftRide to lyftFare
   @param lyftFare, the new lyft fare of this LyftRide
   
   */
   
   public void setLyftFare(double lytfFare){
      this.lyftFare = lyftFare;
   }
   
   //getter--------------------------------------------------------------------
   /**
   
   Gets the lyftFare of this LyftRide
   @returns the LyftFare of this LyftRide using the calculateFare() method
   
   */ 
   
   public double getLyftFare(){
      return calculateFare();
   }
   
   //abstract method from Ride class
   
   public double calculateFare(){
   
   
      lyftFare = RideConstants.LR_BASE_FARE + RideConstants.LR_SERVICE_FEE +
                 (RideConstants.LR_COST_MINUTE * getTimeTraveled()) +
                 (RideConstants.LR_COST_MILE * getDistance());
                 
      if (lyftFare < RideConstants.LR_MIN_FARE)
         lyftFare = RideConstants.LR_MIN_FARE;
      
      return lyftFare;
   } 

   
   //Equals-------------------------------------------------------------------
   /**
   
   Checks this LyftRide to test LyftRide
   @param test LyftRide to compare this LyftRide to
   @returns true if the same attributes, false otherwise
   
   */ 
   
   public boolean equals(LyftRide test){
      boolean same = false;
      
      if ( this.getLocation().equalsIgnoreCase(test.getLocation()) &&
           (int)(this.getTimeTraveled() * 1000) == (int)(test.getTimeTraveled() * 1000) &&
           (int)(this.getDistance() * 1000) == (int)(test.getDistance() * 1000) );
      same = true;
          
      return same;
      
   }
   
   //CompareTo
   
   public int compareTo(Ride test){
      
      if (getLyftFare() < test.calculateFare()){
         return -1;
      }
      else if (getLyftFare() > test.calculateFare() ){
         return 1;
      }
      else 
         return 0; 
   
   
   }//end 
   
   //toString-------------------------------------------------------------------
   
   public String toString(){
      StringBuilder sb = new StringBuilder();
      
      sb.append(super.toString()); 
      sb.append("\nLyft Fare: $" + String.format("%.2f", getLyftFare()));
   
      
      
      return sb.toString(); 
      
   }//end toString








}//end class LyftRide()