import java.sql.*;

public class ShipmentManager {
    public void addShipment(int customerID, int courierID, String status) {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Shipments (ShipmentID, CustomerID, CourierID, Status) VALUES (shipment_sequence.nextval, ?, ?, ?)")) {
            preparedStatement.setInt(1, customerID);
            preparedStatement.setInt(2, courierID);
            preparedStatement.setString(3, status);
            preparedStatement.executeUpdate();
            System.out.println("Shipment added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding shipment: " + e.getMessage());
        }
    }
}
