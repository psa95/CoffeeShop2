
package CoffeeShop.Model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private ArrayList<MenuItem> menu;
    
    public Menu(){


        menu = new ArrayList<>();
        this.ReadMenuFile();
    }

    private void ReadMenuFile(){
        ArrayList<String[]> wholeCSV = new ArrayList<>();
        File file = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\"+"menu.csv");

        try(Scanner inputStream = new Scanner(file)){
            while(inputStream.hasNext())
                wholeCSV.add(inputStream.nextLine().split(","));
        } catch(IOException e) {
            e.printStackTrace();
        }
        wholeCSV.stream().forEach((s) -> {
            String s1 = String.join(",",s);
            String parts [] = s1.split(",");
            MenuItem menuItem = new MenuItem(parts[0],parts[1],Double.parseDouble(parts[2]),parts[3]);
            this.addMenuItem(menuItem);
        });
    }
    
    public void addMenuItem(MenuItem i) {
           String id = i.getId();
           MenuItem inList = this.searchID(id);  
                    if (inList == null) {   
                    this.menu.add(i);
                    }
           }

    
    public MenuItem searchID(String id){
              for (MenuItem i : this.menu)
              {       
                  if (i.getId().equals(id)){
                      return i;
                  }       
              }      return null;    
    }

    public MenuItem searchItem(String item){
        for (MenuItem i : this.menu)
        {
            if (i.getItem().equals(item)){
                return i;
            }

        }      return null;
    }

    public ArrayList getMenuList(){
        return this.menu;
    }

    public ArrayList<MenuItem> searchCategory(String category){
        ArrayList<MenuItem> report = new ArrayList<>();
        for (MenuItem i : this.menu)
        {
            if (i.getCategory().equals(category)){
                report.add(i);
            }

        }      return report;
    }

    public boolean removeMenuItem(MenuItem i){
        String id = i.getId();
        MenuItem inList = this.searchID(id);
        if (inList != null) {
            this.menu.remove(i);
            return true;
        }
        return false;
    }

    public ArrayList getList(){
        ArrayList<MenuItem>report = new ArrayList<>();
        this.menu.stream().forEach((i) -> {
            report.add(i);
        });
        return report;
    }

    public ArrayList listAllNames()
    {
        ArrayList<MenuItem>report = new ArrayList<>();
        this.menu.stream().forEach((m) -> {
            report.add(m);
        });
        return report;
    }

}
