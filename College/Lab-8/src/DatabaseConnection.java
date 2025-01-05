import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5433/java_lab-8";
        String user = "postgres";  // Your PostgreSQL username
        String password = "414618";  // Your PostgreSQL password
        return DriverManager.getConnection(url, user, password);
    }
}
