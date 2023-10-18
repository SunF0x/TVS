import javax.xml.ws.Endpoint;

public class App {
    public static void main(String[] args) {
        String url = "http://127.0.0.1:8081/SerialService";
        Endpoint.publish(url, new SerialWebService());
    }
}
