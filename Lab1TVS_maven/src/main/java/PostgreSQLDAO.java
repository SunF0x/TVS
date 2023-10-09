import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class PostgreSQLDAO {
    public List<Serial> getSerial() {
        List<Serial> serials = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection()){
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from serials;");
            while (rs.next()) {
                String title = rs.getString("title");
                String character = rs.getString("character");
                int seasons = rs.getInt("seasons");
                int episodes = rs.getInt("episodes");
                Date year = rs.getDate("year");
                Serial serial = new Serial(title, character, seasons, episodes, year);
                serials.add(serial);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        System.out.println(serials);
        return serials;
    }
}
