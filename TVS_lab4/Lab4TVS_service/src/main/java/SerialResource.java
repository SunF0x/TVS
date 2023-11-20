import java.sql.Connection;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/serials")
@Produces({MediaType.APPLICATION_JSON}) // MediaType.APPLICATION_XML
public class SerialResource {
    Connection connection = ConnectionUtil.getConnection();

    @GET
    public List<Serial> getSerialByTitle(@QueryParam("title") String title) {
        List<Serial> serial = new PostgreSQLDAO(connection).getSerialByTitle(title);
        return serial;
    }
}