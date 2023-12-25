package serialPackage;

import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.ClassNamesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import java.io.IOException;
import java.net.URI;
import java.sql.Connection;

import org.glassfish.grizzly.http.server.HttpServer;

public class App {
    private static final URI BASE_URI =
            URI.create("http://localhost:8081/rest/");
    public static void main(String[] args) {
        HttpServer server = null;
        try {
            ResourceConfig resourceConfig = new ClassNamesResourceConfig(SerialResource.class);
            resourceConfig.getProperties().put(ResourceConfig.PROPERTY_CONTAINER_REQUEST_FILTERS,
                    "serialPackage.AuthenticationFilter");
            server = GrizzlyServerFactory.createHttpServer(BASE_URI, resourceConfig);
            server.start();
            System.in.read();
            stopServer(server);
        } catch (IOException e) {
            e.printStackTrace();
            stopServer(server);
        }
    }

    private static void stopServer(HttpServer server) {
        if (server != null)
            server.stop();
    }
}