
package CoffeeShop.Controllers;

import CoffeeShop.Model.CoffeeShopModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

public enum Customer{
    
    INSTANCE;

    public static Customer getInstance(){
        return INSTANCE;
    }
    
  private ArrayList<Name> name;
  
  private Customer(){
      name = new ArrayList();
      CoffeeShopModel.INSTANCE.getCustomers().stream().forEach((s) -> {
            String s1 = String.join(",",s);
            String parts [] = s1.split(",");
            Name name = new Name(parts[0],parts[1],Integer.parseInt(parts[2]));
            this.addCustomer(name);
        });
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
                  if (n.getfirstName().equalsIgnoreCase(name)||n.getlastName().equalsIgnoreCase(name)){
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
    
    public ArrayList getCustomers(){
            ArrayList<Name> report = new ArrayList();
              for (Name n : name)
              {
                  report.add(n);   
              }
              return report;    
          }
    
//    public static void writeToFile(String filename, String Customer) {
//        FileWriter fw;
//        try {
//            fw = new FileWriter(filename);
//            fw.write(Customer);
//            fw.close();
//            }
//		 //message and stop if file not found
//		 catch (FileNotFoundException fnf){
//			 System.out.println(filename + " not found ");
//			 System.exit(0);
//		 }
//		 //stack trace here because we don't expect to come here
//		 catch (IOException ioe){
//		    ioe.printStackTrace();
//		    System.exit(1);
//		 }
//	}
//    
//    private void processMenuLine(String line) {
//        
//			String parts [] = line.split(",");
//            String firstName = parts[0];
//            String lastName = parts[1];
//            int id = Integer.parseInt(parts[2]);
//            
//            Name name = new Name(firstName,lastName,id);
//            this.addCustomer(name);
//
//	}
//    
//    private void processCustomerModel(){
//        
//        CoffeeShopModel.INSTANCE.getPreviousOrders().stream().forEach((s) -> {
//             System.out.println(String.join(", ",s));
//        });
//    }
    
//    public void readCustomerFile(String fileName) {
//            try {
//                File file = new File("C:\\Users\\uchea\\Desktop\\Drive\\CoffeeShop2\\src\\main\\resources\\"+fileName);
//                // File file = new File(System.getProperty("user.dir")+File.separator+"data"+File.separator+fileName);
//                //File f = new File(filename);
//
////                ClassLoader classLoader = new Menu().getClass().getClassLoader();
////                File file = new File(classLoader.getResource(fileName).toURI());
//
//                Scanner scanner = new Scanner(file);    
//                while (scanner.hasNextLine()) { 
//                    String inputLine = scanner.nextLine(); 
//                    if (inputLine.length() != 0) {
//                    processMenuLine(inputLine);     
//                    }    
//                }
//                scanner.close();
//                
//            } 
//            //catch (IOException | URISyntaxException nf){     
//            catch (IOException nf){     
//                System.out.println(fileName + " not found ");     
//                System.exit(0);
//            }  
//        }
}
