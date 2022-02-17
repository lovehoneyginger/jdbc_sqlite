import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class SelectRecords {
    private Connection connect() {
        String url = "jdbc:sqlite:D:/java programs/MovieDatabase.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void selectAll() {
        String sql = "SELECT * FROM Movies";
        try {
            Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(
                        rs.getString("name") + "\t" +
                        rs.getString("actor") + "\t" +
                        rs.getString("actress") + "\t" +
                        rs.getString("director") + "\t" +
                        rs.getDouble("year"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}