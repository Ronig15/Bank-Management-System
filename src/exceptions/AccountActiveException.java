package exceptions;

public class AccountActiveException extends RuntimeException {
    public AccountActiveException(String message) {
        super(message);
    }
}
