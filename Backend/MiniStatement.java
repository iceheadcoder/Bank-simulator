import java.awt.Color;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class MiniStatement extends JFrame {

    MiniStatement(String passwordString) {
        setTitle("Mini Statement");
        setLayout(null);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20, 460, 360, 20);
        add(balance);

        // Create JTable for transactions
        String[] columnNames = {"Date", "Type", "Amount"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable transactionTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(transactionTable);
        scrollPane.setBounds(14, 140, 360, 300);
        add(scrollPane);

        try {
            DBconnection c = new DBconnection();

            // Fetch card details
            PreparedStatement ps1 = c.c.prepareStatement("select * from login where pin = ?");
            ps1.setString(1, passwordString);
            ResultSet rs1 = ps1.executeQuery();
            if (rs1.next()) {
                card.setText("Card Number: " + rs1.getString("cardnumber").substring(0, 4) + "XXXXXXXX" +
                             rs1.getString("cardnumber").substring(12));
            }

            // Fetch transaction details and calculate balance
            int bal = 0;
            PreparedStatement ps2 = c.c.prepareStatement("select * from bank where pin = ?");
            ps2.setString(1, passwordString);
            ResultSet rs2 = ps2.executeQuery();

            while (rs2.next()) {
                String date = rs2.getString("date");
                String type = rs2.getString("type");
                String amount = rs2.getString("amount");

                // Add transaction to the table
                tableModel.addRow(new Object[]{date, type, amount});

                // Update balance
                if (type.equalsIgnoreCase("Deposit")) {
                    bal += Integer.parseInt(amount);
                } else {
                    bal -= Integer.parseInt(amount);
                }
            }

            balance.setText("Your current account balance is Rs " + bal);

        } catch (Exception e) {
            System.out.println(e);
        }

        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}
