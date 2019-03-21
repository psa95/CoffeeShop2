package CoffeeShop.Controller;

import CoffeeShop.Model.*;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ServerController implements Runnable {

        private boolean isBusy;
        private boolean orderPrepared;
        private boolean orderIsEmpty;
        private int serverId;
        private ArrayList<PendingOrder> totalOrderList;
        private ArrayList<Order> currentOrderList;
        private int customerID;
        private  int tempCustomerID;
        private Date tempDate;
        private Date date;
        private DateFormat df;
        private Customer customers;

        public ServerController(int id) {
            isBusy = false;
            orderPrepared = false;
            serverId = id;
            df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            currentOrderList = new ArrayList<>();
            totalOrderList = new ArrayList<>();
            customers = new Customer();
            this.orderIsEmpty = false;

        }

        public  synchronized  void DisplayWaitingList(){
            System.out.println("There are currently "+this.totalOrderList.size()+ "waiting in the queue :");
            for(PendingOrder p : this.totalOrderList){
                Name customerName = customers.searchID(p.getCustomerID());
                System.out.println(customerName.getName() + "\t" +p.getNumberOfItems()+" items \n");
            }
        }
    public synchronized void PrepareOrder( int customerId, ArrayList<Order> orders) {
        int cost = 0;
        Properties prop = new Properties();
        String prop_filename = "config.properties";
        InputStream input = getClass().getClassLoader().getResourceAsStream(prop_filename);
        try {
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        File logFile = new File(System.getProperty("user.dir")+ prop.getProperty("ResourceLocation")+"log.txt");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(logFile,true));
            System.out.println("Server"+ serverId);
            Name customerName = customers.searchID(customerId);
            writer.write("Server "+serverId+" started processing "+ customerName.getName() +"'s order\n");
            System.out.println("Processing "+ customerName.getName() +"'s order");
            for(Order order: orders) {
                System.out.println("1 "+order.getItem());
                writer.write("1 "+ order.getItem() + " is getting prepared\n");
                cost+=order.getCost();
            }
            writer.write("Order prepared and served\n");
            System.out.println("Total : "+cost);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


        public synchronized void readOrderFromFile() {
            Properties prop = new Properties();
            String prop_filename = "config.properties";
            InputStream input = getClass().getClassLoader().getResourceAsStream(prop_filename);
            try {
                prop.load(input);
            } catch (IOException e) {
                e.printStackTrace();
            }

            ArrayList<String[]> wholeCSV = new ArrayList<>();
            File file = new File(System.getProperty("user.dir") + prop.getProperty("ResourceLocation") + "orderList.csv");

            this.orderIsEmpty = file.length() == 0;
            if(this.orderIsEmpty)
            {
                return;
            }
            try (Scanner inputStream = new Scanner(file)) {
                while (inputStream.hasNext())

                    wholeCSV.add(inputStream.nextLine().split(","));

            } catch (IOException e) {

                e.printStackTrace();

            }
            PendingOrder p = null;
            for (int i = 0; i < wholeCSV.size(); i++) {
                String s1 = String.join(",", wholeCSV.get(i));
                String parts[] = s1.split(",");
                if (i == 0) {
                    this.customerID = Integer.parseInt(parts[0]);
                    this.tempCustomerID = Integer.parseInt(parts[0]);
                    try {
                        this.date = df.parse(parts[4]);
                        this.tempDate = df.parse(parts[4]);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    p = new PendingOrder(this.tempCustomerID,this.tempDate);

                }
                Order order = new Order(Integer.parseInt(parts[0]), parts[1], parts[4]);
//                System.out.println("Test: " + currentOrderList.toString());
                if ((this.customerID == order.getCustomerId()) && (this.date.compareTo(order.getDate()) == 0)) {
                    currentOrderList.add(order);
                }
                if((this.tempCustomerID == order.getCustomerId()) && (this.tempDate.compareTo(order.getDate()) == 0)){
                    p.incrementItems();
                }
                else{
                    this.totalOrderList.add(p);
                    this.tempCustomerID = order.getCustomerId();
                    this.tempDate = order.getDate();
                    p = new PendingOrder(this.tempCustomerID,this.tempDate);
                }
            }
        }
        public synchronized void writeOrderToFile() {
            Properties prop = new Properties();
            String prop_filename = "config.properties";
            InputStream input = getClass().getClassLoader().getResourceAsStream(prop_filename);
            try {
                prop.load(input);
            } catch (IOException e) {
                e.printStackTrace();
            }

            File inputFile = new File(System.getProperty("user.dir") + prop.getProperty("ResourceLocation") + "orderList.csv");
            File tempFile = new File(System.getProperty("user.dir") + prop.getProperty("ResourceLocation") +"myTempFile.csv");
            int noOfLinesToRemove = 0 ;
            for(PendingOrder p : this.totalOrderList) {
                if (this.customerID == p.getCustomerID() && (this.date.compareTo(p.getOrderDate())==0)) {
                    noOfLinesToRemove = p.getNumberOfItems();
                }
            }
            BufferedReader reader = null;
            try {
                int count =1;
                reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
                String currentLine;
                while((currentLine = reader.readLine()) != null) {
                    // trim newline when comparing with lineToRemove
                    if(count <= noOfLinesToRemove) {
                        count++;
                        if(this.totalOrderList.size()==1){
                            break;
                        }
                        continue;
                    }
                    writer.write(currentLine + System.getProperty("line.separator"));
                    count ++;
                }
                writer.close();
                reader.close();
                inputFile.delete();
                boolean successful = tempFile.renameTo(inputFile);
                if (!successful) {
                    // File was not successfully renamed
                    System.out.println("File not renamed");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public synchronized void GetOrder() {
            if(this.isBusy & !this.orderPrepared) {
                this.readOrderFromFile();
                this.writeOrderToFile();
                this.DisplayWaitingList();
                this.PrepareOrder(this.customerID, this.currentOrderList);
                this.Clear();
            }
        }
        public synchronized  void Clear(){
            this.currentOrderList.clear();
            this.totalOrderList.clear();
        }
        public void run() {
                try {
                    while(!orderIsEmpty) {
                        this.isBusy = true;
                        this.GetOrder();
                        this.orderPrepared = true;
                        Thread.sleep(5000);
                        this.isBusy = false;
                        this.orderPrepared = false;

                    }
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
    }

