package CoffeeShop.Model;

import java.util.Date;

public class PendingOrder {

    private int customerID;
    private int NumberOfItems;
    private Date orderDate;

    public PendingOrder(int id, Date orderDate){
        this.customerID = id;
        this.NumberOfItems = 0;
        this.orderDate = orderDate;
    }
    public void incrementItems(){
        this.NumberOfItems++;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getNumberOfItems() {
        return NumberOfItems;
    }

    public Date getOrderDate() {
        return orderDate;
    }

}
