import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeliveryRouteManager {
    public void addDeliveryRoute(String origin, String destination, double distance) {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO DeliveryRoutes (RouteID, Origin, Destination, Distance) VALUES (route_sequence.nextval, ?, ?, ?)")) {
            preparedStatement.setString(1, origin);
            preparedStatement.setString(2, destination);
            preparedStatement.setDouble(3, distance);
            preparedStatement.executeUpdate();
            System.out.println("Delivery route added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding delivery route: " + e.getMessage());
        }
    }

}

