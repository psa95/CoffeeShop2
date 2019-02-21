
package CoffeeShop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

class OrderList{
    
    private double cost;
    private HashMap <String, Order> listOrder;
    private Order order;
    private String orderId;
    private Customer customer;
    private HashMap <Integer, ArrayList<Order>> customerKeyMap;
    
    public OrderList(){
        customer = new Customer();
        customer.readCustomerFile("customer list.csv");
        listOrder = new HashMap<>();
        customerKeyMap = new HashMap<>();
    }
    
    public double getCost(){
        return cost;
    }
    
    public void add(Order order) {
        int id = order.getCustomerId();
        if (!customerKeyMap.containsKey(id))
            customerKeyMap.put(id, new ArrayList<>());
        customerKeyMap.get(id).add(order);
    }
    
    private void clearMap(){
        customerKeyMap.clear();
        listOrder.clear();
    }

    public List<Order> customersById(int id) {
        return customerKeyMap.containsKey(id) ? customerKeyMap.get(id) : new ArrayList<>(); 
    }
    
    public String list(){
        String report = "";
        for (int i : customerKeyMap.keySet()) {
            cost=0;
            report += "Customer Id: "+i+"\n";
        //System.out.println("Current key: " + i); //Optional for better understanding
            for (Order o : customerKeyMap.get(i)) {
                //System.out.println(o.toString());
                cost += o.getCost();
                report += o.toString()+"\n";
            }   report+="Total order: "+getCost()+"\t 20% Discounted cost: "+ discount()+"\n\n";
    }
        return report;
    }
    
    private double discount(){
        if(cost >= 100.00){
            return cost-(0.2*cost);
        }
        return 0.0;
    }

    public boolean containsKey(int id) {
        return customerKeyMap.containsKey(id); 
    }
    
    public boolean addOrder(Order order){
        listOrder.put(String.valueOf(order.getCustomerId())+order.getMenuId(),  order);
        return true;
    }
    
    public void listMapValues(){
        listOrder.keySet().stream().forEach((Key) -> {
            Order order = listOrder.get(Key);
            System.out.println("Key:" + Key);
            System.out.println("Value: "+ order);
        });
    }
    
    public String getSalesByCustomer(int id){
        String report = "";
        cost=0;
        for(Entry<Integer,ArrayList<Order>> entry: customerKeyMap.entrySet()){
                int key = entry.getKey();    
                if(id == entry.getKey())
                    {
                        System.out.println(customer.searchID(id).getName());
                        ArrayList<Order> order = entry.getValue();
                        for(Order aString : order){   
                        //System.out.println("key : " + key + " value : " + aString);
                        cost += aString.getCost();
                        report += "Order: " + aString+"\n";
                        }
                    }
                }
        //System.out.println(getCost());
        return report;
    }
    
    
    public String getSalesByItems(String id){
        String report="";
        cost=0;
        int count=0;
        for(Entry<String,Order> entry: listOrder.entrySet()){
                String key = entry.getValue().getItem();    
                if(id.equals(key))
                    {
                           Order value = entry.getValue();
                           cost += value.getCost();
                           count++;
                           report += value.toString() +"\n";
                    }
                }
        //System.out.println(getCost());
//        for (String key : listOrder.keySet()) {
//        System.out.println(key + " : " + listOrder.get(key).toString());
//}
        return report;
    }
    
    
    public String getTotalSales(){
        String report="";
        cost=0;
        int count=0;
        for(Entry<String,Order> entry: listOrder.entrySet()){
                           Order value = entry.getValue();
                           cost += value.getCost();
                           count++;
                           report += value.toString()+"\n";
                }
        return report;
    }
    
    private void processMenuLine(String line) {
        
			String parts [] = line.split(",");
                        int id = Integer.parseInt(parts[0]);
                        String itemId = parts[1];
                        String item = parts[2];
                        double cost = Double.parseDouble(parts[3]);
                        String date = parts[4];
                        
                        Order order = new Order(id,itemId,item,cost,date);
                        this.addOrder(order);
                        this.add(order);

	}
    
    public void readOrderFile(String filename) {
        //clearMap();
            try {
                
                //File f = new File("C:/Users/uchea/Desktop/Drive/F21AS/CoffeeShop/resources/"+filename);
                File f = new File(System.getProperty("user.dir")+"\\resources\\"+filename);
                Scanner scanner = new Scanner(f);    
                while (scanner.hasNextLine()) { 
                    String inputLine = scanner.nextLine(); 
                    if (inputLine.length() != 0) {
                    processMenuLine(inputLine);     
                    }    
                }   
            } 
            catch (FileNotFoundException fnf){     
                System.out.println(filename + " not found ");     
                System.exit(0);    
            }  
        }
    
    public void writeToFile(String filename, String Menu) {
        FileWriter fw;
        try {
            //fw = new FileWriter("C:/Users/uchea/Desktop/Drive/F21AS/CoffeeShop/resources/"+filename, true);
            fw = new FileWriter(System.getProperty("user.dir")+"\\resources\\"+filename,true);
            fw.write(Menu);
            fw.close();
            }
		 //message and stop if file not found
		 catch (FileNotFoundException fnf){
			 System.out.println(filename + " not found ");
			 System.exit(0);
		 }
		 //stack trace here because we don't expect to come here
		 catch (IOException ioe){
		    ioe.printStackTrace();
		    System.exit(1);
		 }
	}
    
    public static void main(String[] args) {
       OrderList o = new OrderList();
       o.readOrderFile("order list.csv");
       System.out.println(o.list());
    }
}