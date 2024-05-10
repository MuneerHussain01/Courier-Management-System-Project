import java.util.Date;
import java.sql.*;

public class ReportGenerator {
    public void generateReport(String content) {
        Date currentDate = new Date();
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Reports (ReportID, ReportDate, Content) VALUES (report_sequence.nextval, ?, ?)")) {
            preparedStatement.setDate(1, new java.sql.Date(currentDate.getTime()));
            preparedStatement.setString(2, content);
            preparedStatement.executeUpdate();
            System.out.println("Report generated successfully.");
        } catch (SQLException e) {
            System.out.println("Error generating report: " + e.getMessage());
        }
    }
}
