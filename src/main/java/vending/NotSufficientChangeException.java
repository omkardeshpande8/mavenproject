package vending;

/**
 *
 * @author Omkar
 */
public class NotSufficientChangeException extends RuntimeException {

    private final String message;

    public NotSufficientChangeException(String string) {
        this.message = string;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
