package serialPackage;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/serials")
@Produces({MediaType.APPLICATION_JSON})
public class SerialResource {

    static final Connection connection = ConnectionUtil.getConnection();

    @GET
    public List<Serial> getSerialByTitle(@QueryParam("title") String title) {
        List<Serial> serial = new PostgreSQLDAO(connection).getSerialByTitle(title);
        return serial;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String insertSerial(String data) throws JSONException, ParseException, NegativeValueException, InvalidDateException {
        JSONObject obj = new JSONObject(data);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = dateFormat.parse(obj.getString("year"));
        if (Integer.parseInt(obj.getString("seasons")) <= 0) {
            throw NegativeValueException.DEFAULT_INSTANCE;
        }
        if (Integer.parseInt(obj.getString("episodes")) <= 0) {
            throw NegativeValueException.DEFAULT_INSTANCE;
        }
        if (date.after(new Date())) {
            throw InvalidDateException.DEFAULT_INSTANCE;
        }
        return new PostgreSQLDAO(connection)
                .insertSerial(obj.getString("title"),
                        obj.getString("character"),
                        Integer.parseInt(obj.getString("seasons")),
                        Integer.parseInt(obj.getString("episodes")),date);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String updateSerial(String data) throws JSONException, ParseException, NegativeValueException, InvalidDateException, EmptyDataException, NonExistentIdException {
        JSONObject obj = new JSONObject(data);
        System.out.println(obj.getString("year"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = Objects.equals(obj.getString("year"), "0") ? new Date(0) : dateFormat.parse(obj.getString("year"));
        if (Integer.parseInt(obj.getString("seasons")) < 0) {
            throw NegativeValueException.DEFAULT_INSTANCE;
        }
        if (Integer.parseInt(obj.getString("episodes")) < 0) {
            throw NegativeValueException.DEFAULT_INSTANCE;
        }
        if (date.after(new Date())) {
            throw InvalidDateException.DEFAULT_INSTANCE;
        }
        String response = new PostgreSQLDAO(connection)
                .updateSerial(Integer.parseInt(obj.getString("id")),
                        obj.getString("title"),
                        obj.getString("character"),
                        Integer.parseInt(obj.getString("seasons")),
                        Integer.parseInt(obj.getString("episodes")),date);
        if (Objects.equals(response,"0")) {
            throw NonExistentIdException.DEFAULT_INSTANCE;
        } else if (Objects.equals(response,"... Nothing to change")) {
            throw EmptyDataException.DEFAULT_INSTANCE;
        }
        return response;
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteSerial(String data) throws JSONException, NonExistentIdException {
        JSONObject obj = new JSONObject(data);
        String response = new PostgreSQLDAO(connection).deleteSerial(Integer.parseInt(obj.getString("id")));
        if (Objects.equals(response, "0"))
            throw NonExistentIdException.DEFAULT_INSTANCE;
        return response;
    }
}