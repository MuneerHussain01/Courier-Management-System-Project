import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl"; // Oracle JDBC URL
    private static final String USERNAME = "system";
    private static final String PASSWORD = "Oracle_1";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
