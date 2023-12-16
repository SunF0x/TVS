package serialPackage;

public class NonExistentIdException  extends Exception {
    private static final long serialVersionUID = -6647544772732631047L;
    public static NonExistentIdException DEFAULT_INSTANCE = new
            NonExistentIdException("Serial Id is not existed");

    public NonExistentIdException(String message) {
        super(message);
    }
}
