package CoffeeShop.Controller;

import CoffeeShop.Model.*;
import CoffeeShop.Model.Menu;
import CoffeeShop.Model.MenuItem;
import CoffeeShop.Views.CustomerUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.util.Scanner;

public class CustomerController {

    private CustomerUI customerUI;
    private Menu menu;
    private ArrayList<MenuItem> list;
    private double cost;
    private Date date;
    private DateFormat df;
    private MenuItem menuItem;
    private Name name;
    private Customer customer;
    private OrderList orderList;
    private File currentOrdersFile;

    public CustomerController(){
        customerUI = new CustomerUI();
        menu = new Menu();
        orderList = new OrderList();
        customer = new Customer();
        date = new Date();
        df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        try {
            currentOrdersFile = File.createTempFile("currentOrders", null);
            currentOrdersFile.deleteOnExit();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        customerUI.setCategoryStartersActionListener(new CategoryStartersSetListener());
        customerUI.setCategoryMainCourseActionListener(new CategoryMainCourseSetListener());
        customerUI.setCategoryDrinksActionListener(new CategoryDrinksSetListener());
        customerUI.setCategoryDessertActionListener(new CategoryDessertSetListener());
        customerUI.setMakeOrderActionListener(new MakeOrderSetListener());
        customerUI.setSearchActionListener(new SearchSetListener());
        customerUI.setSearchCustomerIDActionListener(new SearchCustomerIDSetListener());
        customerUI.setMenuItemsMouseListener(new MenuItemsSetMouseListener());
        resetDiscount();
    }

    private void resetDiscount(){
        cost = 0;
    }

    private void populateTable(String category)
    {

        customerUI.getModel().setRowCount(0);
        list = this.menu.searchCategory(category);
        Object[] rowData = new Object[4];
        for (MenuItem list1 : list) {
            rowData[0] = list1.getCategory();
            rowData[1] = list1.getItem();
            rowData[2] = list1.getCost();
            rowData[3] = list1.getId();
            customerUI.getModel().addRow(rowData);
        }
    }

    private  ArrayList<String[]> getOrders(){
        // TO-DO: Get this to use getCSVAsArrays()

        ArrayList<String[]> currentOrders = new ArrayList<>();
        try(Scanner reader = new Scanner(currentOrdersFile)){
            while(reader.hasNext()){
                currentOrders.add(reader.nextLine().split(","));
            }
            return currentOrders;

        } catch(IOException e){
            e.printStackTrace();
            return null;
        }

    }

    private void copyFile(String copy) throws IOException {
        File UIFile = new File(copy);
        FileWriter filewriter = new FileWriter(UIFile.getAbsoluteFile(),true);

        for(String[] s: this.getOrders()){
            try {
                filewriter.append(String.join(",", s)+"\n");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        filewriter.close();
    }

    private double totalCost(double cost){
        return this.cost += cost;
    }

    private double discount(){
        if(cost >= 100.00){
            return cost-(0.2*cost);
        }
        return 0.0;
    }

    private void clearOrderDetails(){
        customerUI.getTotalCost().setText("");
        customerUI.getDiscount().setText("");
        customerUI.getInfo().setForeground(Color.black);
        customerUI.getInfo().setText("Select category and select order ID");
        customerUI.getCustomerMenuSearch().setText("");
        menuItem = null;
        name = null;
        resetDiscount();
        customerUI.getCustomerLabel().setText("Wecome ");
        customerUI.getCustomerIDField().setText("");
        customerUI.getDisplayOrder().setText("");
    }

    private boolean validateNumber(String s) {
        Scanner scanner = new Scanner(s);
        int number;
        do {
            while (!scanner.hasNextInt()) {
                scanner.next();
                return false;
            }
            number = scanner.nextInt();
        } while (number < 0);
        return true;
    }


    public class CategoryStartersSetListener implements ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            populateTable("Starters");
        }
    }

    public class CategoryMainCourseSetListener implements ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            populateTable("Main Course");
        }
    }

    public class CategoryDrinksSetListener implements ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            populateTable("Drinks");
        }
    }

    public class CategoryDessertSetListener implements ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            populateTable("Desserts");
        }
    }

    public class MakeOrderSetListener implements ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent evt){
            if((menuItem != null) && (name != null)){

                Object[] options = {"Yes", "No"};
                int n = JOptionPane.showOptionDialog(null, "Confirm order?", null, JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
                if(n == JOptionPane.YES_OPTION){
                    try {
                        copyFile(System.getProperty("user.dir")+"\\src\\main\\resources\\orderList.csv");
                        clearOrderDetails();
                    } catch (IOException ex) {}
                }

            }
            else{
                customerUI.getInfo().setForeground(Color.red);
                customerUI.getInfo().setText("Select Order ID or enter customer ID");
            }
        }
    }

    public class SearchSetListener implements ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            customerUI.getInfo().setForeground(Color.black);
            customerUI.getInfo().setText("Select category and select order ID");
            if(!customerUI.getCustomerMenuSearch().getText().trim().isEmpty()){
                MenuItem m = menu.searchItem(customerUI.getCustomerMenuSearch().getText().trim());
                if(m!=null){
                    customerUI.getModel().setRowCount(0);
                    Object rowData[] = new Object[4];
                    rowData[0] = m.getCategory();
                    rowData[1] = m.getItem();
                    rowData[2] = m.getCost();
                    rowData[3] = m.getId();
                    customerUI.getModel().addRow(rowData);
                }
                else{
                    customerUI.getInfo().setForeground(Color.red);
                    customerUI.getInfo().setText("Item not found");
                }
            }
            else{
                customerUI.getInfo().setForeground(Color.red);
                customerUI.getInfo().setText("Input item");
            }
        }
    }

    public class SearchCustomerIDSetListener implements ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if(!customerUI.getCustomerIDField().getText().trim().isEmpty()&&validateNumber(customerUI.getCustomerIDField().getText().trim())){
                if(customer.searchID(Integer.parseInt(customerUI.getCustomerIDField().getText().trim()))!=null){
                    name = customer.searchID(Integer.parseInt(customerUI.getCustomerIDField().getText().trim()));
                    customerUI.getCustomerLabel().setForeground(Color.black);
                    customerUI.getCustomerLabel().setText("Wecome "+name.getName());
                }
                else{
                    customerUI.getCustomerLabel().setForeground(Color.red);
                    customerUI.getCustomerLabel().setText("ID not valid");
                }
            }
            else{
                customerUI.getCustomerLabel().setForeground(Color.red);
                customerUI.getCustomerLabel().setText("Enter proper customer ID");
            }
        }
    }

    public class MenuItemsSetMouseListener extends MouseAdapter {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            int row = customerUI.getMenuItems().rowAtPoint(evt.getPoint());
            int col = customerUI.getMenuItems().columnAtPoint(evt.getPoint());
            if (row >= 0 && col >= 0) {
                customerUI.getMenuItems().getValueAt(row, col).toString();
                menuItem = menu.searchID(customerUI.getMenuItems().getValueAt(row, col).toString());
                if(menuItem!=null&&name!=null){
                    customerUI.getDisplayOrder().append(menuItem.getItem()+"\t"+menuItem.getCost()+"\n");
                    String order = name.getId()+","+menuItem.getId()+","+menuItem.getItem()+","+menuItem.getCost()+","+ df.format(date)+"\n";
                    orderList.addOrderFile(order.split(","),currentOrdersFile);
                    getOrders().stream().forEach((s) -> {
                        System.out.println(String.join(", ", s));
                    });
                    totalCost(menuItem.getCost());
                    customerUI.getTotalCost().setText(String.valueOf(cost));
                    customerUI.getDiscount().setText(String.valueOf(discount()));
                    customerUI.getInfo().setForeground(Color.black);
                    customerUI.getInfo().setText("Select category and select order ID");
                }
                else{
                    customerUI.getInfo().setForeground(Color.red);
                    customerUI.getInfo().setText("Select Order ID or enter customer ID");
                }
            }
        }
    }

    public void showGUI() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                customerUI.setVisible(true);
            }
        });
    }

}
