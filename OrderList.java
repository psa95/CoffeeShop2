
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
    private Map <Integer, ArrayList<Order>> customerKeyMap;
    
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
    
    public void list(){
        customerKeyMap.keySet().stream().map((i) -> {
            System.out.println("Current key: " + i);
            return i;
        }).forEach((i) -> {
            customerKeyMap.get(i).stream().forEach((order) -> {
                System.out.println(order.toString());
            });
 });
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
                
                File f = new File("C:/Users/uchea/Desktop/Drive/F21AS/CoffeeShop/resources/"+filename); 
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
            fw = new FileWriter("C:/Users/uchea/Desktop/Drive/F21AS/CoffeeShop/resources/"+filename, true);
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
    
    public void analyse(){
//        Iterator<Entry<Integer, List<Order>>> iterator = customerKeyMap.entrySet().iterator();
//            while(iterator.hasNext()){
//
//                   // Get the Entry from your Map and get the value from the Entry
//                   Entry<Integer, List<Order>> entry = iterator.next();
//                   List<Order> metricList = entry.getValue().getList();
//
//                   Iterator<String> metricIterator = metricList.iterator();
//
//                   //Above is the Array List I want to access and loop through
//                   //I will then perform certain checked against other values on a table...
//
//                    while (metricIterator.hasNext()) {
//                    //I will perform certain things here
//                    }
//            }
        //customerKeyMap.values().stream().flatMap(List::stream).forEach(System.out::println);
        for (Entry<Integer, ArrayList<Order>> entry : customerKeyMap.entrySet()) {
        int key = entry.getKey();
        ArrayList<Order> value = entry.getValue();
            for(Order aString : value){
                System.out.println("key : " + key + " value : " + aString);
            }
        }
    }
    
    
    
    public static void main(String[] args) {
        
        OrderList ol = new OrderList();
        ol.readOrderFile("Current order.csv");
        //ol.listMapValues();
        //System.out.println(ol.customersById(100));
        //System.out.println(ol.customersById(108));
        //System.out.println(ol.getSalesByCustomer(119));
        System.out.println(ol.getSalesByItems("cereals"));
        //ol.list();
        //ol.analyse();
        //System.out.println(ol.getTotalSales());
        
    }
            
}