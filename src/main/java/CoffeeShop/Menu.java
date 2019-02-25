
package CoffeeShop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

class Menu {
    
    private ArrayList<MenuItem> menuItem;
    
    public Menu(){
        
        menuItem = new ArrayList();
    }
    
    public boolean addMenuItem(MenuItem i) {   
           String id = i.getId();
           MenuItem inList = this.searchID(id);  
                    if (inList == null) {   
                    menuItem.add(i);
                      return true;  
                    }  
                    return false;
           }
    
    public boolean removeMenuItem(MenuItem i){
        String id = i.getId();
           MenuItem inList = this.searchID(id);  
                    if (inList != null) {   
                    menuItem.remove(i);
                      return true;  
                    }  
                    return false;
    }
    
    public MenuItem searchID(String id){
              for (MenuItem i : menuItem)
              {       
                  if (i.getId().equals(id)){
                      return i;
                  }       
              }      return null;    
          }
    
    public String searchIDToString(String id){
              for (MenuItem i : menuItem)
              {       
                  if (i.getId().equals(id)){
                      return i.toString();
                  }
                  
              }      return null;    
          }
    
    public MenuItem searchItem(String item){
              for (MenuItem i : menuItem)
              {       
                  if (i.getItem().equals(item)){
                      return i;
                  }
                  
              }      return null;    
          }
    
    public MenuItem searchItemByCategory(String category, String item){  
            ArrayList<MenuItem>report = searchCategory(category);
              for (MenuItem i : report)
              {       
                  if (i.getItem().equals(item)){
                      return i;
                  }
                  
              }      return null;    
          }
    
    public ArrayList searchCategory(String category){
            //String report = "";
            ArrayList<MenuItem>report = new ArrayList();
              for (MenuItem i : menuItem)
              {       
                  if (i.getCategory().equals(category)){
                      report.add(i);
                      //report += i;
                  }
                  
              }      return report;    
          }
    
    public ArrayList listAllNames()
	{
            ArrayList<MenuItem>report = new ArrayList();
            menuItem.stream().forEach((m) -> {
                report.add(m);
        });
		return report;
	}
    
    public ArrayList getList(){
        ArrayList<MenuItem>report = new ArrayList();
        menuItem.stream().forEach((i) -> {
            report.add(i);
        });
        return report;
    }
    
    public static void writeToFile(String filename, String Menu) {
        FileWriter fw;
        try {
            //fw = new FileWriter("C:/Users/uchea/Desktop/Drive/F21AS/CoffeeShop/resources/"+filename);
            fw = new FileWriter(System.getProperty("user.dir")+"\\resources\\"+filename);
            fw.write(Menu);
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
                        String category = parts[0];
                        String item = parts[1];
                        double cost = Double.parseDouble(parts[2]);
                        String id = parts[3];
                        
                        MenuItem menuItem = new MenuItem(category,item,cost,id);
                        this.addMenuItem(menuItem);

	}
    
    public void readMenuFile(String fileName) {
            
        try {
                
                //File f = new File("C:/Users/uchea/Desktop/Drive/F21AS/CoffeeShop/resources/"+filename);
                //File f = new File(System.getProperty("user.dir")+"\\resources\\"+filename);
                //File f = new File("C:/Users/uchea/Desktop/Drive/F21AS/CoffeeShop/resources/data1.csv");
                
                ClassLoader classLoader = new Menu().getClass().getClassLoader();
                File file = new File(classLoader.getResource(fileName).toURI());
                
                Scanner scanner = new Scanner(file);    
                while (scanner.hasNextLine()) { 
                    String inputLine = scanner.nextLine(); 
                    if (inputLine.length() != 0) {
                    processMenuLine(inputLine);
                    }    
                }
                scanner.close();

            } catch (IOException | URISyntaxException e){
                System.out.println(fileName + " not found in Menu class");     
                System.exit(0);    
            }

        }
}
