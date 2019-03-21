package CoffeeShop.Controller;

import CoffeeShop.Model.Customer;
import CoffeeShop.Model.Menu;
import CoffeeShop.Model.MenuItem;
import CoffeeShop.Model.OrderList;
import CoffeeShop.Views.AdminUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class AdminController {
    private AdminUI adminUI;
    private Customer customers;
    private OrderList orderList;
    private Menu menu;
    private String category;
    private ArrayList<MenuItem> menuList;
    private MenuItem menuItem;

    public AdminController(){
        orderList = new OrderList();
        menu = new Menu();
        customers = new Customer();
        adminUI = new AdminUI();
        adminUI.setCategoryStartersActionListener(new CategoryStartersSetListener());
        adminUI.setCategoryMainCourseActionListener(new CategoryMainCourseSetListener());
        adminUI.setCategoryDrinksActionListener(new CategoryDrinksSetListener());
        adminUI.setCategoryDessertActionListener(new CategoryDessertSetListener());
        adminUI.setAddMenuItemActionListener(new AddMenuItemSetListener());
        adminUI.setSearchActionListener(new SearchSetListener());
        adminUI.setDeleteMenuItemActionListener(new DeleteMenuItemSetListener());
        adminUI.setAllMenuActionListener(new AllMenuSetListener());
        adminUI.setViewCustomersActionListener(new ViewCustomersSetListener());
        adminUI.setViewOrdersActionListener(new ViewOrdersSetListener());
        adminUI.setViewAllActionListener(new ViewAllSetListener());
        adminUI.setViewCustomerOrderHistoryActionListener(new ViewCustomerOrderHistorySetListener());
        adminUI.setMenuItemsMouseListener(new MenuItemsMouseSetListener());

        adminUI.getDisplay().setText("Customer\t"+"Menu Id\t"+"Item\t\t"+"Cost\t"+"Date\t\n"+orderList.getTotalSales()+"\n\nTotal Sales: "+orderList.getCost());
    }

    private void populateTable(String category)
    {

        adminUI.getModel().setRowCount(0);
        menuList = this.menu.searchCategory(category);
        Object[] rowData = new Object[4];
        for (MenuItem list1 : menuList) {
            rowData[0] = list1.getCategory();
            rowData[1] = list1.getItem();
            rowData[2] = list1.getCost();
            rowData[3] = list1.getId();
            adminUI.getModel().addRow(rowData);
        }
    }

    private String generateID() {
        String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder genID = new StringBuilder();
        Random rnd = new Random();
        while (genID.length() < 6) {
            int index = (int) (rnd.nextFloat() * CHARS.length());
            genID.append(CHARS.charAt(index));
        }
        return genID.toString();
    }

    private void updateMenu(){
        FileWriter writer;
        try {
            writer = new FileWriter(System.getProperty("user.dir")+"\\src\\main\\resources\\menu.csv");
            menuList = menu.getList();
            for (MenuItem i : menuList){
                writer.write(i.getCategory()+","+i.getItem()+","+i.getCost()+","+i.getId()+"\n");
            }

            writer.close();
            populateTable(category);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

     public class CategoryStartersSetListener implements ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            populateTable("Starters");
            category = "Starters";
        }

    }

    public class CategoryMainCourseSetListener implements ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            populateTable("Main Course");
            category = "Main Course";
        }
    }

    public class CategoryDrinksSetListener implements ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            populateTable("Drinks");
            category = "Drinks";
        }
    }

    public class CategoryDessertSetListener implements ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            populateTable("Desserts");
            category = "Desserts";
        }
    }

    public class AddMenuItemSetListener implements ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            String id = generateID();
            adminUI.getDisplayNewItem().setText("Item category: " + category + "\nItem ID: " + id);

            if (!adminUI.getNewItem().getText().trim().isEmpty() && adminUI.getNewItem().getText().trim() != null && adminUI.getNewCost().getText().trim().matches("^[0-9.]*$")) {
                Object[] options = {"Yes", "No"};
                int n = JOptionPane.showOptionDialog(null, "Confirm add?", null, JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
                if (n == JOptionPane.YES_OPTION) {
                    menuItem = new MenuItem(category, adminUI.getNewItem().getText().trim(), Double.parseDouble(adminUI.getNewCost().getText().trim()), id);
                    menu.addMenuItem(menuItem);
                    updateMenu();
                    adminUI.getNewItem().setText("");
                    adminUI.getNewCost().setText("");
                    adminUI.getInfo().setForeground(Color.black);
                    adminUI.getInfo().setText("");
                }
            } else {
                adminUI.getInfo().setForeground(Color.red);
                adminUI.getInfo().setText("Enter proper details or select category for new item");
            }
        }
    }

    public class SearchSetListener implements ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            adminUI.getInfo().setForeground(Color.black);
            if(!adminUI.getMenuSearch().getText().trim().isEmpty()){
                menuItem = menu.searchItem(adminUI.getMenuSearch().getText().trim());
                adminUI.getInfo().setText(menuItem.toString());
                if(menuItem!=null){
                    adminUI.getModel().setRowCount(0);
                    Object rowData[] = new Object[4];
                    rowData[0] = menuItem.getCategory();
                    rowData[1] = menuItem.getItem();
                    rowData[2] = menuItem.getCost();
                    rowData[3] = menuItem.getId();
                    adminUI.getModel().addRow(rowData);
                }
                else{
                    adminUI.getInfo().setForeground(Color.red);
                    adminUI.getInfo().setText("Item not found");
                }
            }
            else{
                adminUI.getInfo().setForeground(Color.red);
                adminUI.getInfo().setText("Input item");
            }
        }
    }

    public class DeleteMenuItemSetListener implements ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            menu.removeMenuItem(menuItem);
            updateMenu();
        }
    }

    public class AllMenuSetListener implements ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            adminUI.getModel().setRowCount(0);
            menuList = menu.listAllNames();
            Object rowData[] = new Object[4];
            for (MenuItem list1 : menuList) {
                rowData[0] = list1.getCategory();
                rowData[1] = list1.getItem();
                rowData[2] = list1.getCost();
                rowData[3] = list1.getId();
                adminUI.getModel().addRow(rowData);
            }
        }
    }

    public class ViewCustomersSetListener implements ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            adminUI.getDisplay().setText(customers.listAllCustomers());
        }
    }

    public class ViewOrdersSetListener implements ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            adminUI.getDisplay().setText(orderList.list());
        }
    }

    public class ViewAllSetListener implements ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            adminUI.getDisplay().setText("Customer\t"+"Menu Id\t"+"Item\t\t"+"Cost\t"+"Date\t\n"+orderList.getTotalSales()+"\n\nTotal Sales: "+orderList.getCost());
        }
    }

    public class ViewCustomerOrderHistorySetListener implements ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if(!adminUI.getSearchSales().getText().trim().isEmpty()){
                adminUI.getDisplay().setText("Customer\t"+"Menu Id\t"+"Item\t"+"Cost\t"+"Date\t\n"+orderList.getSalesByItems(adminUI.getSearchSales().getText().trim())+"\n\nTotal Sales: "+orderList.getCost());
                adminUI.getjLabel1().setForeground(Color.black);
            }
            else{
                adminUI.getjLabel1().setForeground(Color.red);
                adminUI.getjLabel1().setText("Enter item to search");
            }
        }
    }

    public class MenuItemsMouseSetListener extends MouseAdapter {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            int row = adminUI.getMenuItems().rowAtPoint(evt.getPoint());
            int col = adminUI.getMenuItems().columnAtPoint(evt.getPoint());
            if (row >= 0 && col >= 0) {
                menuItem = menu.searchID(adminUI.getMenuItems().getValueAt(row, col).toString());
                if(menuItem!=null){
                    adminUI.getInfo().setText(menuItem.toString());
                }
            }
        }
    }

    public void showGUI() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                adminUI.setVisible(true);
            }
        });
    }

}
