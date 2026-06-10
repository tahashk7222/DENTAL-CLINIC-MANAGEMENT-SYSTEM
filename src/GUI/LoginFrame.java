package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame implements ActionListener {

    JLabel titleLabel;
    JLabel userLabel;
    JLabel passLabel;

    JTextField userField;
    JPasswordField passField;

    JButton loginButton;
    JButton clearButton;

    public LoginFrame() {

        // Frame Settings
        setTitle("Dental Clinic Login");
        setSize(400, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Title
        titleLabel = new JLabel("Dental Clinic Management System");
        titleLabel.setBounds(50, 20, 300, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(titleLabel);

        // Username
        userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 80, 100, 25);
        add(userLabel);

        userField = new JTextField();
        userField.setBounds(150, 80, 150, 25);
        add(userField);

        // Password
        passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 120, 100, 25);
        add(passLabel);

        passField = new JPasswordField();
        passField.setBounds(150, 120, 150, 25);
        add(passField);

        // Login Button
        loginButton = new JButton("Login");
        loginButton.setBounds(70, 180, 100, 30);
        loginButton.addActionListener(this);
        add(loginButton);
        getRootPane().setDefaultButton(loginButton);

        // Clear Button
        clearButton = new JButton("Clear");
        clearButton.setBounds(200, 180, 100, 30);
        clearButton.addActionListener(this);
        add(clearButton);


        // Make Visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Login Button
        if (e.getSource() == loginButton) {

            String username = userField.getText();
            String password = String.valueOf(passField.getPassword());

            // Hardcoded Login
            if (username.equals("admin") && password.equals("123")) {

                JOptionPane.showMessageDialog(this,
                        "Login Successful");

                // Open Dashboard
                new DashboardFrame();

                // Close Login Window
                dispose();

            } else {

                JOptionPane.showMessageDialog(this,
                        "Invalid Username or Password");
            }
        }

        // Clear Button
        if (e.getSource() == clearButton) {

            userField.setText("");
            passField.setText("");
        }
    }
}