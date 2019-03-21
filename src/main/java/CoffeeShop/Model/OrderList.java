
package CoffeeShop.Model;

import java.io.*;
import java.util.*;

public class OrderList{
    
    private double totalcost;
    private HashMap <String, Order> listOrder;
    private HashMap <Integer, ArrayList<Order>> customerKeyMap;
    
    public OrderList(){
        this.listOrder = new HashMap<>();
        this.customerKeyMap = new HashMap<>();
        this.ReadOrderListFile();
    }

    private void ReadOrderListFile(){
        Properties prop = new Properties();
        String prop_filename = "config.properties";
        InputStream input = getClass().getClassLoader().getResourceAsStream(prop_filename);
        try {
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<String[]> wholeCSV = new ArrayList<>();
        File file = new File(System.getProperty("user.dir")+prop.getProperty("ResourceLocation")+"orderList.csv");

        try(Scanner inputStream = new Scanner(file)){

            while(inputStream.hasNext())

                wholeCSV.add(inputStream.nextLine().split(","));

        } catch(IOException e) {

            e.printStackTrace();

        }
        wholeCSV.stream().forEach((s) -> {
            String s1 = String.join(",",s);
            String parts [] = s1.split(",");
            Order order = new Order(Integer.parseInt(parts[0]),parts[1],parts[4]);
            this.addOrder(order);
            this.add(order);
        });
    }

    private  void WriteOrderListFile(String[] toWrite, String fileName,File tempFile) throws IOException {
        FileWriter fileToWriteTo = null;

        System.out.println(tempFile);
        fileToWriteTo = new FileWriter(tempFile, true); // Append mode

        BufferedWriter writer = new BufferedWriter(fileToWriteTo);
        writer.write(String.join(",", toWrite));
        writer.close();
    }

    public void addOrderFile(String[] order,File tempFile){
        try{
            WriteOrderListFile(order, "order",tempFile);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public double getCost(){
        return this.totalcost;
    }
    
    public void add(Order order) {
        int id = order.getCustomerId();
        if (!this.customerKeyMap.containsKey(id))
            this.customerKeyMap.put(id, new ArrayList<>());
        this.customerKeyMap.get(id).add(order);
    }
    
    private void clearMap(){
        this.customerKeyMap.clear();
        this.listOrder.clear();
    }

    public String getTotalSales(){
        String report="";
        this.totalcost=0;
        for(Map.Entry<String,Order> entry: listOrder.entrySet()){
            Order value = entry.getValue();
            this.totalcost += value.getCost();
            report += value.toString()+"\n";
        }
        return report;
    }

    private double discount(){
        if(this.totalcost >= 100.00){
            return this.totalcost-(0.2*this.totalcost);
        }
        return 0.0;
    }
    
    private boolean addOrder(Order orderItem){
        this.listOrder.put(orderItem.getCustomerId()+orderItem.getMenuId()+orderItem,orderItem);
        return true;
    }

    //Prints out cutomers from key map
    public String list(){
        String report = "";
        for (int i : customerKeyMap.keySet()) {
            this.totalcost=0;
            report += "Customer Id: "+i+"\n";
            //System.out.println("Current key: " + i); //Optional for better understanding
            for (Order o : customerKeyMap.get(i)) {
                //System.out.println(o.toString());
                this.totalcost += o.getCost();
                report += o.toString()+"\n";
            }   report+="Total order: "+getCost()+"\t 20% Discounted cost: "+ discount()+"\n\n";
        }
        return report;
    }

    public String getSalesByItems(String id){
        String report="";
        this.totalcost=0;
        int count=0;
        for(Map.Entry<String,Order> entry: listOrder.entrySet()){
            String key = entry.getValue().getItem();
            if(id.equals(key))
            {
                Order value = entry.getValue();
                this.totalcost += value.getCost();
                count++;
                report += value.toString() +"\n";
            }
        }
        return report;
    }
}