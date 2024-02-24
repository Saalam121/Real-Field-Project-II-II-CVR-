import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginPage() {
        setTitle("Login");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximizing the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        usernameField = new JTextField(30);
        passwordField = new JPasswordField(20);
        usernameLabel.setFont(new Font("ARIAL", Font.PLAIN, 30));
        passwordLabel.setFont(new Font("ARIAL", Font.PLAIN, 30));
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(usernameLabel, gbc);

        gbc.gridx = 1;
        panel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(loginButton, gbc);

        add(panel);
        setVisible(true);
    }

     public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Check username and password (dummy check, replace with your logic)
            if (username.equals("saalam") && password.equals("password")) {
                JOptionPane.showMessageDialog(this, "Login Successful");

                // Open the FoodOrderingSystem window
                new FoodOrderingSystem();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
        }
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}
