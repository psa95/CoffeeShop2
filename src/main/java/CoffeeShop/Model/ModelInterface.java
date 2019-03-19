
package CoffeeShop.Model;

import java.util.ArrayList;

public interface ModelInterface {

    public ArrayList<String[]> getCustomers();
    public ArrayList<String[]> getMenu();
    public ArrayList<String[]> getPreviousOrders();
    public void addOrder(String[] order);
    public ArrayList<String[]> getOrders();
    public void writeToLog(String[] toLog);
    // public ArrayList<String[]> readLog();

}
