package CoffeeShop;

class Customer {

    private int customerID;
    private String name;
    private String emailaddress;
    private double discountearned;
    private int totalorders;

    Customer(int customerID, String name, String emailaddress, double discountearned, int totalorders  ) {
        this.customerID = customerID;
        this.name = name;
        this.emailaddress = emailaddress;
        this.discountearned = discountearned;
        this.totalorders = totalorders;
    }

    public int getCustomerID(){
        return this.customerID;
    }

    public void setCustomerID(int customerID){
        this.customerID = this.customerID;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmailaddress(){
        return this.emailaddress;
    }

    public void setEmailaddress(String emailaddress){
        this.emailaddress = emailaddress;
    }

    public double getDiscountearned(){
        return this.discountearned;
    }

    public void setDiscountearned(double discountearned){
        this.discountearned = discountearned;
    }

    public int getTotalorders(){
        return this.totalorders;
    }

    public void setTotalorders(int totalorders){
        this.totalorders = totalorders;
    }

    public Customer searchCustomer (Customer[] customers, String customerName){
        int index = -1;
        for (int i = 0 ; i < customers.length; i++){
            if(customers[i].name.equals(customerName)){
                index = i;
            }
        }
        return customers[index];
    }
    ///Polymorphism
    public Customer searchCustomer (Customer[] customers, int customerID){
        int index = -1;
        for (int i = 0 ; i < customers.length; i++){
            if(customers[i].customerID == customerID){
                index = i;
            }
        }
        return customers[index];
    }

    public void showAllCustomer(Customer[] customers) {

        for (int i = 0 ; i < customers.length; i++){
            System.out.println("Customer ID: " + customers[i].customerID + " Name: " + customers[i].name + " Email Address: " + customers[i].emailaddress
                    + " Discounts Earned: " + customers[i].discountearned + " Total Orders: " + customers[i].totalorders);
        }

    }


}