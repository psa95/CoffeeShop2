
package CoffeeShop.Model;


import CoffeeShop.Controllers.Order;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.lang.ClassLoader;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Offers data services to the CoffeeShop package.
 * The Model in the MVC of CoffeeShop.
 * Implements the singleton design pattern using an enum.
 */
public enum CoffeeShopModel implements ModelInterface {

    /* The Singleton implementation */
    INSTANCE;

    public static CoffeeShopModel getInstance(){
        return INSTANCE;
    }
    /**************/

    // Temporary files, created and deleted on program exit
    File currentOrders = null;
    File log = new File("log.csv");

    private CoffeeShopModel(){

        try{

            // Initialize the temporary files
            this.currentOrders = File.createTempFile("currentOrders", null);

            // Set them to delete on program exit
            this.currentOrders.deleteOnExit();

        } catch(IOException e){
            e.printStackTrace();
        }

    }

    /**
     * Open given file and return an array iterator.
     */
    private synchronized ArrayList<String[]> getCSVAsArrays(String fileName){

        //ClassLoader classLoader = this.getClass().getClassLoader();
        ArrayList<String[]> wholeCSV = new ArrayList<>();
        //File file = new File("C:\\Users\\uchea\\Desktop\\Drive\\CoffeeShop2\\src\\main\\resources\\"+fileName);
        File file = new File(System.getProperty("user.dir")+"\\resources\\"+fileName);

        // // For none buildtool on windows
        // String isWindows = System.getProperty("os.name").toLowerCase();
        // if(isWindows.contains("win")){
        //     // We are on windows; create windows specific file handle
        //     // redefine filePath as a string
        //     //String filePath = System.getProperty("user.dir")+File.separator+"data"+File.separator+fileName;
        //     // Can someone on windows confirm this is working?
        // }

        //try(Scanner inputStream = new Scanner(new File(classLoader.getResource(fileName).toURI()))){
        try(Scanner inputStream = new Scanner(file)){

            while(inputStream.hasNext())
                
                wholeCSV.add(inputStream.nextLine().split(","));
            
            return wholeCSV;

        //} catch(URISyntaxException | IOException e) {
        } catch(IOException e) {
            
            e.printStackTrace();
            return null;

        }

    }

    /**
     * Takes a two dimensional array and appends it to the given file.
     * This needs to be thread-safe.
     * This locks the entire instance when run
     */
    private synchronized void writeArrayToCSV(String[] toWrite, String fileName) throws IOException {
        
        FileWriter fileToWriteTo = null;

        System.out.println(this.currentOrders);

        switch(fileName){
            case "order":
                fileToWriteTo = new FileWriter(this.currentOrders, true); // Append mode
                break;
            case "log":
                fileToWriteTo = new FileWriter(this.log, true); // Append mode
                break;
        }

        BufferedWriter writer = new BufferedWriter(fileToWriteTo);
        writer.write(String.join(",", toWrite)+System.lineSeparator());
        writer.close();

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
    public ArrayList<String[]> getMenu(){
        return getCSVAsArrays("menu.csv");
    }

     /**
      * Returns ArrayLits of previous orders.
      */
    public ArrayList<String[]> getPreviousOrders(){
        return getCSVAsArrays("orderList.csv");
    }

    // New orders temporary file
    //private File newOrders = File.createTempFile("newOrders", "txt");

    /**
     * Create a temporary file to store fresh orders.
     * Takes and Array of Strings of an array of strings.
     * Converts that to a csv string and appends to the current orders
     * This needs to be thread-safe.
     * Locks entire instance when accessed
     */
    public void addOrder(String[] order){
        try{
            writeArrayToCSV(order, "order");
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Return all current orders.
     * @return ArrayList
     */
    public synchronized ArrayList<String[]> getOrders(){
        // TO-DO: Get this to use getCSVAsArrays()

        ArrayList<String[]> currentOrders = new ArrayList<>();
        try(Scanner reader = new Scanner(this.currentOrders)){
            while(reader.hasNext()){
                currentOrders.add(reader.next().split(","));
            }
            return currentOrders;
        } catch(IOException e){
            e.printStackTrace();
            return null;
        }

    }

    /**
     * Write to log (requirement 5)
     * Locks entire instance when accessed
     * Takes String[]{"time", "string"}
     */
    public void writeToLog(String[] toLog){
        try{
            writeArrayToCSV(toLog, "log");
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    // /**
    //  * Read from the log
    //  */
    // public synchronized ArrayList<String[]> readLog(){
    //     // TO-DO: Get this to use writeArrays()
    //     ArrayList<String[]> logs = new ArrayList<>();
    //     try(Scanner reader = new Scanner(this.log)){
    //         while(reader.hasNext()){
    //             logs.add(reader.next().split(","));
    //         }
    //         return logs;
    //     } catch(IOException e){
    //         e.printStackTrace();
    //         return null;
    //     }
    // }
    // Commented out, not required by spec

}
