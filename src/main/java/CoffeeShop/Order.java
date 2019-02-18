

package CoffeeShop;

/**
 *
 * @author Dare Adewoye
 */


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

class Order{
    
    int customerId;
    Name name;
    Customer customer;
    String menuId;
    double cost;
    Menu menu;
    MenuItem menuItem;
    
    public Order(String itemId, double cost){
        
        menu = new Menu();
        menu.readMenuFile("data1.csv");  
        if(menu.searchID(menuId)!= null){
         this.menuId = itemId;
         this.cost = menu.searchID(itemId).getCost();
        }
            
    }
    
    public String getMenuId(){
    return menuId;
    }
    
    public double getCost(){
    return cost;
    }
    
    public String toString(){
    Date d = new Date();    
    return menuId + cost + d.toString();
    }
    
    }


