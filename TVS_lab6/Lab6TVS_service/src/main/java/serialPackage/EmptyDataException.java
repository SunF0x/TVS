package serialPackage;

public class EmptyDataException extends Exception {
    private static final long serialVersionUID = -6647544772732631047L;
    public static EmptyDataException DEFAULT_INSTANCE = new
            EmptyDataException("Nothing added to change");

    public EmptyDataException(String message) {
        super(message);
    }
}
