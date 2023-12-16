package serialPackage;

public class InvalidDateException extends Exception {
    private static final long serialVersionUID = -6647544772732631047L;
    public static InvalidDateException DEFAULT_INSTANCE = new
            InvalidDateException("Date in the future");

    public InvalidDateException(String message) {
        super(message);
    }
}
