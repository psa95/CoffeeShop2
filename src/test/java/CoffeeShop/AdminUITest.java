
package CoffeeShop;

import CoffeeShop.Views.AdminUI;
import org.junit.Test;
//import static org.junit.Assert.*;


public class AdminUITest {

    @Test 
    public void testInstanceCreatedSuccessfully() {
        
        // We are fine as long as this instantiates
        try{
            new AdminUI();
        } catch(java.awt.HeadlessException e) {
            e.printStackTrace();
        }
    }
}
