
package CoffeeShop;

import org.junit.Test;
// import static org.junit.Assert.*;


public class CoffeeShopGUITest extends GUITests {

    public CoffeeShopGUITest(){
        super();
    }

    @Test 
    public void testInstanceCreatedSuccessfully() {

        // We are fine as long as this instantiates
        if(!isCI){
            new CoffeeShopGUI();
        }
    }
}