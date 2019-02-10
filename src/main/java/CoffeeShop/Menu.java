
package CoffeeShop;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
    
    public MenuItem searchID(String number){
              for (MenuItem i : menuItem)
              {       
                  if (i.getId().equals(number)){
                      return i;  }
                  
              }      return null;    
          }  
    
    public void addMenuItems(MenuItem i){
        menuItem.add(i);
           }
    
    public static void writeToFile(String filename, String Menu) {
        FileWriter fw;
        try {
            fw = new FileWriter(filename);
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
    
    public static void main(String[] args) {
        MenuItem menuItem = new MenuItem("Category","item000",23.50f,"1234");
        //System.out.println(menuItem.toString());
        //System.out.println(menuItem.getCategory()+","+menuItem.getItem()+","+menuItem.getCost()+","+menuItem.getId());
        String report = menuItem.getCategory()+","+menuItem.getItem()+","+menuItem.getCost()+","+menuItem.getId();
        System.out.println(report);
        writeToFile("Menu.txt", report);
    }
}
