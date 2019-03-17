
package CoffeeShop;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.*;

import java.util.ArrayList;


public class CoffeeShopModelTest {

    /**
     * Test whether we can instantiate CoffeeShopModel.
     */

    @Test 
    public void testInstanceCreatedSuccessfully() {
        CoffeeShopModel.getInstance();
    }

    /**
     * Test whether we get expected dataTypes from CoffeeShopModel methods.
     */
    @Test 
    public void testGetCustomers(){
        assertTrue(CoffeeShopModel.getInstance().getCustomers() instanceof ArrayList<?>);
    }

    @Test 
    public void testGetMenu(){
        assertTrue(CoffeeShopModel.getInstance().getMenu() instanceof ArrayList<?>);
    }

    @Test 
    public void testGetPreviousOrders(){
        assertTrue(CoffeeShopModel.getInstance().getPreviousOrders() instanceof ArrayList<?>);
    }

    /**
     * Tests destroy instances outside the scope of a testing method,
     * so will test the tempfiles in one place, as the temp files get destroyed
     * when the instance is.
     */
    @Test
    public void testTempOrders(){

        CoffeeShopModel csm = CoffeeShopModel.getInstance();

        // Can we add an order?
        csm.addOrder(new String[]{"user_id", "item_id","item_price"});

        // Can we get back the array we just wrote?
        assertArrayEquals(new String[]{"user_id", "item_id","item_price"}, csm.getOrders().get(0));

    }

    @Test
    public void testLog(){

        CoffeeShopModel csm = CoffeeShopModel.getInstance();

        // Can we add a log item?
        csm.writeToLog(new String[]{"time", "log_string"});

        // We're done with the file, lets delete it
        try{
            Files.deleteIfExists(Paths.get("log.csv"));
        } catch(IOException e) {
            e.printStackTrace();
        }

    }

}
