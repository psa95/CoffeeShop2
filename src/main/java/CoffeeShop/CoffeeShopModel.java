
package CoffeeShop;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * Offers data services to the CoffeeShop package.
 * The Model in the MVC of CoffeeShop.
 */
public class CoffeeShopModel{

    // Get the

    /**
     * Open given file and return an array iterator.
     */
    private File getCSVAsArray(String fileName){

        ClassLoader classLoader = new Menu().getClass().getClassLoader();

        String filePath = classLoader.getResource(fileName).toURI();

        // For none buildtool on windows
        String isWindows = System.getProperty("os.name").toLowerCase();
        if(isWindows.contains("win")){
            // We are on windows; create windows specific file handle
            filePath = System.getProperty("user.dir")+File.separator+"data"+File.separator+fileName;
            // Can someone on windows confirm this is working?
        }

        try(File file = new File(filePath)){

            return file;

        } catch(URISyntaxException | IOException e) {
            
            e.printStackTrace();
            return null;

        }

    }

    /**
     * Takes a two dimensional array and appends it to the given file.
     */
    private void writeArrayToCSV(String fileName){

    }

    /**
     * Everything from here down are basically getters and setters of the
     * above two methods.
     */

    /**
     * Returns an ArrayList of customers to the caller.
     */
    public ArrayList<?> getCustomers(){
        // Read CSV and return it's contents as an array list
        try(File )
        return new ArrayList();
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
        return String[];
      }

      // New orders temporary file
      private File newOrders = File.createTempFile("newOrders", "txt");

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
