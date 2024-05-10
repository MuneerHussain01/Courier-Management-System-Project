import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;     

public class LoginUI {
    private static final String CORRECT_USERNAME = "munir";
    private static final String CORRECT_PASSWORD = "12345";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginUI::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setResizable(false); // Prevent resizing

        // Load the image
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\B.J COMP\\OneDrive\\Desktop\\DBMS\\courier_image.png");
        Image image = imageIcon.getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        JLabel imageLabel = new JLabel(imageIcon);
        frame.setContentPane(imageLabel);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setOpaque(false); // Make panel transparent
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(new Color(25, 25, 112)); // Navy blue text color
        panel.add(usernameLabel, gbc);

        gbc.gridx++;
        JTextField usernameField = new JTextField(15);
        panel.add(usernameField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(new Color(25, 25, 112)); // Navy blue text color
        panel.add(passwordLabel, gbc);

        gbc.gridx++;
        JPasswordField passwordField = new JPasswordField(15);
        panel.add(passwordField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        JButton loginButton = new JButton("Login");
        loginButton.setBackground(new Color(70, 130, 180)); // Steel blue background
        loginButton.setForeground(Color.WHITE); // White text color
        panel.add(loginButton, gbc);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (username.equals(CORRECT_USERNAME) && password.equals(CORRECT_PASSWORD)) {
                    frame.dispose(); // Close the login window
                    openCourierManagementUI(); // Open Courier Management UI
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.add(panel, gbc);
        frame.pack();
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
    }

    private static void openCourierManagementUI() {
        // Here you can open the Courier Management UI
        CourierManagementUI.main(new String[]{});
    }
}
