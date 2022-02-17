import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class InsertRecords {
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

    public void insert(String name, String actor, String actress, String director, double year) {
        String sql = "INSERT INTO Movies(name, actor, actress,director, year) VALUES(?,?,?,?,?)";
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, actor);
            pstmt.setString(3,actress);
            pstmt.setString(4,director);
            pstmt.setDouble(5, year);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}