package serialPackage;

import javax.ws.rs.WebApplicationException;

import com.sun.jersey.api.client.ClientResponse.Status;
import com.sun.jersey.core.util.Base64;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

public class AuthenticationFilter implements ContainerRequestFilter {

    @Override
    public ContainerRequest filter(ContainerRequest containerRequest)
            throws WebApplicationException {
        String httpMethod = containerRequest.getMethod();
        String path = containerRequest.getPath();

        // Allow GET wadl
        if (httpMethod.equals("GET")) {
            return containerRequest;
        }

        String auth = containerRequest.getHeaderValue("authorization");

        // Return 401 if authorization header is missing
        if (auth == null) {
            throw new WebApplicationException(Status.UNAUTHORIZED.getStatusCode());
        }

        boolean isAuthenticated = checkAuthentication(auth);
        System.out.println(isAuthenticated);

        if (isAuthenticated) {
            return containerRequest;
        }
        else throw new WebApplicationException(Status.FORBIDDEN.getStatusCode());
    }

    // For simplicity, it checks only if auth contains "basic"
    private boolean checkAuthentication(String auth) {
        auth = auth.replaceFirst("Basic ", "");
        String userColonPass = Base64.base64Decode(auth);
        return userColonPass.equals("admin:adm1n");
    }
}
