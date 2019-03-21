
package CoffeeShop.Model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order{
    
    
    private String item;
    private String menuId;
    private double cost;
    private Menu menu;
    private Customer customer;
    private int customerId;
    private DateFormat df;
    private Date date;
    
    public Order(int customerId, String itemId, String date){

        menu = new Menu();
        customer = new Customer();
        df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        if((menu.searchID(itemId)!= null)&&customer.searchID(customerId)!=null){
         this.menuId = itemId;
         this.customerId = customerId;
         this.cost = menu.searchID(itemId).getCost();
         this.item = menu.searchID(itemId).getItem();
            try { 
                this.date = df.parse(date);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
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

    public Date getDate(){
        return date;
    }
    
    public String toString(){    
    return customerId + "\t" + menuId + "\t" + item + "\t\t" + cost + "\t" + df.format(date);
    }
    
    
    }

