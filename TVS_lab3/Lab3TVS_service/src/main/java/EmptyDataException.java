import javax.xml.ws.WebFault;

@WebFault(faultBean =
        "com.wishmaster.ifmo.ws.jaxws.errors.SerialServiceFault")
public class EmptyDataException extends Exception {
    private static final long serialVersionUID = -6647544772732631047L;
    private final SerialServiceFault fault;
    public EmptyDataException(String message, SerialServiceFault fault)
    {
        super(message);
        this.fault = fault;
    }
    public EmptyDataException(String message, SerialServiceFault fault,
                              Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }
    public SerialServiceFault getFaultInfo() {
        return fault;
    }
}
