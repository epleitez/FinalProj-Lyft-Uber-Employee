public class Trip {

   private String destination;
   private String rideService;
   private int duration;
   private double hotelCost;
   private double mealExpenses;
   private Ride groundTransportation;
   
   public Trip(){
      this("","",0,0.0,0.0, null);
   }

   public Trip(String destination, String rideService, int duration, double hotelCost,
               double mealExpenses, Ride groundTransportation ){
      this.destination = destination;
      this.rideService = rideService;
      this.duration = duration;
      this.hotelCost = hotelCost;
      this.mealExpenses = mealExpenses;
      this.groundTransportation = groundTransportation;
      
   }
   
   public Trip(Trip copy){
      this.destination = copy.destination;
      this.rideService = copy.rideService;
      this.duration = copy.duration;
      this.hotelCost = copy.hotelCost;
      this.mealExpenses = copy.mealExpenses;
      this.groundTransportation = copy.groundTransportation;
      
   }
   
   //Setters-------------------------------------------------
   
   /**
   
   sets the destination of this trip to destination
   @param destination, the new destination of this Trip
   
   */ 
   
   public void setDestination(String destination){
      this.destination = destination;
   }
   
   public void setRideService(String rideService){
      this.rideService = rideService;
   }
   
   public void setDuration(int duration){
      this.duration = duration;
   }
   
   public void setHotelCost(double hotelCost){
      this.hotelCost = hotelCost;
   }
   
   public void setMealExpenses(double mealExpenses){
      this.mealExpenses = mealExpenses;
   }
   
   public void setGroundTransportation(Ride groundTransportation){
      this.groundTransportation = groundTransportation;
   }
   
   //Getters-------------------------------------------------
   
  /**
   
   Gets the destination of this Trip
   @returns the destination of this Trip
   
   */
   
   public String getDestination(){
      return this.destination;
   }
   
   public String getRideService(){
      return this.rideService;
   }
   
   public int getDuration(){
      return this.duration;
   }
   
   public double getHotelCost(){
      return this.hotelCost;
   }
   
   public double getMealExpenses(){
      return this.mealExpenses;
   }
   
   public Ride getGroundTransportation(){
      return this.groundTransportation;
   }
   
   public double getTotalCost(){
      return (hotelCost * duration) +
             (mealExpenses * duration) +
             (2 * groundTransportation.calculateFare());
   }
   

   //Equals-------------------------------------------------
   
   /**
   
   Checks this Trip to test Trip
   @param test Trip to compare this Trip to
   @returns true if the same attributes, false otherwise
   
   */

   public boolean equals(Trip test){
      boolean same = false;
      
      if ( this.destination.equalsIgnoreCase(test.destination) &&
           this.rideService.equalsIgnoreCase(test.rideService) &&
           this.duration == test.duration &&
           (int)(this.hotelCost * 1000) == (int)(test.hotelCost * 1000) &&
           (int)(this.mealExpenses * 1000) == (int)(test.mealExpenses * 1000) &&
           this.groundTransportation.equals(test.groundTransportation) )
          same = true;
          
      return same;
   }

   //toString-------------------------------------------------
   
   public String toString() {
   
      StringBuilder sb = new StringBuilder();
      
      sb.append("\nDestination: " + destination); 
      sb.append("\nRide Service: " + rideService);
      sb.append("\nDuration: " + duration + " days");
      sb.append("\nHotel Cost: $" + String.format("%.2f", hotelCost) );
      sb.append("\nMeal Expenses: $" + String.format("%.2f", mealExpenses) );
      sb.append("\n\nGround Transportation: " + groundTransportation); 
      
      sb.append("\n\nTotal Cost: $" + String.format("%.2f", getTotalCost()) );
      return sb.toString(); 
   
   
   
   }
   
   
   
   
   



}//end class Trip