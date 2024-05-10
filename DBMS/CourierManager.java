import java.sql.*;

public class CourierManager {
    public void addCourier(String name, String vehicleType, int capacity) {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Couriers (CourierID, Name, VehicleType, Capacity) VALUES (courier_sequence.nextval, ?, ?, ?)")) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, vehicleType);
            preparedStatement.setInt(3, capacity);
            preparedStatement.executeUpdate();
            System.out.println("Courier added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding courier: " + e.getMessage());
        }
    }
}
