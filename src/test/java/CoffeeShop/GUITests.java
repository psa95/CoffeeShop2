
package CoffeeShop;


public class GUITests {

    /* This tests if we are in the CI environment, and doesnt run the GUI tests if true
     * as they will always fail in a headless environment
     */

    Boolean isCI = false;

    public GUITests(){
        try{
            if(System.getenv("NO_GUI") == "1"){
                isCI = true;
            }
        } catch (NullPointerException e){
            
        }
    }

}

