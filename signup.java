import java.awt.Color;
import java.awt.Font;
import java.util.*;
import javax.swing.*;

public class signup extends JFrame {

    signup(){

        setLayout(null);

        Random rand = new Random();
        long random = Math.abs((rand.nextLong() % 9000L)+ 1000L);
        JLabel formno = new JLabel("APPLICATION FORM NO. "+ random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);

        JLabel peronalDetails = new JLabel("Page 1: Personal Details ");
        peronalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        peronalDetails.setBounds(290, 80, 280, 30);
        add(peronalDetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 22));
        name.setBounds(100, 140, 100, 30);
        add(name);

        JTextField nameText = new JTextField();
        nameText.setFont(new Font("Raleway", Font.BOLD, 14));
        nameText.setBounds(300, 140,400 , 30);
        add(nameText);


        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 22));
        fname.setBounds(100, 190, 170, 30);
        add(fname);

        JTextField fnameText = new JTextField();
        fnameText.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameText.setBounds(300, 190,400 , 30);
        add(fnameText);

        JLabel dob = new JLabel("Date Of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 22));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        JTextField dobText = new JTextField();
        dobText.setFont(new Font("Raleway", Font.BOLD, 14));
        dobText.setBounds(300, 240,400 , 30);
        add(dobText);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 22));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        JTextField genderText = new JTextField();
        genderText.setFont(new Font("Raleway", Font.BOLD, 14));
        genderText.setBounds(300, 290,400 , 30);
        add(genderText);

        JLabel email = new JLabel("Email:");
        email.setFont(new Font("Raleway", Font.BOLD, 22));
        email.setBounds(100, 340, 200, 30);
        add(email);

        JTextField emailText = new JTextField();
        emailText.setFont(new Font("Raleway", Font.BOLD, 14));
        emailText.setBounds(300, 340,400 , 30);
        add(emailText);

        JLabel maritalStat = new JLabel("Marital Status:");
        maritalStat.setFont(new Font("Raleway", Font.BOLD, 22));
        maritalStat.setBounds(100, 390, 200, 30);
        add(maritalStat);

        JTextField msText = new JTextField();
        msText.setFont(new Font("Raleway", Font.BOLD, 14));
        msText.setBounds(300, 390,400 , 30);
        add(msText);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 22));
        address.setBounds(100, 440, 200, 30);
        add(address);

        JTextField addrText = new JTextField();
        addrText.setFont(new Font("Raleway", Font.BOLD, 14));
        addrText.setBounds(300, 440,400 , 30);
        add(addrText);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 22));
        city.setBounds(100, 490, 200, 30);
        add(city);

        JTextField cityText = new JTextField();
        cityText.setFont(new Font("Raleway", Font.BOLD, 14));
        cityText.setBounds(300, 490,400 , 30);
        add(cityText);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 22));
        state.setBounds(100, 540, 200, 30);
        add(state);

        JTextField stateText = new JTextField();
        stateText.setFont(new Font("Raleway", Font.BOLD, 14));
        stateText.setBounds(300, 540,400 , 30);
        add(stateText);

        JLabel pincode = new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 22));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);

        JTextField pinText = new JTextField();
        pinText.setFont(new Font("Raleway", Font.BOLD, 14));
        pinText.setBounds(300, 590,400 , 30);
        add(pinText);



        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    public static void main(String[] args) {
        new signup();
    }
}
