package CoffeeShop.Controller;

import CoffeeShop.Views.CoffeeShopGUI;

import java.awt.event.ActionListener;

public class CoffeeShopController {

    CoffeeShopGUI coffeeShopGUI;
    public CoffeeShopController(){
        coffeeShopGUI = new CoffeeShopGUI();
        coffeeShopGUI.setAdminActionListener(new AdminSetListener());
        coffeeShopGUI.setCustomerActionListener(new CustomerSetListener());
    }

    public class AdminSetListener implements ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            new AdminController().showGUI();
        }
    }
    public class CustomerSetListener implements ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            new CustomerController().showGUI();
        }
    }

    public void showGUI() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                coffeeShopGUI.setVisible(true);
            }
        });
    }
}
