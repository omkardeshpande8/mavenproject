package vending;

/**
 *
 * @author Omkar
 */
public class SoldOutException extends RuntimeException {

    private final String message;

    public SoldOutException(String string) {
        this.message = string;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
