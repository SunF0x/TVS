import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
@WebService(targetNamespace="http://tx.wsdl.java/", serviceName = "SerialService")
public class SerialWebService {
    @WebMethod(operationName = "getSerial")
    public List<Serial> getSerial() {
        System.out.println("Start getSerial");
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return dao.getSerial();
    }
}
