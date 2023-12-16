package serialPackage;

public class NegativeValueException extends Exception {
    private static final long serialVersionUID = -6647544772732631047L;
    public static NegativeValueException DEFAULT_INSTANCE = new
            NegativeValueException("Value should be positive");

    public NegativeValueException(String message) {
        super(message);
    }
}
