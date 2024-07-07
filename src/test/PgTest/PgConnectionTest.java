
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PgConnectionTest {
    public static void main(String[] args) {
        // Database connection parameters
        String url = "jdbc:postgresql://localhost:5432/DB_gestao";
        String user = "postgres";
        String password = "postgres";

        // Attempt to connect to the database
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("Connected to the database successfully!");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while connecting to the database:");
            e.printStackTrace();
        }
    }
}