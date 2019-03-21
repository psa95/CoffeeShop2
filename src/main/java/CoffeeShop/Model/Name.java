/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CoffeeShop.Model;

/**
 *
 * @author Dare Adewoye
 */
public class Name {
     //Instance Variables
   
   private String firstName;
   private String lastName;
   private int id;
   
   //Constructor
   public Name( String firstName, String lastName, int Id){
       this.firstName = firstName;
       this.lastName = lastName;
       this.id= Id;
   }
   
   //Get and Set Method
   public String getfirstName (){
   return this.firstName;
   }
   
   public String getlastName(){
   return this.lastName;
   }
   
    public int getId(){
   return this.id;
   }
   
   
   
   //Customers Full Name
   public String getName(){
   return firstName + " " + lastName;
   }
   
   
   public String toString(){
       return "Id: " +id+ "\t " +lastName + "\t" + firstName + "\n";}
  
} 
