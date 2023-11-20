import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

public class App_J2EE {
    //private static final String URL ="http://localhost:8081/rest/serials";
    private static final String URL = "http://localhost:8080/Lab4TVS_service_J2EE-1.0-SNAPSHOT/rest/serials";
    public static void main(String[] args) {
        Client client = Client.create();
        System.out.println(getSerial(client, null));
        System.out.println();
        System.out.println(getSerial(client, "Hannibal"));
    }
    private static String getSerial(Client client, String title)
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

        return response.getEntity(String.class);
    }
}
