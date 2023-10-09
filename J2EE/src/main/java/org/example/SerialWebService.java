package org.example;

import java.util.List;

import jakarta.annotation.Resource;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.annotation.PostConstruct;

import javax.naming.InitialContext;
import javax.sql.DataSource;
@WebService(serviceName = "SerialService") //targetNamespace="http://127.0.0.1:8081/SerialService",
public class SerialWebService {
//    @Resource(lookup = "jdbc/postgres")
    private DataSource dataSource;

    public SerialWebService() {
        try {
            InitialContext initialContext = new InitialContext();
            dataSource = (DataSource) initialContext.lookup("jdbc/postgres");
            System.err.println("DataSource is created: " + (dataSource != null));
        } catch (Exception e) {
            System.err.println("Init exception: " + e);
        }
    }

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SerialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "getSerial")
    public List<Serial> getSerial() {
        Connection connection = getConnection();
        SerialDAO dao = new SerialDAO(connection);
//        SerialDAO dao = new SerialDAO(getConnection());
        return dao.getSerial();
    }
//    @WebMethod(operationName = "getSerialByName")
//    public List<Serial> getSerialByName (@WebParam(name = "serialName") String title){
//        SerialDAO dao = new SerialDAO(getConnection());
//        return dao.getSerialByName(title);
//    }

    private Connection getConnection() {
        Connection result = null;
        try {
            result = dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(SerialWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
