
package CoffeeShop;

import org.junit.Test;
import static org.junit.Assert.*;
import static java.lang.System.out;

import java.util.ArrayList;


public class CoffeeShopModelTest {

    /**
     * Test whether we can instantiate CoffeeShopModel.
     */

    @Test 
    public void testInstanceCreatedSuccessfully() {
        new CoffeeShopModel();
    }

    /**
     * Test whether we get expected dataTypes from CoffeeShopModel methods.
     */
    @Test 
    public void testGetCustomers(){
        assertTrue(new CoffeeShopModel().getCustomers() instanceof ArrayList<?>);
    }

    @Test 
    public void testGetMenu(){
        assertTrue(new CoffeeShopModel().getMenu() instanceof ArrayList<?>);
    }

    @Test 
    public void testGetPreviousOrders(){
        assertTrue(new CoffeeShopModel().getPreviousOrders() instanceof ArrayList<?>);
    }

}
