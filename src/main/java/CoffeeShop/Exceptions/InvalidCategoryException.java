package CoffeeShop.Exceptions;

public class InvalidCategoryException extends RuntimeException {
    public InvalidCategoryException(String errorMessage) {
        super(errorMessage);
    }
}
