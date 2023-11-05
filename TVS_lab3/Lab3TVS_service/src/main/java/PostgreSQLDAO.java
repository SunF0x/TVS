import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
public class PostgreSQLDAO {
    private final Connection connection;
    public PostgreSQLDAO(Connection connection) {
        this.connection = connection;
    }
    public List<Serial> getSerial() {
        List<Serial> serials = new ArrayList<>();
        try (Statement stmt = connection.createStatement()){
            ResultSet rs = stmt.executeQuery("select * from serials;");
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String character = rs.getString("character");
                int seasons = rs.getInt("seasons");
                int episodes = rs.getInt("episodes");
                Date year = rs.getDate("year");
                Serial serial = new Serial(id, title, character, seasons, episodes, year);
                serials.add(serial);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        System.out.println(serials);
        return serials;
    }

    public String insertSerial(String title, String character,
                               Integer seasons, Integer episodes, java.util.Date year) {
        String response = "... Nothing added";
        System.out.println(title + character + seasons + episodes + year);
        try (Statement stmt = connection.createStatement()) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = formatter.format(year);
            String str = "insert into serials (title, character, seasons,episodes, year) values " +
                    "('" + title + "','" + character + "'," + seasons + "," + episodes +",'" + formattedDate +"');";
            System.out.println(str);
            int rs = stmt.executeUpdate(str);
            if (rs == 0) {
                throw new SQLException("Creating serial failed, no rows affected.");
            } else {
                ResultSet res = stmt.executeQuery("select id from serials where title='"+title+"';");
                System.out.println(res);
                int returnId = 0;
                while (res.next()) {
                    returnId = res.getInt("id");
                }
                response = String.valueOf(returnId);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        System.out.println(response);
        return response;
    }

    public String updateSerial(Integer id, String title, String character,
                               Integer seasons, Integer episodes, java.util.Date year) {
        String response = "Nothing added";
        System.out.println(id + title + character + seasons + episodes + year);
        try (Statement stmt = connection.createStatement()) {
            String updateStr = "";
            if (title != null && !title.trim().isEmpty()) {
                updateStr += "title = '" + title + "',";
            }
            if (character != null && !character.trim().isEmpty()) {
                updateStr += "character = '" + character + "',";
            }
            if (seasons != 0) {
                updateStr += "seasons = " + seasons + ",";
            }
            if (episodes != 0) {
                updateStr += "episodes = " + episodes + ",";
            }
            if (year != null) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String formattedDate = formatter.format(year);
                System.out.println(formattedDate);
                if (!Objects.equals(formattedDate, "1970-01-01")) {
                    updateStr += "year = '" + formattedDate + "',";
                }
            }
            if (updateStr != "") {
                updateStr = updateStr.substring(0, updateStr.length() - 1);
                String str = "update serials set " + updateStr + "where id=" + id;
                System.out.println(str);
                int rs = stmt.executeUpdate(str);
                System.out.println(rs);
                response = String.valueOf(rs);
            }
            else response = "Nothing to change";
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        System.out.println(response);
        return response;
    }

    public Integer deleteSerial(Integer id) {
        Integer response = 0;
//        System.out.println(id);
        try (Statement stmt = connection.createStatement()) {
            String str = "delete from serials where id=" + id + ";";
//            System.out.println(str);
            int rs = stmt.executeUpdate(str);
            System.out.println(rs);
            response = rs;
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
//        System.out.println(response);
        return response;
    }

}
