package org.example;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Path("/serials")
@Produces(MediaType.APPLICATION_JSON)
public class SerialResource {

    private DataSource dataSource;
    public SerialResource() {
        try {
            InitialContext initialContext = new InitialContext();
            dataSource = (DataSource) initialContext.lookup("jdbc/postgres");
            System.err.println("DataSource is created: " + (dataSource != null));
        } catch (Exception e) {
            System.err.println("Init exception: " + e);
        }
    }

    @GET
    public List<Serial> getSerialByTitle(@QueryParam("title") String title) {
        List<Serial> serial = new PostgreSQLDAO(getConnection()).getSerialByTitle(title);
        System.out.println(serial);
        return serial;
    }

    private Connection getConnection() {
        Connection result = null;
        try {
            result = dataSource.getConnection();
        } catch (SQLException ex) {
            System.err.println("Exception: " + ex);
        }
        return result;
    }
}