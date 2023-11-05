import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
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
                               Integer seasons, Integer episodes, java.util.Date year)
            throws NegativeValueException, InvalidDateException {
        System.out.println("Start insertSerial");
        PostgreSQLDAO dao = new PostgreSQLDAO(connection);
        if (seasons <= 0) {
            SerialServiceFault fault =
                    SerialServiceFault.defaultInstance();
            throw new NegativeValueException("Negative value of seasons",
                    fault);
        }
        if (episodes <= 0) {
            SerialServiceFault fault =
                    SerialServiceFault.defaultInstance();
            throw new NegativeValueException("Negative value of episodes",
                    fault);
        }
        if (year.after(new Date())) {
            SerialServiceFault fault =
                    SerialServiceFault.defaultInstance();
            throw new InvalidDateException("Date in the future",
                    fault);
        }
        return dao.insertSerial(title,character,seasons,episodes,year);
    }

    @WebMethod(operationName = "updateSerial")
    public String updateSerial(Integer id, String title, String character,
                               Integer seasons, Integer episodes, java.util.Date year)
            throws NonExistentIdException, EmptyDataException, NegativeValueException, InvalidDateException {
        System.out.println("Start updateSerial");
        PostgreSQLDAO dao = new PostgreSQLDAO(connection);
        String response = dao.updateSerial(id,title,character,seasons,episodes,year);
        if (seasons < 0) {
            SerialServiceFault fault =
                    SerialServiceFault.defaultInstance();
            throw new NegativeValueException("Negative value of seasons",
                    fault);
        }
        if (episodes < 0) {
            SerialServiceFault fault =
                    SerialServiceFault.defaultInstance();
            throw new NegativeValueException("Negative value of episodes",
                    fault);
        }

        if (year.after(new Date())) {
            SerialServiceFault fault =
                    SerialServiceFault.defaultInstance();
            throw new InvalidDateException("Date in the future",
                    fault);
        }

        if (Objects.equals(response,"0")) {
            SerialServiceFault fault =
                    SerialServiceFault.defaultInstance();
            throw new NonExistentIdException("Serial Id is not existed",
                    fault);
        } else if (Objects.equals(response,"Nothing to change")) {
            SerialServiceFault fault =
                    SerialServiceFault.defaultInstance();
            throw new EmptyDataException("Nothing added to change",
                    fault);
        }
        return response;
    }

    @WebMethod(operationName = "deleteSerial")
    public Integer deleteSerial(Integer id) throws NonExistentIdException {
        System.out.println("Start deleteSerial");
        PostgreSQLDAO dao = new PostgreSQLDAO(connection);
        Integer response = dao.deleteSerial(id);
        if (response == 0) {
            SerialServiceFault fault =
                    SerialServiceFault.defaultInstance();
            throw new NonExistentIdException("Serial Id is not existed",
                    fault);
        }
//        System.out.println(response);
        return response;
    }
}
