/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CoffeeShop;

/**
 *
 * @author Dare Adewoye
 */
public class Name {
     //Instance Variables
   private String firstName;
   private String lastName;
   private int Id;
   
   //Constructor
   public Name( String fN, String lN, int Id){
       firstName = fN;
       lastName = lN;
       this.Id= Id;
   
   }
   
   //Get and Set Method
   public String getfirstName (){
   return firstName;
   }
   
   public String getlastName(){
   return lastName;
   }
   
    public int getId(){
   return Id;
   }
   
   
   
   //Customers Full Name
   public String getName(){
   return firstName + " " + lastName;
   }
   
   
   public String toString(){
       return "Id: " +Id+ " , " +lastName + " " + firstName + " " + "\n";}
  
} 

