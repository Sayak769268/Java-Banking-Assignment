package paymentsystem;

import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {

    private String username;
    private JTextArea messageArea;

    public DashboardFrame(String username) {
        this.username = username;

        setTitle("Payment Dashboard - " + username);
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Top Panel
        JLabel welcome = new JLabel("Welcome, " + username, SwingConstants.CENTER);
        welcome.setFont(new Font("Arial", Font.BOLD, 20));
        welcome.setOpaque(true);
        welcome.setBackground(new Color(50, 150, 250));
        welcome.setForeground(Color.WHITE);
        welcome.setPreferredSize(new Dimension(600, 50));
        add(welcome, BorderLayout.NORTH);

        // Center Buttons
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 2, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JButton creditBtn = new JButton("Credit Card Payment");
        JButton upiBtn = new JButton("UPI Payment");
        JButton withdrawBtn = new JButton("Withdraw");
        JButton historyBtn = new JButton("Show Transaction History");
        JButton exitBtn = new JButton("Logout");

        centerPanel.add(creditBtn);
        centerPanel.add(upiBtn);
        centerPanel.add(withdrawBtn);
        centerPanel.add(historyBtn);
        centerPanel.add(exitBtn);

        add(centerPanel, BorderLayout.CENTER);

        // Bottom Message Area
        messageArea = new JTextArea();
        messageArea.setEditable(false);
        messageArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(messageArea);
        scrollPane.setPreferredSize(new Dimension(580, 150));
        add(scrollPane, BorderLayout.SOUTH);

        // Button Actions
        creditBtn.addActionListener(e -> processPayment("CreditCard"));
        upiBtn.addActionListener(e -> processPayment("UPI"));
        withdrawBtn.addActionListener(e -> processPayment("Withdraw"));
        historyBtn.addActionListener(e -> showHistory());

        exitBtn.addActionListener(e -> {
            dispose();
            new LoginFrame();
        });

        setVisible(true);
    }

    private void processPayment(String type) {

        String detail = "";

        if (type.equals("CreditCard")) {
            detail = JOptionPane.showInputDialog(this, "Enter Card Number:");
        }

        if (type.equals("UPI")) {
            detail = JOptionPane.showInputDialog(this, "Enter UPI ID:");
        }

        String amountStr = JOptionPane.showInputDialog(this, "Enter Amount:");

        double amount;
        try {
            amount = Double.parseDouble(amountStr);
            if (amount <= 0) throw new NumberFormatException();
        } catch (Exception e) {
            showMessage("Invalid amount!\n");
            return;
        }

        try {
            Payment payment =
                    PaymentFactory.createPayment(type, amount, detail);

            if (payment instanceof BasePaymentWithGUI) {
                ((BasePaymentWithGUI) payment).setMessageArea(messageArea);
            }

            payment.processPayment();

        } catch (IllegalArgumentException e) {
            showMessage("Invalid payment type!\n");
        }
    }

    private void showHistory() {
        java.util.List<String> history = TransactionManager.getHistory();

        if (history.isEmpty()) {
            showMessage("No transactions found.\n");
        } else {
            showMessage("===== TRANSACTION HISTORY =====");
            for (String record : history) {
                showMessage(record);
            }
            showMessage("");
        }
    }

    private void showMessage(String msg) {
        messageArea.append(msg + "\n");
        messageArea.setCaretPosition(messageArea.getDocument().getLength());
    }
}