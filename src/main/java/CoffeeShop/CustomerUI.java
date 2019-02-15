
package CoffeeShop;


public class CustomerUI extends javax.swing.JFrame {

    /**
     * Creates new form Customer
     */
    public CustomerUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        makeOrder = new javax.swing.JButton();
        customerUIScrollPane = new javax.swing.JScrollPane();
        menuItems = new javax.swing.JTable();
        discountLabel = new javax.swing.JLabel();
        customerMenuSearchLabel = new javax.swing.JLabel();
        customerMenuSearch = new javax.swing.JTextField();
        categoriesLabel = new javax.swing.JLabel();
        categoryStarters = new javax.swing.JRadioButton();
        categoryMainCourse = new javax.swing.JRadioButton();
        categoryDessert = new javax.swing.JRadioButton();
        categoryDrinks = new javax.swing.JRadioButton();
        categoryOther = new javax.swing.JRadioButton();
        totalCostLabel = new javax.swing.JLabel();
        discount = new javax.swing.JTextField();
        totalCost = new javax.swing.JTextField();
        customerIDLabel = new javax.swing.JLabel();
        customerIDSelector = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        setName("CustomerUI"); // NOI18N
        setResizable(false);

        makeOrder.setText("Order");
        makeOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeOrderActionPerformed(evt);
            }
        });

        menuItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Category", "Description", "Price Per Item", "How Many Wanted"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        menuItems.setColumnSelectionAllowed(true);
        menuItems.getTableHeader().setReorderingAllowed(false);
        customerUIScrollPane.setViewportView(menuItems);
        menuItems.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (menuItems.getColumnModel().getColumnCount() > 0) {
            menuItems.getColumnModel().getColumn(0).setResizable(false);
            menuItems.getColumnModel().getColumn(1).setResizable(false);
            menuItems.getColumnModel().getColumn(2).setResizable(false);
            menuItems.getColumnModel().getColumn(3).setResizable(false);
        }

        discountLabel.setText("Discount");

        customerMenuSearchLabel.setText("Search");

        customerMenuSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerMenuSearchActionPerformed(evt);
            }
        });

        categoriesLabel.setText("Categories");

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

        categoryOther.setText("Other");
        categoryOther.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryOtherActionPerformed(evt);
            }
        });

        totalCostLabel.setText("Total");

        discount.setText("0");
        discount.setEnabled(false);
        discount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discountActionPerformed(evt);
            }
        });

        totalCost.setText("0");
        totalCost.setEnabled(false);

        customerIDLabel.setText("Customer ID");

        customerIDSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        customerIDSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerIDSelectorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(makeOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customerUIScrollPane, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(customerMenuSearchLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(customerMenuSearch))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalCostLabel)
                            .addComponent(discountLabel))
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalCost)
                            .addComponent(discount)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(categoriesLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(categoryStarters)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(categoryMainCourse)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(categoryDessert)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(categoryDrinks)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(categoryOther))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(customerIDLabel)
                                .addGap(33, 33, 33)
                                .addComponent(customerIDSelector, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(customerMenuSearch)
                    .addComponent(customerMenuSearchLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryStarters)
                    .addComponent(categoryMainCourse)
                    .addComponent(categoryDessert)
                    .addComponent(categoryDrinks)
                    .addComponent(categoryOther)
                    .addComponent(categoriesLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customerUIScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(discountLabel)
                    .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(totalCostLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalCost, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(customerIDSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 15, Short.MAX_VALUE)
                .addComponent(makeOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void makeOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeOrderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_makeOrderActionPerformed

    private void discountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_discountActionPerformed

    private void customerMenuSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerMenuSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerMenuSearchActionPerformed

    private void categoryStartersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryStartersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryStartersActionPerformed

    private void categoryMainCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryMainCourseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryMainCourseActionPerformed

    private void categoryDessertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryDessertActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryDessertActionPerformed

    private void categoryDrinksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryDrinksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryDrinksActionPerformed

    private void categoryOtherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryOtherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryOtherActionPerformed

    private void customerIDSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerIDSelectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerIDSelectorActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(CustomerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel categoriesLabel;
    private javax.swing.JRadioButton categoryDessert;
    private javax.swing.JRadioButton categoryDrinks;
    private javax.swing.JRadioButton categoryMainCourse;
    private javax.swing.JRadioButton categoryOther;
    private javax.swing.JRadioButton categoryStarters;
    private javax.swing.JLabel customerIDLabel;
    private javax.swing.JComboBox<String> customerIDSelector;
    private javax.swing.JTextField customerMenuSearch;
    private javax.swing.JLabel customerMenuSearchLabel;
    private javax.swing.JScrollPane customerUIScrollPane;
    private javax.swing.JTextField discount;
    private javax.swing.JLabel discountLabel;
    private javax.swing.JButton makeOrder;
    private javax.swing.JTable menuItems;
    private javax.swing.JTextField totalCost;
    private javax.swing.JLabel totalCostLabel;
    // End of variables declaration//GEN-END:variables
}
