

package CoffeeShop;

/**
 *
 * @author Dare Adewoye
 */


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Order{
    
    
    private String item;
    private String menuId;
    private double cost;
    private Menu menu;
    private Customer customer;
    int customerId;
    DateFormat df;
    Date date;
    
    public Order(int customerId, String itemId, String item, double cost, String date){
        
        customer = new Customer();
        customer.readCustomerFile("customer list.csv");
        
        df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        menu = new Menu();
        menu.readMenuFile("data1.csv");  
        if(menu.searchID(itemId)!= null&&customer.searchID(customerId)!=null){
         this.menuId = itemId;
         this.customerId = customerId;
         this.cost = menu.searchID(itemId).getCost();
         this.item = menu.searchID(itemId).getItem();
            try { 
                this.date = df.parse(date);
            } catch (ParseException ex) {}
        }        
    }
    
    public String getMenuId(){
    return menuId;
    }
    
    public int getCustomerId(){
    return customerId;    
    }
    
    public double getCost(){
    return cost;
    }
    
    public String getItem(){
    return item;
    }
    
    public String toString(){    
    return customerId + " " + menuId + " " + item + " " + cost + " " + df.format(date);
    }
    
    
    }



