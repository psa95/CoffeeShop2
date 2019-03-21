
package CoffeeShop.Model;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class Customer{

  private ArrayList<Name> customerList;
  public Customer(){
      this.customerList = new ArrayList<>();
      this.ReadCustomerListFile();
  }

    private void ReadCustomerListFile(){
        Properties prop = new Properties();
        String prop_filename = "config.properties";
        InputStream input = getClass().getClassLoader().getResourceAsStream(prop_filename);
        try {
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<String[]> wholeCSV = new ArrayList<>();
        File file = new File(System.getProperty("user.dir")+prop.getProperty("ResourceLocation")+"customerList.csv");

        try(Scanner inputStream = new Scanner(file)){

            while(inputStream.hasNext())

                wholeCSV.add(inputStream.nextLine().split(","));

        } catch(IOException e) {

            e.printStackTrace();

        }
        wholeCSV.stream().forEach((s) -> {
            String s1 = String.join(",",s);
            String parts [] = s1.split(",");
            Name name = new Name(parts[0],parts[1],Integer.parseInt(parts[2]));
            this.addCustomer(name);
        });
    }

    private void addCustomer(Name n) {
            int id = n.getId();
            Name inList = this.searchID(id);  
            if (inList == null) {
                this.customerList.add(n);
            }
    }
    
    public Name searchID(int id){
      for (Name i : this.customerList)
      {
          if (i.getId() == id){
              return i;
          }
      }
      return null;
          }

     public ArrayList<Name> getCustomerList(){
        return this.customerList;
     }

    public String listAllCustomers()
    {
        String separator = System.getProperty("line.separator");
        String list = "Customers"+separator;
        for (Name n : this.customerList){
            list += n.toString();
        }
        return list;
    }
}
