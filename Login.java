import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {

    JButton login, clear, signup;
    JTextField cardText;
    JPasswordField pinText;

    Login(){
        setTitle("ATM simulator");
        
        setLayout(null);  //convinces java to not use default layout that places all imgs at center
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);  //image isn't accepted directly into JLabel so i3 is used
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);  //to add anything on to frame use add with obj as paramter
        
        JLabel text = new JLabel("Welcome to the ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200,40, 400, 40);
        add(text);

        JLabel cardno = new JLabel("Card No.");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120,150, 150, 40);
        add(cardno);

        cardText = new JTextField();
        cardText.setFont(new Font("Arial",Font.BOLD, 14));
        cardText.setBounds(300, 150, 230, 40);
        add(cardText);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120,220, 150, 40);
        add(pin);

        pinText = new JPasswordField();
        pinText.setFont(new Font("Arial",Font.BOLD, 14));
        pinText.setBounds(300, 220, 230, 40);
        add(pinText);

        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.white);
        setSize(800,480);
        setVisible(true);
        setLocation(350,200); //this determines where on screen the frame pop up
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            cardText.setText("");
            pinText.setText("");

        }else if(ae.getSource() == login){
             
        }else if(ae.getSource() == signup){
            setVisible(false);
            new Signup().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
