import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Transactions extends JFrame implements ActionListener{

    JButton deposit,withdraw,minSt,pinchange,fastcash,balanceEnq,exit;
    String passwordString;

    Transactions(String passwordString){
        this.passwordString = passwordString;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,820);
        add(image);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(220, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD,16));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(170,410,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(360,410,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170,446,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        minSt = new JButton("Mini Statement");
        minSt.setBounds(360,446,150,30);
        minSt.addActionListener(this);
        image.add(minSt);

        pinchange = new JButton("PIN change");
        pinchange.setBounds(170,482,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceEnq = new JButton("Balance Enquiry");
        balanceEnq.setBounds(360,482,150,30);
        balanceEnq.addActionListener(this);
        image.add(balanceEnq);

        exit = new JButton("Exit");
        exit.setBounds(410,520,100,30);
        exit.setForeground(Color.BLACK);
        exit.setBackground(Color.RED);
        exit.addActionListener(this);
        image.add(exit);


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true); //to make full window image
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        new Transactions("");
    }
}
