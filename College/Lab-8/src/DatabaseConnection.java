import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver"); // Ensure the driver is loaded
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:postgresql://localhost:5433/java_lab-8";
        String user = "postgres";
        String password = "414618";
        return DriverManager.getConnection(url, user, password);
    }
    
}
