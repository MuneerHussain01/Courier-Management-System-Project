import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;       

public class CourierManagementUI {
    private static CourierManager courierManager = new CourierManager();
    private static ShipmentManager shipmentManager = new ShipmentManager();
    private static ReportGenerator reportGenerator = new ReportGenerator();

    private static JPanel mainPanel;
    private static CardLayout cardLayout;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CourierManagementUI::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Courier Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the frame
        frame.setUndecorated(true); // Remove window decorations
        frame.setVisible(true); // Set frame visible first to ensure proper maximization

        // Load the image
        ImageIcon backgroundImage = new ImageIcon("");

        // Create a JLabel with the image as its icon
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight()); // Set size to cover the entire frame

        // Create a panel to hold other components
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(backgroundLabel); // Add the background label to the panel

        // Create title panel
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(new Color(70, 130, 180)); // Steel blue background

        JLabel titleLabel = new JLabel("Courier Management System");
        titleLabel.setForeground(Color.WHITE); // White text color
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titlePanel.add(titleLabel, BorderLayout.CENTER);

        JButton minimizeButton = new JButton("-");
        minimizeButton.setFocusable(false);
        minimizeButton.setBackground(new Color(70, 130, 180)); // Steel blue background
        minimizeButton.setForeground(Color.WHITE); // White text color
        minimizeButton.setBorder(null);
        minimizeButton.addActionListener(e -> frame.setState(Frame.ICONIFIED));

        JButton closeButton = new JButton("X");
        closeButton.setFocusable(false);
        closeButton.setBackground(new Color(70, 130, 180)); // Steel blue background
        closeButton.setForeground(Color.WHITE); // White text color
        closeButton.setBorder(null);
        closeButton.addActionListener(e -> System.exit(0));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        buttonPanel.setBackground(new Color(70, 130, 180)); // Steel blue background
        buttonPanel.add(minimizeButton);
        buttonPanel.add(closeButton);
        titlePanel.add(buttonPanel, BorderLayout.EAST);

        contentPanel.add(titlePanel, BorderLayout.NORTH);

        mainPanel = new JPanel();
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);
        mainPanel.setOpaque(false); // Make main panel transparent

        addCourierManagementPanel();
        addShipmentManagementPanel();
        addReportGenerationPanel();

        contentPanel.add(mainPanel, BorderLayout.CENTER);

        cardLayout.show(mainPanel, "Courier Management");

        frame.getContentPane().add(contentPanel);

        frame.revalidate();
        frame.repaint();
    }

    private static void addCourierManagementPanel() {
        JPanel courierPanel = new JPanel(new GridBagLayout());
        courierPanel.setOpaque(false); // Make courier panel transparent
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel nameLabel = new JLabel("Courier Name:");
        courierPanel.add(nameLabel, gbc);

        gbc.gridx++;
        JTextField nameField = new JTextField(15);
        courierPanel.add(nameField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        JLabel vehicleLabel = new JLabel("Vehicle Type:");
        courierPanel.add(vehicleLabel, gbc);

        gbc.gridx++;
        JTextField vehicleField = new JTextField(15);
        courierPanel.add(vehicleField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        JLabel capacityLabel = new JLabel("Capacity:");
        courierPanel.add(capacityLabel, gbc);

        gbc.gridx++;
        JTextField capacityField = new JTextField(15);
        courierPanel.add(capacityField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        JButton nextButton = new JButton("Next");
        nextButton.setBackground(new Color(70, 130, 180)); // Steel blue background
        nextButton.setForeground(Color.WHITE); // White text color
        courierPanel.add(nextButton, gbc);

        nextButton.addActionListener(e -> {
            String name = nameField.getText();
            String vehicleType = vehicleField.getText();
            int capacity = Integer.parseInt(capacityField.getText());
            courierManager.addCourier(name, vehicleType, capacity);
            cardLayout.show(mainPanel, "Shipment Management");
        });

        mainPanel.add(courierPanel, "Courier Management");
    }

    private static void addShipmentManagementPanel() {
        JPanel shipmentPanel = new JPanel(new GridBagLayout());
        shipmentPanel.setOpaque(false); // Make shipment panel transparent
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel customerIDLabel = new JLabel("Customer ID:");
        shipmentPanel.add(customerIDLabel, gbc);

        gbc.gridx++;
        JTextField customerIDField = new JTextField(15);
        shipmentPanel.add(customerIDField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        JLabel courierIDLabel = new JLabel("Courier ID:");
        shipmentPanel.add(courierIDLabel, gbc);

        gbc.gridx++;
        JTextField courierIDField = new JTextField(15);
        shipmentPanel.add(courierIDField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        JLabel statusLabel = new JLabel("Status:");
        shipmentPanel.add(statusLabel, gbc);

        gbc.gridx++;
        JTextField statusField = new JTextField(15);
        shipmentPanel.add(statusField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        JButton nextButton = new JButton("Next");
        nextButton.setBackground(new Color(70, 130, 180)); // Steel blue background
        nextButton.setForeground(Color.WHITE); // White text color
        shipmentPanel.add(nextButton, gbc);

        nextButton.addActionListener(e -> {
            int customerID = Integer.parseInt(customerIDField.getText());
            int courierID = Integer.parseInt(courierIDField.getText());
            String status = statusField.getText();
            shipmentManager.addShipment(customerID, courierID, status);
            cardLayout.show(mainPanel, "Report Generation");
        });

        mainPanel.add(shipmentPanel, "Shipment Management");
    }
    

    private static void addReportGenerationPanel() {
        JPanel reportPanel = new JPanel(new GridBagLayout());
        reportPanel.setOpaque(false); // Make report panel transparent
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel reportContentLabel = new JLabel("Report Content:");
        reportPanel.add(reportContentLabel, gbc);

        gbc.gridy++;
        JTextArea reportArea = new JTextArea(4, 20);
        JScrollPane scrollPane = new JScrollPane(reportArea);
        reportPanel.add(scrollPane, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton generateReportButton = new JButton("Generate Report");
        generateReportButton.setBackground(new Color(70, 130, 180)); // Steel blue background
        generateReportButton.setForeground(Color.WHITE); // White text color
        reportPanel.add(generateReportButton, gbc);

        generateReportButton.addActionListener(e -> {
            String content = reportArea.getText();
            reportGenerator.generateReport(content);
            JOptionPane.showMessageDialog(null, "Report generated successfully!");
        });

        mainPanel.add(reportPanel, "Report Generation");
    }
}
