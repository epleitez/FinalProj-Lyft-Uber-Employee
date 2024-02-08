public abstract class Ride implements Comparable<Ride>{


   private String location = "";
   private double timeTraveled = 0.0; //in minutes
   private double distance = 0.0; //in miles
   
   public Ride(){
      this("",0.0,0.0);
   }
   
   public Ride(String location, double distance, double timeTraveled){
      this.location = location;
      this.distance = distance;
      this.timeTraveled = timeTraveled;
   }
   
   public Ride(Ride copy){
      this.location = copy.location;
      this.distance = copy.distance;
      this.timeTraveled = copy.timeTraveled;
   }
   
   //Setters--------------------------------------------------------
   /**
   
   sets the location of this Ride to location
   @param location, the new location of this Ride
   
   */ 
   
   public void setLocation(String location){
      this.location = location;
   }
   
   public void setTimeTraveled(double timeTraveled){
      this.timeTraveled = timeTraveled;
   }
   
   public void setDistance(double distance){
      this.distance = distance;
   }
   
   //Getters--------------------------------------------------------
   /**
   
   Gets the location of this Ride
   @returns the location of this Ride
   
   */ 
   
   public String getLocation(){
      return this.location;
   }
   
   public double getTimeTraveled(){
      return this.timeTraveled;
   }
   
   public double getDistance(){
      return this.distance;
   }
   
   //equals--------------------------------------------------------
   
   /**
   
   Checks this Ride to test Ride
   @param test Ride to compare this Ride to
   @returns true if the same attributes, false otherwise
   
   */  
   
   public boolean equals(Ride test){
      boolean same = false;
      
      if ( this.location.equalsIgnoreCase(test.location) &&
           (int)(this.timeTraveled * 1000) == (int)(test.timeTraveled * 1000) &&
           (int)(this.distance * 1000) == (int)(test.distance * 1000) );
          same = true;
          
      return same;
   }
   
   
   //abstract methods-----------
   
   public abstract double calculateFare();
   
   
   
   //toString--------------------------------------------------------
   
   public String toString() {
   
      StringBuilder sb = new StringBuilder();
      
      sb.append("\nLocation: " + location); 
      sb.append("\nDistance: " + String.format("%.2f", distance) + " Miles");
      sb.append("\nTime Traveled: " + String.format("%.2f", timeTraveled) + " Minutes"); 
      
      return sb.toString(); 
   
   
   
   }
   



}//end class