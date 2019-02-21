
package CoffeeShop;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;


public class AdminUI extends javax.swing.JFrame {
    
    Menu menu;
    Name name;
    ArrayList<MenuItem> menuList;
    ArrayList<MenuItem> customerList;
    DefaultTableModel model;
    MenuItem menuItem;
    Customer customer;
    String category;
    OrderList orderList;
    /**
     * Creates new form Chose
     */
    public AdminUI() {
        initComponents();
        menu = new Menu();
        menu.readMenuFile("menu.csv");
        customer = new Customer();
        customer.readCustomerFile("customer list.csv");
        orderList = new OrderList();
        model = (DefaultTableModel) menuItems.getModel();
        ButtonGroup group = new ButtonGroup();
        group.add(categoryDessert);
        group.add(categoryDrinks);
        group.add(categoryMainCourse);
        group.add(categoryStarters);
        group.add(allMenu);
        orderList.readOrderFile("order list.csv");
        display.setText("Customer\t"+"Menu Id\t"+"Item\t"+"Cost\t"+"Date\t\n"+orderList.getTotalSales()+"\n\nTotal Sales: "+orderList.getCost());
    }
    
    public void populateTable(String category)
    {
        model.setRowCount(0);
        //menuItems.setModel(model);
        //menuItems.setModel(new DefaultTableModel());
        //model = (DefaultTableModel) menuItems.getModel();
        menuList = menu.searchCategory(category);
        Object rowData[] = new Object[4];
        menuList.stream().map((list1) -> {
            rowData[0] = list1.getCategory();
            return list1;
        }).map((list1) -> {
            rowData[1] = list1.getItem();
            return list1;
        }).map((list1) -> {
            rowData[2] = list1.getCost();
            return list1;
        }).map((list1) -> {
            rowData[3] = list1.getId();
            return list1;
        }).forEach((_item) -> {
            model.addRow(rowData);
        });      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        adminTabs = new javax.swing.JTabbedPane();
        menuTab = new javax.swing.JPanel();
        menuSearchLabel = new javax.swing.JLabel();
        menuSearch = new javax.swing.JTextField();
        menuScrollPane = new javax.swing.JScrollPane();
        menuItems = new javax.swing.JTable();
        categoriesLabel = new javax.swing.JLabel();
        categoryStarters = new javax.swing.JRadioButton();
        categoryMainCourse = new javax.swing.JRadioButton();
        categoryDessert = new javax.swing.JRadioButton();
        categoryDrinks = new javax.swing.JRadioButton();
        addMenuItem = new javax.swing.JButton();
        search = new javax.swing.JButton();
        info = new javax.swing.JTextField();
        deleteMenuItem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        displayNewItem = new javax.swing.JTextArea();
        newItem = new javax.swing.JTextField();
        newCost = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        allMenu = new javax.swing.JRadioButton();
        customerTab = new javax.swing.JPanel();
        adminCustomerSearchLabel = new javax.swing.JLabel();
        searchSales = new javax.swing.JTextField();
        viewCustomerOrderHistory = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        display = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        viewCustomers = new javax.swing.JButton();
        viewOrders = new javax.swing.JButton();
        viewAll = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Admin");
        setName("AdminUI"); // NOI18N
        setResizable(false);

        menuSearchLabel.setText("Search");

        menuItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Category", "Description", "Price", "ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        menuItems.setColumnSelectionAllowed(true);
        menuItems.getTableHeader().setReorderingAllowed(false);
        menuItems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuItemsMouseClicked(evt);
            }
        });
        menuScrollPane.setViewportView(menuItems);
        menuItems.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (menuItems.getColumnModel().getColumnCount() > 0) {
            menuItems.getColumnModel().getColumn(0).setResizable(false);
            menuItems.getColumnModel().getColumn(0).setPreferredWidth(25);
            menuItems.getColumnModel().getColumn(1).setResizable(false);
            menuItems.getColumnModel().getColumn(1).setPreferredWidth(70);
            menuItems.getColumnModel().getColumn(2).setResizable(false);
            menuItems.getColumnModel().getColumn(3).setResizable(false);
        }

        categoryStarters.setText("Starters");
        categoryStarters.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryStartersActionPerformed(evt);
            }
        });

        categoryMainCourse.setText("Main Course");
        categoryMainCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryMainCourseActionPerformed(evt);
            }
        });

        categoryDessert.setText("Dessert");
        categoryDessert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryDessertActionPerformed(evt);
            }
        });

        categoryDrinks.setText("Drinks");
        categoryDrinks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryDrinksActionPerformed(evt);
            }
        });

        addMenuItem.setText("Add");
        addMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenuItemActionPerformed(evt);
            }
        });

        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        info.setEditable(false);
        info.setEnabled(false);

        deleteMenuItem.setText("Delete");
        deleteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMenuItemActionPerformed(evt);
            }
        });

        displayNewItem.setEditable(false);
        displayNewItem.setColumns(8);
        displayNewItem.setRows(3);
        displayNewItem.setTabSize(3);
        displayNewItem.setAutoscrolls(false);
        displayNewItem.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        displayNewItem.setEnabled(false);
        jScrollPane2.setViewportView(displayNewItem);

        jLabel2.setText("Enter new order Item");

        jLabel3.setText("Enter new item cost");

        allMenu.setText("All");
        allMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuTabLayout = new javax.swing.GroupLayout(menuTab);
        menuTab.setLayout(menuTabLayout);
        menuTabLayout.setHorizontalGroup(
            menuTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuTabLayout.createSequentialGroup()
                        .addGroup(menuTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(categoriesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(menuSearchLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(menuTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(menuTabLayout.createSequentialGroup()
                                .addComponent(categoryStarters)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(categoryMainCourse)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(categoryDessert)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(categoryDrinks)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(allMenu)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(menuTabLayout.createSequentialGroup()
                                .addComponent(menuSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(menuTabLayout.createSequentialGroup()
                        .addGroup(menuTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(menuTabLayout.createSequentialGroup()
                                .addComponent(addMenuItem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteMenuItem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(info))
                            .addComponent(menuScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(menuTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(newItem)
                            .addComponent(newCost)
                            .addGroup(menuTabLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 130, Short.MAX_VALUE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        menuTabLayout.setVerticalGroup(
            menuTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuTabLayout.createSequentialGroup()
                .addComponent(categoriesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 6, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menuTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(menuSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menuSearchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search))
                .addGap(5, 5, 5)
                .addGroup(menuTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryMainCourse)
                    .addComponent(categoryStarters)
                    .addComponent(categoryDessert)
                    .addComponent(categoryDrinks)
                    .addComponent(allMenu))
                .addGap(9, 9, 9)
                .addGroup(menuTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(menuTabLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(4, 4, 4)
                        .addComponent(newItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(3, 3, 3)
                        .addComponent(newCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(menuTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addMenuItem)
                    .addComponent(info, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteMenuItem))
                .addContainerGap())
        );

        adminTabs.addTab("Menu", menuTab);

        adminCustomerSearchLabel.setText("Search");

        viewCustomerOrderHistory.setText("Search Item history");
        viewCustomerOrderHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCustomerOrderHistoryActionPerformed(evt);
            }
        });

        display.setEditable(false);
        display.setColumns(20);
        display.setRows(5);
        jScrollPane1.setViewportView(display);

        jLabel1.setText("info");

        viewCustomers.setText("View Customers");
        viewCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCustomersActionPerformed(evt);
            }
        });

        viewOrders.setText("View Orders");
        viewOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewOrdersActionPerformed(evt);
            }
        });

        viewAll.setText("View All");
        viewAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout customerTabLayout = new javax.swing.GroupLayout(customerTab);
        customerTab.setLayout(customerTabLayout);
        customerTabLayout.setHorizontalGroup(
            customerTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customerTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerTabLayout.createSequentialGroup()
                        .addComponent(adminCustomerSearchLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchSales, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewCustomerOrderHistory)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewCustomers)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewOrders)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(viewAll, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        customerTabLayout.setVerticalGroup(
            customerTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customerTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchSales, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adminCustomerSearchLabel)
                    .addComponent(viewCustomerOrderHistory)
                    .addComponent(viewCustomers)
                    .addComponent(viewOrders)
                    .addComponent(viewAll))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        adminTabs.addTab("Order History", customerTab);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(adminTabs)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(adminTabs, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        adminTabs.getAccessibleContext().setAccessibleName("Menu");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void categoryDessertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryDessertActionPerformed
        // TODO add your handling code here:
        populateTable("Desserts");
        category = "Desserts";
    }//GEN-LAST:event_categoryDessertActionPerformed

    private void categoryStartersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryStartersActionPerformed
        // TODO add your handling code here:
        populateTable("Starters");
        category = "Starters";
    }//GEN-LAST:event_categoryStartersActionPerformed

    private void categoryMainCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryMainCourseActionPerformed
        // TODO add your handling code here:
        populateTable("Main Course");
        category = "Main Course";
    }//GEN-LAST:event_categoryMainCourseActionPerformed

    private void categoryDrinksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryDrinksActionPerformed
        // TODO add your handling code here:
        populateTable("Drinks");
        category = "Drinks";
    }//GEN-LAST:event_categoryDrinksActionPerformed

    private void menuItemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuItemsMouseClicked
        // TODO add your handling code here:
        int row = menuItems.rowAtPoint(evt.getPoint());
        int col = menuItems.columnAtPoint(evt.getPoint());
        if (row >= 0 && col >= 0) {
            menuItem = menu.searchID(menuItems.getValueAt(row, col).toString());
            if(menuItem!=null){
            info.setText(menuItem.toString());}
        }
    }//GEN-LAST:event_menuItemsMouseClicked

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
        info.setForeground(Color.black);
        if(!menuSearch.getText().trim().isEmpty()){
        menuItem = menu.searchItem(menuSearch.getText().trim());
        info.setText(menuItem.toString());
            if(menuItem!=null){
                model.setRowCount(0);
                Object rowData[] = new Object[4];
                rowData[0] = menuItem.getCategory();
                rowData[1] = menuItem.getItem();
                rowData[2] = menuItem.getCost();
                rowData[3] = menuItem.getId();
                model.addRow(rowData);
        }
            else{
                info.setForeground(Color.red);
                info.setText("Item not found");
        }
        }
        else{
            info.setForeground(Color.red);
            info.setText("Input item");
        }
    }//GEN-LAST:event_searchActionPerformed

    private void deleteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMenuItemActionPerformed
        // TODO add your handling code here:
            menu.removeMenuItem(menuItem);
            updateMenu();
            
    }//GEN-LAST:event_deleteMenuItemActionPerformed

    public void updateMenu(){
        FileWriter writer;
        try {
            // TODO add your handling code here:
            //writer = new FileWriter("C:/Users/uchea/Desktop/Drive/F21AS/CoffeeShop/resources/menu.csv");
            writer = new FileWriter(System.getProperty("user.dir")+"\\resources\\menu.csv");
            menuList = menu.getList();
            for (MenuItem i : menuList){
                writer.write(i.getCategory()+","+i.getItem()+","+i.getCost()+","+i.getId()+"\n");
            }   
            
            writer.close();
            populateTable(category);
        } catch (IOException ex) {}
    }
    
    protected String generateID() {
        String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder genID = new StringBuilder();
        Random rnd = new Random();
        while (genID.length() < 6) {
            int index = (int) (rnd.nextFloat() * CHARS.length());
            genID.append(CHARS.charAt(index));
        }
        String saltStr = genID.toString();
        return saltStr;
    }
    
    
    private void addMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenuItemActionPerformed
        // TODO add your handling code here:
        String id = generateID();
        displayNewItem.setText("Item category: "+category +"\nItem ID: " + id);
        
        if(!newItem.getText().trim().isEmpty()&&newItem.getText().trim()!=null&&newCost.getText().trim().matches("^[0-9.]*$")){
             Object[] options = {"Yes", "No"};
                            int n = JOptionPane.showOptionDialog(null, "Confirm add?", null, JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
                                if(n == JOptionPane.YES_OPTION){
                                    menuItem = new MenuItem(category,newItem.getText().trim(),Double.parseDouble(newCost.getText().trim()),id);
                                    menu.addMenuItem(menuItem);
                                    updateMenu();
                                    newItem.setText("");
                                    newCost.setText("");
                                    info.setForeground(Color.black);
                                    info.setText("");
                    }
        }else{
            info.setForeground(Color.red);
            info.setText("Enter proper details or select category for new item");
        }
        //model.addRow(new Object[]{category, "", "",generateID()});
        
//        DefaultTableModel tableModel = new DefaultTableModel();
//        menuItems = new JTable(tableModel);
        
//        model.addTableModelListener(new TableModelListener() {
//        @Override
//        public void tableChanged(TableModelEvent e) {
//            //Object rowData[] = new Object[4];
//            if (menuItems.getModel().getValueAt(model.getRowCount()-1, 2).toString().matches("^[0-9.]*$")&&
//                !menuItems.getModel().getValueAt(model.getRowCount()-1, 2).toString().isEmpty()){
//                String item = menuItems.getModel().getValueAt(model.getRowCount()-1, 1).toString();
//                double cost = Double.parseDouble(menuItems.getModel().getValueAt(model.getRowCount()-1, 2).toString());
//                    if(!item.isEmpty()){
//                        if (e.getLastRow()+1 == model.getRowCount()) {
//                           
//                            
//            }
//            }
//            }
//            
//  }
//});
    }//GEN-LAST:event_addMenuItemActionPerformed

    private void viewCustomerOrderHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewCustomerOrderHistoryActionPerformed
        // TODO add your handling code here:
        if(!searchSales.getText().trim().isEmpty()){
        display.setText("Customer\t"+"Menu Id\t"+"Item\t"+"Cost\t"+"Date\t\n"+orderList.getSalesByItems(searchSales.getText().trim())+"\n\nTotal Sales: "+orderList.getCost());
        jLabel1.setForeground(Color.black);
        }
        else{
            jLabel1.setForeground(Color.red);
            jLabel1.setText("Enter item to search");
        }
    }//GEN-LAST:event_viewCustomerOrderHistoryActionPerformed

    private void viewCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewCustomersActionPerformed
        // TODO add your handling code here:
        display.setText(customer.listAllCustomers());
        //display.setText("Customer\t"+"Menu Id\t"+"Item\t"+"Cost\t"+"Date\t\n"+orderList.getTotalSales()+"\n\nTotal Sales: "+orderList.getCost());
    }//GEN-LAST:event_viewCustomersActionPerformed

    private void allMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allMenuActionPerformed
        // TODO add your handling code here:
        model.setRowCount(0);
        menuList = menu.listAllNames();
        Object rowData[] = new Object[4];
        menuList.stream().map((list1) -> {
            rowData[0] = list1.getCategory();
            return list1;
        }).map((list1) -> {
            rowData[1] = list1.getItem();
            return list1;
        }).map((list1) -> {
            rowData[2] = list1.getCost();
            return list1;
        }).map((list1) -> {
            rowData[3] = list1.getId();
            return list1;
        }).forEach((_item) -> {
            model.addRow(rowData);
        });      
    }//GEN-LAST:event_allMenuActionPerformed

    private void viewOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewOrdersActionPerformed
        // TODO add your handling code here:
        display.setText(orderList.list());
    }//GEN-LAST:event_viewOrdersActionPerformed

    private void viewAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAllActionPerformed
        // TODO add your handling code here:
        display.setText("Customer\t"+"Menu Id\t"+"Item\t"+"Cost\t"+"Date\t\n"+orderList.getTotalSales()+"\n\nTotal Sales: "+orderList.getCost());
    }//GEN-LAST:event_viewAllActionPerformed

    private void writeReport(String filename, String report){
      FileWriter fw;
        try {
            fw = new FileWriter(System.getProperty("user.dir")+"\\resources\\"+filename);
            fw.write(report);
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
    
    public void showGUI() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addMenuItem;
    private javax.swing.JLabel adminCustomerSearchLabel;
    private javax.swing.JTabbedPane adminTabs;
    private javax.swing.JRadioButton allMenu;
    private javax.swing.JLabel categoriesLabel;
    private javax.swing.JRadioButton categoryDessert;
    private javax.swing.JRadioButton categoryDrinks;
    private javax.swing.JRadioButton categoryMainCourse;
    private javax.swing.JRadioButton categoryStarters;
    private javax.swing.JPanel customerTab;
    private javax.swing.JButton deleteMenuItem;
    private javax.swing.JTextArea display;
    private javax.swing.JTextArea displayNewItem;
    private javax.swing.JTextField info;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable menuItems;
    private javax.swing.JScrollPane menuScrollPane;
    private javax.swing.JTextField menuSearch;
    private javax.swing.JLabel menuSearchLabel;
    private javax.swing.JPanel menuTab;
    private javax.swing.JTextField newCost;
    private javax.swing.JTextField newItem;
    private javax.swing.JButton search;
    private javax.swing.JTextField searchSales;
    private javax.swing.JButton viewAll;
    private javax.swing.JButton viewCustomerOrderHistory;
    private javax.swing.JButton viewCustomers;
    private javax.swing.JButton viewOrders;
    // End of variables declaration//GEN-END:variables
}
