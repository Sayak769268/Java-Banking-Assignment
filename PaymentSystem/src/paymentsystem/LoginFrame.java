package paymentsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginFrame() {
        setTitle("Payment System - Login / Create Account");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1));

        // Username
        JPanel userPanel = new JPanel();
        userPanel.add(new JLabel("Username: "));
        usernameField = new JTextField(20);
        userPanel.add(usernameField);
        add(userPanel);

        // Password
        JPanel passPanel = new JPanel();
        passPanel.add(new JLabel("Password: "));
        passwordField = new JPasswordField(20);
        passPanel.add(passwordField);
        add(passPanel);

        // Buttons
        JButton createBtn = new JButton("Create Account");
        JButton loginBtn = new JButton("Login");

        JPanel btnPanel = new JPanel();
        btnPanel.add(createBtn);
        btnPanel.add(loginBtn);
        add(btnPanel);

        // Message
        JLabel messageLabel = new JLabel("", SwingConstants.CENTER);
        add(messageLabel);

        // Actions
        createBtn.addActionListener(e -> {
            String user = usernameField.getText().trim();
            String pass = new String(passwordField.getPassword());

            if (user.isEmpty() || pass.isEmpty()) {
                messageLabel.setText("Enter both username and password!");
                return;
            }

            boolean created = AccountManager.createAccount(user, pass);
            if (created) {
                messageLabel.setText("Account created! You can now login.");
            } else {
                messageLabel.setText("Username already exists!");
            }
        });

        loginBtn.addActionListener(e -> {
            String user = usernameField.getText().trim();
            String pass = new String(passwordField.getPassword());

            if (AccountManager.login(user, pass)) {
                messageLabel.setText("Login successful!");
                new DashboardFrame(user); // open dashboard
                dispose(); // close login window
            } else {
                messageLabel.setText("Invalid credentials!");
            }
        });

        setVisible(true);
    }
}