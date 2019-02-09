package CoffeeShop;

public class NoMatchingIDException extends RuntimeException {
    public NoMatchingIDException(String errorMessage) {
        super(errorMessage);
    }
}