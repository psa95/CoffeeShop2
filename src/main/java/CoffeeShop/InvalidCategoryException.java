package CoffeeShop;

public class InvalidCategoryException extends RuntimeException {
    public InvalidCategoryException(String errorMessage) {
        super(errorMessage);
    }
}
