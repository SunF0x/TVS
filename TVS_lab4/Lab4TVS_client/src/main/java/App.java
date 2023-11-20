import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import java.util.List;
import javax.ws.rs.core.MediaType;
public class App {
    private static final String URL ="http://localhost:8081/rest/serials";
    //private static final String URL = "http://localhost:8080/Lab4TVS_service_J2EE-1.0-SNAPSHOT/rest/serials";
    public static void main(String[] args) {
        Client client = Client.create();
        printList(getSerial(client, null));
        System.out.println();
        printList(getSerial(client, "Hannibal"));
    }
    private static List<Serial> getSerial(Client client, String title)
    {
        WebResource webResource = client.resource(URL);
        if (title != null) {
            webResource = webResource.queryParam("title", title);
        }
        ClientResponse response =
                webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        if (response.getStatus() !=
                ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed");
        }
        GenericType<List<Serial>> type = new GenericType<List<Serial>>() {};
        return response.getEntity(type);
    }

    private static void printList(List<Serial> serials) {
        for (Serial serial : serials) {
            System.out.println(serial);
        }
    }
}
