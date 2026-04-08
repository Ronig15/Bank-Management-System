package exceptions;

public class TransactionBetweenSameAccountException extends RuntimeException {
    public TransactionBetweenSameAccountException(String message) {
        super(message);
    }
}
