public class Employee{

   private String name;
   private String department;
   private Trip businessTrip;

   public Employee(){
      this("","",null);
   }
   
   public Employee(String name, String department, Trip businessTrip){
      this.name = name;
      this.department = department;
      this.businessTrip = businessTrip;
   }
   
   public Employee(Employee copy){
      this.name = copy.name;
      this.department = copy.department;
      this.businessTrip = copy.businessTrip;
   }
   
   //Setters-------------------------------------------------------
   /**
   
   sets the name of this Employee to name
   @param name, the new name of this Employee
   
   */
   
   public void setName(String name){
      this.name = name;
   }
   
   public void setDepartment(String department){
      this.department = department;
   }
   
   public void setBusinessTrip(Trip businessTrip){
      this.businessTrip = businessTrip;
   }
   
   //Getters-------------------------------------------------------
  /**
   
   Gets the name of this Employee
   @returns the name of this Employee
   
   */
   
   public String getName(){
      return this.name;
   }
   
   public String getDepartment(){
      return this.department;
   }
   
   public Trip getBusinessTrip(){
      return this.businessTrip;
   }
   
   //CompareTo----------------------------------------------------
   /*
   
      public int compareTo(Employee anotherEmployee){
      
      
      if (!getName().toLowerCase().contains(anotherEmployee)){
         return -1;
      }
      else if (getName().toLowerCase().contains(anotherEmployee)){
         return 1; 
      }
   */
   
   //end
   
   //Equals-------------------------------------------------------
   
   /**
   
   Checks this Employee to test Employee
   @param test Employee to compare this Employee to
   @returns true if the same attributes, false otherwise
   
   */
   
   public boolean equals(Employee test){
      boolean same = false;
      
      if ( this.name.equalsIgnoreCase(test.name) &&
           this.department.equalsIgnoreCase(test.department) &&
           this.businessTrip.equals(test.businessTrip) )
         same = true;
         
      return same;
      
   }
   
   //toString-------------------------------------------------------

   public String toString() {
   
      StringBuilder sb = new StringBuilder();
      
      sb.append("\nName: " + name); 
      sb.append("\nDepartment: " + department);
      sb.append("\n\nBusiness Trip: " + businessTrip);
      
      return sb.toString(); 
   
   
   
   }




}//end class Employee