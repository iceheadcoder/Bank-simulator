import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class BalanceEnquiry extends JFrame implements ActionListener{

    JButton back;
    String passwordString;

    BalanceEnquiry(String passwordString) {
        this.passwordString = passwordString;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,820);
        add(image);
        
        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        DBconnection c = new DBconnection();
        int Balance = 0;
        
        try {
            ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin = '" + passwordString + "'");
          
            // Check if ResultSet is empty
            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Invalid PIN or no transactions found.");
                return;
            }

            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    Balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    Balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

        } catch (Exception e) {
            System.out.println(e);
    }


        JLabel text = new JLabel("Your current Account Balance is Rs "+ Balance);
        text.setForeground(Color.WHITE);
        text.setBounds(170, 300, 400, 70);
        image.add(text);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(passwordString).setVisible(true);
    


    }
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
