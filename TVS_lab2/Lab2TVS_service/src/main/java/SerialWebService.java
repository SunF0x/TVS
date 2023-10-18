import java.sql.Connection;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
@WebService(targetNamespace="http://tx.wsdl.java/", serviceName = "SerialService")
public class SerialWebService {
    Connection connection = ConnectionUtil.getConnection();
    @WebMethod(operationName = "getSerial")
    public List<Serial> getSerial() {
        System.out.println("Start getSerial");
        PostgreSQLDAO dao = new PostgreSQLDAO(connection);
        return dao.getSerial();
    }

    @WebMethod(operationName = "insertSerial")
    public String insertSerial(String title, String character,
                               Integer seasons, Integer episodes, java.util.Date year) {
        System.out.println("Start insertSerial");
        PostgreSQLDAO dao = new PostgreSQLDAO(connection);
        return dao.insertSerial(title,character,seasons,episodes,year);
    }

    @WebMethod(operationName = "updateSerial")
    public String updateSerial(Integer id, String title, String character,
                               Integer seasons, Integer episodes, java.util.Date year) {
        System.out.println("Start updateSerial");
        PostgreSQLDAO dao = new PostgreSQLDAO(connection);
        return dao.updateSerial(id,title,character,seasons,episodes,year);
    }

    @WebMethod(operationName = "deleteSerial")
    public Integer deleteSerial(Integer id) {
        System.out.println("Start deleteSerial");
        PostgreSQLDAO dao = new PostgreSQLDAO(connection);
        return dao.deleteSerial(id);
    }
}
