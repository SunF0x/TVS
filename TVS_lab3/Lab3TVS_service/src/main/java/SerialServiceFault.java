public class SerialServiceFault {
    private static final String DEFAULT_MESSAGE = "Something wrong";

    protected String message;
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public static SerialServiceFault defaultInstance() {
        SerialServiceFault fault = new SerialServiceFault();
        fault.message = DEFAULT_MESSAGE;
        return fault;
    }
}
