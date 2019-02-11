
package CoffeeShop;

import org.junit.Test;
import static org.junit.Assert.*;



public class MenuItemTest {

    @Test(expected = InvalidCategoryException.class)
    public void testInvalidCategory() {
        // When the category is not one of the defined categories
        new MenuItem("Soups", "Tomato Soup",17.50,"SOUP1");
    }

}