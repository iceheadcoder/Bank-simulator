import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Withdrawal extends JFrame implements ActionListener {

    JButton withdraw, back;
    JTextField amount;
    String passwordString;

    Withdrawal(String passwordString){
        this.passwordString = passwordString;

        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,820);
        add(image);


        JLabel text = new JLabel("Enter the amount you want to Withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        text.setBounds(190, 300, 400, 20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD,16));
        amount.setBounds(176,350,320,25);
        image.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355,485,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        


        setSize(900,900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
        {
            if(ae.getSource() == withdraw){
                String number = amount.getText();
                Date date = new Date();
                if(number.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to Withdraw");
                }else{
                    try {
                    DBconnection c = new DBconnection();
                    String query = "insert into bank values('"+passwordString+"','"+date+"','Withdrawal','"+number+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+number+" Withdrawn Successfully");
                    setVisible(false);
                    new Transactions(passwordString).setVisible(true);
                    } catch (Exception e) {
                       System.out.println(e); 
                    }
                    
                }
                
            }else if(ae.getSource() == back){
                setVisible(false);
                new Transactions(passwordString).setVisible(true);
            }

    }



    public static void main(String[] args) {
        new Withdrawal("");
    }
}
