
package CoffeeShop;

import org.junit.Test;
import static org.junit.Assert.*;


public class CustomerUITest {

    @Test 
    public void testInstanceCreatedSuccessfully() {

        // We are fine as long as this instantiates
        try {
            new CustomerUI();
        } catch(java.awt.HeadlessException e) {
            e.printStackTrace();
        }

    }

}
