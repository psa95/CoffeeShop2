package CoffeeShop;

public class NoMatchingID extends Exception {
    public NoMatchingID(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}