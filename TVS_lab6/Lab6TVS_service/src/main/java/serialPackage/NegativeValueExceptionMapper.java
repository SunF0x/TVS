package serialPackage;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NegativeValueExceptionMapper implements
        ExceptionMapper<NegativeValueException> {
    @Override
    public Response toResponse(NegativeValueException e) {
        return
                Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
    }
}
