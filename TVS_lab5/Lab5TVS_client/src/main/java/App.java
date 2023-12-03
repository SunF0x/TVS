import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.ws.rs.core.MediaType;
public class App {
    private static final String URL ="http://localhost:8081/rest/serials";
    public static void main(String[] args) throws ParseException {
        Client client = Client.create();
        Scanner in = new Scanner(System.in);
        Scanner scanString = new Scanner(System.in);
        while (true) {
            System.out.print(" 1 - Select\n 2 - Insert\n 3 - Update\n 4 - Delete\n 5 - Exit\n");
            int option = in.nextInt();
            System.out.printf("Your option: %d \n", option);
            switch (option) {
                case 1:
                    printList(getSerial(client, null));
                    System.out.println();
                    printList(getSerial(client, "Hannibal"));
                    break;
                case 2:
                    System.out.print("Add title: ");
                    String title = scanString.nextLine();
                    System.out.print("Add character separated by comma: ");
                    String character = scanString.nextLine();
                    System.out.print("Add number of seasons: ");
                    int seasons = in.nextInt();
                    System.out.print("Add number of episodes: ");
                    int episodes = in.nextInt();
                    System.out.print("Add preview date (ex. 16.11.2004): ");
                    String year = scanString.nextLine();
                    //System.out.println(dateFormat.format(date));
                    String response = insertSerial(client,title,character,seasons, episodes,year);
                    System.out.println("The row insert, choose 1 to show table");
                    System.out.println("Id: " + response);
                    break;
                case 3:
                    System.out.print("Which row update, enter id: ");
                    int id = in.nextInt();
                    System.out.print("Update title? (press Enter to skip)");
                    String newTitle = scanString.nextLine();
                    System.out.print("Update character? (press Enter to skip)");
                    String newCharacter = scanString.nextLine();
                    System.out.print("Update number of seasons? (press 0 to skip)");
                    int newSeasons = in.nextInt();
                    System.out.print("Update number of episodes? (press 0 to skip)");
                    int newEpisodes = in.nextInt();
                    System.out.print("Update preview date (ex. 16.11.2004): ");
                    String newYear = scanString.nextLine();
//                    System.out.print(newYear);
                    //SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd.MM.yyyy");
                    String date1 = (newYear != null && !newYear.trim().isEmpty()) ? newYear : "0";
                    String updateResponse = updateSerial(client, id,newTitle,newCharacter,newSeasons, newEpisodes, date1);
                    System.out.println("The row update, choose 1 to show table");
                    System.out.println("Response: Update " + updateResponse);
                    break;
                case 4:
                    System.out.print("Which row delete, enter id: ");
                    int deleteId = in.nextInt();
                    String deleteResponse = deleteSerial(client, deleteId);
                    System.out.println("Response: Delete " + deleteResponse);
                    break;
//            case 5:
//                break;
                default:
                    break;
            }
            if (option == 5) break;
        }
        scanString.close();
        in.close();
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

    private static String insertSerial(Client client, String title, String character,
                                             Integer seasons, Integer episodes, String year)
    {
        WebResource webResource = client.resource(URL);
        String json = "{\"title\":"+title+",\"character\":'"+character+"',\"seasons\":"
                +seasons+",\"episodes\":"+episodes+",\"year\":"+year+"}";
        System.out.println(json);
        ClientResponse response = webResource.accept("application/json").type("application/json")
                .post(ClientResponse.class,json);
        if (response.getStatus() !=
                ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed");
        }
        return response.getEntity(String.class);
    }

    private static String updateSerial(Client client, Integer id, String title, String character,
                                       Integer seasons, Integer episodes, String year)
    {
        WebResource webResource = client.resource(URL);
        String json = "{\"id\":"+id+",\"title\":'"+title+"',\"character\":'"+character+"',\"seasons\":"
                +seasons+",\"episodes\":"+episodes+",\"year\":"+year+"}";
        System.out.println(json);
        ClientResponse response = webResource.accept("application/json").type("application/json")
                .put(ClientResponse.class,json);
        if (response.getStatus() !=
                ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed");
        }
        return response.getEntity(String.class);
    }

    private static String deleteSerial(Client client, Integer id)
    {
        WebResource webResource = client.resource(URL);
        ClientResponse response = webResource.accept("application/json").type("application/json")
                .delete(ClientResponse.class,"{\"id\":"+id+"}");
        if (response.getStatus() !=
                ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed");
        }
        return response.getEntity(String.class);
    }

    private static void printList(List<Serial> serials) {
        for (Serial serial : serials) {
            System.out.println(serial);
        }
    }
}
