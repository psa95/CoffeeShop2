package CoffeeShop.Exceptions;

public class NoMatchingIDException extends RuntimeException {
    public NoMatchingIDException(String errorMessage) {
        super(errorMessage);
    }
}