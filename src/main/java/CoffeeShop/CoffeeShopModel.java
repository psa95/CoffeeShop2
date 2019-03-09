
package CoffeeShop;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import java.net.URI;

import java.lang.ClassLoader;

/**
 * Offers data services to the CoffeeShop package.
 * The Model in the MVC of CoffeeShop.
 * Does not need extending, so it's final.
 */
public final class CoffeeShopModel{

    // Get the

    /**
     * Open given file and return an array iterator.
     */
    private ArrayList<String[]> getCSVAsArrays(String fileName){

        ClassLoader classLoader = this.getClass().getClassLoader();
        Object filePath = null;
        try{
            filePath = (URI)classLoader.getResource(fileName).toURI();
        } catch(URISyntaxException e){
            e.printStackTrace();
        }

        ArrayList<String[]> wholeCSV = new ArrayList<>();


        // For none buildtool on windows
        String isWindows = System.getProperty("os.name").toLowerCase();
        if(isWindows.contains("win")){
            // We are on windows; create windows specific file handle
            // redefine filePath as a string
            //String filePath = System.getProperty("user.dir")+File.separator+"data"+File.separator+fileName;
            // Can someone on windows confirm this is working?
        }

        try(Scanner inputStream = new Scanner(new File(filePath))){

            while(inputStream.hasNext())
                wholeCSV.add(inputStream.next().split(","));
            
            return wholeCSV;

        } catch(URISyntaxException | IOException e) {
            
            e.printStackTrace();
            return null;

        }

    }

    /**
     * Takes a two dimensional array and appends it to the given file.
     * This needs to be thread-safe.
     */
    private synchronized void writeArrayToCSV(String fileName){

    }

    /**
     * Everything from here down are basically getters and setters of the
     * above two methods.
     */

    /**
     * Returns an ArrayList of customers to the caller.
     */
    public ArrayList<String[]> getCustomers(){
        // Read CSV and return it's contents as an array list
        return getCSVAsArrays("customerList.csv");
    }

    /**
     * Returns ArrayList of menu items to the caller.
     */
     public ArrayList<?> getMenuItems(){
        return new ArrayList();
     }

     /**
      * Returns ArrayLits of previous orders.
      */
      public String[] getPreviousOrders(){
        return new String[]{"Hi", "There"};
      }

      // New orders temporary file
      //private File newOrders = File.createTempFile("newOrders", "txt");

      /**
       * Create a temporary file to store fresh orders.
       * This needs to be thread-safe.
       * Locks entire instance when accessed
       */
      public synchronized void addOrders(ArrayList<?> order){
        //   this.newOrders
      }

      /**
       * Generate report of past and current orders.
       * @return ArrayList
       */
      public ArrayList<?> getAllOrders(){
          return new ArrayList();
      }

      /**
       * Write to log (requirement 5)
       * Locks entire instance when accessed
       */
      public synchronized void writeToLog(ArrayList<String> toLog){

      }

      /**
       * Read from the log
       */
      public ArrayList<String> readLog(){
          return new ArrayList();
      }


}
