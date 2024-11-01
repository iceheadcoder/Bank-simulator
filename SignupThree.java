import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class SignupThree extends JFrame{
    
    JRadioButton r1,r2,r3,r4;

    SignupThree() {

    setLayout(null);

    JLabel l1 = new JLabel("Page 3: Account Details");
    l1.setFont(new Font("Raleway", Font.BOLD, 22));
    l1.setBounds(280, 40, 400, 40);
    add(l1);

    JLabel type = new JLabel("Account Type:");
    type.setFont(new Font("Raleway", Font.BOLD, 22));
    type.setBounds(100, 140, 200, 30);
    add(type);

    r1 = new JRadioButton("Savings Account");
    r1.setFont(new Font("Raleway", Font.BOLD,16));
    r1.setBackground(Color.WHITE);
    r1.setBounds(100, 180, 160, 20);
    add(r1);

    r2 = new JRadioButton("Fixed Deposit Account");
    r2.setFont(new Font("Raleway", Font.BOLD,16));
    r2.setBackground(Color.WHITE);
    r2.setBounds(300, 180, 200, 20);
    add(r2);

    r3 = new JRadioButton("Current Account");
    r3.setFont(new Font("Raleway", Font.BOLD,16));
    r3.setBackground(Color.WHITE);
    r3.setBounds(100, 220, 200, 20);
    add(r3);

    r4 = new JRadioButton("Recurring Deposit Account");
    r4.setFont(new Font("Raleway", Font.BOLD,16));
    r4.setBackground(Color.WHITE);
    r4.setBounds(300, 220, 300, 20);
    add(r4);

    ButtonGroup AccGroup = new ButtonGroup(); /*This is to make 
                                         sure only one button gets selected*/ 
        AccGroup.add(r1);
        AccGroup.add(r2);
        AccGroup.add(r3);
        AccGroup.add(r4);

  


    
    
    
    setSize(850,820);
    setLocation(350,0);
    setVisible(true);
    getContentPane().setBackground(Color.WHITE);
    
    }
    
    

    public static void main(String[] args) {
        new SignupThree();
    }
}
