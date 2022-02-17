import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class JdbcSql{
    public static void createNewDatabase(String fileName) {
        String url = "jdbc:sqlite:D:/java programs/" + fileName;
        try {
            Connection conn = DriverManager.getConnection(url);
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    } 
    public static void createNewTable() {   
        String url = "jdbc:sqlite:D:/java programs/MovieDatabase.db";  
        String sql = "CREATE TABLE Movies "  
                    + " (name text ,\n"  
                    + " actor text ,\n"  
                    + " actress text ,\n" 
                    + " director text ,\n" 
                    + " year integer )";     
        try{  
            Connection conn = DriverManager.getConnection(url);  
            Statement stmt = conn.createStatement();  
            stmt.execute(sql);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
            System.out.println("hERE IS THE PROBEM");
        }  
    }
    
    public static void main(String[] args) {
            createNewDatabase("MovieDatabase.db");
            createNewTable(); 
            InsertRecords app = new InsertRecords(); 
            app.insert("Se7en","Brad Pitt","somebody","David fincher", 1995);  
            app.insert("The Matrix","Keanu Reeves" ,"Zoe Saldana","No one",1998);  
            app.insert("Avatr","Sam Washinton","Ellen Page","I dont knwo",2010);  
            app.insert("Inception","Leo DiCap","Marion Cotillard","No idea",2010);
            app.insert("TITANIC", "Leo DiCap","Kate Winslet","J=ames Cameron",1997);
            SelectRecords app1 = new SelectRecords();  
            app1.selectAll();  
            System.out.println("\n\nI know the output is going to be messy. Didnt see the mail until 4 hours before submitting.\nSorry");
    }
}
