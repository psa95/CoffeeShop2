package CoffeeShop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Customer {

  private ArrayList<Name> name;
  
  public Customer(){
      
      name = new ArrayList();
  }
  
  public boolean addCustomer(Name n) {   
           int id = n.getId();
           Name inList = this.searchID(id);  
                    if (inList == null) {   
                    name.add(n);
                      return true;  
                    }  
                    return false;
           }
    
    public Name searchID(int id){
              for (Name i : name)
              {       
                  if (i.getId() == id){
                      return i;
                  }
                  
              }      
              return null;    
          }
    
    public Name searchCustomerName(String name){
              for (Name n : this.name)
              {       
                  if (n.getfirstName().equals(name)||n.getlastName().equals(name)){
                      return n;
                  }
                  
              }      return null;    
          }
    
    public Name searchLastName(String lname){
              for (Name n : name)
              {       
                  if (n.getlastName().equals(lname)){
                      return n;
                  }
                  
              }      return null;    
          }
        
    public String listAllCustomers()
	{
            String separator = System.getProperty("line.separator");
		String list = "Customers"+separator;
                for (Name n : name){
			list += n.toString();	
		}
		return list;
	}
    
    public static void writeToFile(String filename, String Customer) {
        FileWriter fw;
        try {
            fw = new FileWriter(filename);
            fw.write(Customer);
            fw.close();
            }
		 //message and stop if file not found
		 catch (FileNotFoundException fnf){
			 System.out.println(filename + " not found ");
			 System.exit(0);
		 }
		 //stack trace here because we don't expect to come here
		 catch (IOException ioe){
		    ioe.printStackTrace();
		    System.exit(1);
		 }
	}
    
    private void processMenuLine(String line) {
        
			String parts [] = line.split(",");
                        String firstName = parts[0];
                        String lastName = parts[1];
                        int id = Integer.parseInt(parts[2]);
                        
                        Name name = new Name(firstName,lastName,id);
                        this.addCustomer(name);

	}
    
    public void readCustomerFile(String filename) {
            try {
                File f = new File("C:/Users/uchea/Desktop/Drive/F21AS/CoffeeShop/resources/"+filename);
                //File f = new File(filename);
                Scanner scanner = new Scanner(f);    
                while (scanner.hasNextLine()) { 
                    String inputLine = scanner.nextLine(); 
                    if (inputLine.length() != 0) {
                    processMenuLine(inputLine);     
                    }    
                }   
            } 
            catch (FileNotFoundException fnf){     
                System.out.println(filename + " not found ");     
                System.exit(0);    
            }  
        }

//     public void showAllCustomer(Customer[] customers) {

//         for (int i = 0 ; i < customers.length; i++){
//             System.out.println("Customer ID: " + customers[i].customerID + " Name: " + customers[i].name + " Email Address: " + customers[i].emailaddress
//                     + " Discounts Earned: " + customers[i].discountearned + " Total Orders: " + customers[i].totalorders);
//         }

//     }


}
