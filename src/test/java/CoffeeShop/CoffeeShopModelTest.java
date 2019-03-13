
package CoffeeShop;

import org.junit.Test;
import static org.junit.Assert.*;

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

    /**
     * Tests destroy instances outside the scope of a testing method,
     * so will test the tempfiles in one place, as the temp files get destroyed
     * when the instance is.
     */
    @Test
    public void testTempOrders(){

        CoffeeShopModel csm = new CoffeeShopModel();

        // Can we add an order?
        csm.addOrder(new String[]{"user_id", "item_id","item_price"});

        // Can we get back the array we just wrote?
        assertArrayEquals(new String[]{"user_id", "item_id","item_price"}, csm.getOrders().get(0));

    }

    @Test
    public void testLog(){

        CoffeeShopModel csm = new CoffeeShopModel();
        // Can we add a log item?
        csm.writeToLog(new String[]{"time", "log_string"});
    }

}
