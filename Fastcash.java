import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Fastcash extends JFrame implements ActionListener{

    JButton oneH,fiveH,oneT,twoT,fiveT,tenT,back;
    String passwordString;

    Fastcash(String passwordString){
        this.passwordString = passwordString;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,820);
        add(image);

        JLabel text = new JLabel("Please select Withdrawal Amount");
        text.setBounds(220, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD,16));
        image.add(text);

        oneH = new JButton("Rs 100");
        oneH.setBounds(170,410,150,30);
        oneH.addActionListener(this);
        image.add(oneH);

        fiveH = new JButton("Rs 500");
        fiveH.setBounds(360,410,150,30);
        fiveH.addActionListener(this);
        image.add(fiveH);

        oneT = new JButton("Rs 1000");
        oneT.setBounds(170,446,150,30);
        oneT.addActionListener(this);
        image.add(oneT);

        twoT = new JButton("Rs 2000");
        twoT.setBounds(360,446,150,30);
        twoT.addActionListener(this);
        image.add(twoT);

        fiveT = new JButton("Rs 5000");
        fiveT.setBounds(170,482,150,30);
        fiveT.addActionListener(this);
        image.add(fiveT);

        tenT = new JButton("Rs 10000");
        tenT.setBounds(360,482,150,30);
        tenT.addActionListener(this);
        image.add( tenT);

        back = new JButton("Back");
        back .setBounds(410,520,100,30);
        back .addActionListener(this);
        image.add(back );


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true); //to make full window image
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            System.exit(0);
        }else if(ae.getSource() == deposit){ 
            setVisible(false);
            new Deposit(passwordString).setVisible(true);
        }else if(ae.getSource() == withdraw){
            setVisible(false);
            new Withdrawal(passwordString).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Fastcash("");
    }
}
