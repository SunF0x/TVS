import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ConnectionUtil {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String JDBC_USER = "postgres";
    private static final String JDBC_PASSWORD = "****";
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static final String createTableSQL = "CREATE TABLE IF NOT EXISTS serials " +
            "(id serial," +
            " title varchar(255) not null, " +
            " character varchar(255) not null, " +
            " seasons integer not null, " +
            " episodes integer not null, " +
            " year date, " +
            " unique(title), " +
            " primary key(id));";

    private static final String insertRowSQL = "insert into serials (title, character, seasons,episodes, year) values" +
	        "('Game of Thrones','Sansa, Jon, Arya', 8,73, '2011-04-17')," +
            "('Lucifer','Chloe, Mazikeen', 6,93,'2016-01-25')," +
            "('Hannibal','Will, Jack', 3,39,'2013-04-13')," +
            "('Teen Wolf','Scott, Stiles', 6,100,'2011-06-5')," +
            "('Sherlock','John, Jim', 4,13,'2010-09-18');";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS serials;");
            statement.execute(createTableSQL);
            statement.execute(insertRowSQL);
            System.out.println("Connect and insert");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("All ok!");
        return connection;
    }
}
