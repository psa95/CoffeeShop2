
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
     * Open given file and return a file object
     */
    private File getFileHandle(String fileName){
        try{
            
            ClassLoader classLoader = new Menu().getClass().getClassLoader();
            File file = new File(classLoader.getResource(fileName).toURI());

            // For none buildtool users on windows
            String isWindows = System.getProperty("os.name").toLowerCase();
            if(isWindows.contains("win")){
                // We are on windows; create windows specific file handle
            }

            return file;

        } catch(URISyntaxException e) {
            
            e.printStackTrace();
            return null;

        }

    }

    /**
     * Returns an ArrayList of customers to the caller.
     */
    public ArrayList<?> getCustomers(){
        // Read CSV and return it's contents as an array list
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
      public ArrayList<?> getPreviousOrders(){
        return new ArrayList();
      }

      // New orders temporary file
      private File newOrders = File.createTempFile("newOrders", "txt");

      /**
       * Create a temporary file to store fresh orders.
       * This needs to be thread-safe.
       */
      public synchronized void addOrders(ArrayList<?> order){

      }

      /**
       * Generate report of past and current orders.
       * @return ArrayList
       */
      public ArrayList<?> generateReport(){
          return new ArrayList();
      }


}