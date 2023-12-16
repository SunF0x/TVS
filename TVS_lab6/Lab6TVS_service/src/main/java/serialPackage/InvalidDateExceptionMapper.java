package serialPackage;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InvalidDateExceptionMapper implements
        ExceptionMapper<InvalidDateException> {
    @Override
    public Response toResponse(InvalidDateException e) {
        return
                Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
    }
}
