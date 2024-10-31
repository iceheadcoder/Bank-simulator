import java.awt.Color;
import java.awt.Font;
import java.util.*;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import java.awt.event.*;

import com.sun.nio.sctp.PeerAddressChangeNotification;


public class Signup extends JFrame implements ActionListener{

    long random;
    JTextField nameText,fnameText,emailText,addrText,cityText,stateText,pinText;
    JRadioButton male,female,other,married,unmarried;
    JDateChooser dateChooser;
    JButton next;

    Signup(){

        setLayout(null);

        Random rand = new Random();
        random = Math.abs((rand.nextLong() % 9000L)+ 1000L);
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

        nameText = new JTextField();
        nameText.setFont(new Font("Raleway", Font.BOLD, 14));
        nameText.setBounds(300, 140,400 , 30);
        add(nameText);


        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 22));
        fname.setBounds(100, 190, 170, 30);
        add(fname);

        fnameText = new JTextField();
        fnameText.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameText.setBounds(300, 190,400 , 30);
        add(fnameText);

        JLabel dob = new JLabel("Date Of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 22));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(Color.BLACK);
        add(dateChooser); 

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 22));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(320, 290, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);
 
        female = new JRadioButton("Female");
        female.setBounds(410,290,90,30);
        female.setBackground(Color.WHITE);
        add(female);

        other = new JRadioButton("Other");
        other.setBounds(510,290,90,30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup genderGroup = new ButtonGroup(); /*This is to make 
                                         sure only one button gets selected*/ 
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);

        JLabel email = new JLabel("Email:");
        email.setFont(new Font("Raleway", Font.BOLD, 22));
        email.setBounds(100, 340, 200, 30);
        add(email);

        emailText = new JTextField();
        emailText.setFont(new Font("Raleway", Font.BOLD, 14));
        emailText.setBounds(300, 340,400 , 30);
        add(emailText);

        JLabel maritalStat = new JLabel("Marital Status:");
        maritalStat.setFont(new Font("Raleway", Font.BOLD, 22));
        maritalStat.setBounds(100, 390, 200, 30);
        add(maritalStat);

        married = new JRadioButton("Married");
        married.setBounds(320, 390, 90, 30);
        married.setBackground(Color.WHITE);
        add(married);
 
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(410,390,90,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        ButtonGroup maritalGroup = new ButtonGroup(); /*This is to make 
                                         sure only one button gets selected*/ 
        maritalGroup.add(married);
        maritalGroup.add(unmarried);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 22));
        address.setBounds(100, 440, 200, 30);
        add(address);

        addrText = new JTextField();
        addrText.setFont(new Font("Raleway", Font.BOLD, 14));
        addrText.setBounds(300, 440,400 , 30);
        add(addrText);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 22));
        city.setBounds(100, 490, 200, 30);
        add(city);

        cityText = new JTextField();
        cityText.setFont(new Font("Raleway", Font.BOLD, 14));
        cityText.setBounds(300, 490,400 , 30);
        add(cityText);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 22));
        state.setBounds(100, 540, 200, 30);
        add(state);

        stateText = new JTextField();
        stateText.setFont(new Font("Raleway", Font.BOLD, 14));
        stateText.setBounds(300, 540,400 , 30);
        add(stateText);

        JLabel pincode = new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 22));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);

        pinText = new JTextField();
        pinText.setFont(new Font("Raleway", Font.BOLD, 14));
        pinText.setBounds(300, 590,400 , 30);
        add(pinText);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String formno = "" + random;  //adding "" converts any datatype to string
        String name = nameText.getText();
        String fname = fnameText.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        
        String gender = null;
        if(male.isSelected()){
            gender="Male";
        }else if(female.isSelected()){
            gender="Female";
        }else if(other.isSelected()){
            gender="Other";
        }
       
        String email = emailText.getText();
        
        String maritalStat = null;
        if(married.isSelected()){
            maritalStat="Married";
        }else if(unmarried.isSelected()){
            maritalStat="Unmarried";
        }
        
        String address = addrText.getText();
        String city = cityText.getText();
        String state = stateText.getText();
        String pincode = pinText.getText();

        try {
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required!");
            }else if(fname.equals("")){
                JOptionPane.showMessageDialog(null,"Father's Name is Required!");
            }else if(dob.equals("")){
                JOptionPane.showMessageDialog(null,"DOB is Required!");
            }else if(gender.equals("")){
                JOptionPane.showMessageDialog(null,"Gender is Required!");
            }else if(email.equals("")){
                JOptionPane.showMessageDialog(null,"Email is Required!");
            }else if(maritalStat.equals("")){
                JOptionPane.showMessageDialog(null,"Marital Status is Required!");
            }else if(address.equals("")){
                JOptionPane.showMessageDialog(null,"Address is Required!");
            }else if(city.equals("")){
                JOptionPane.showMessageDialog(null,"City is Required!");
            }else if(state.equals("")){
                JOptionPane.showMessageDialog(null,"State is Required!");
            }else if(pincode.equals("")){
                JOptionPane.showMessageDialog(null,"Pin Code is Required!");
            }else{
                DBconnection c = new DBconnection();
                String query = "insert into signup values ('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+maritalStat+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
                c.s.executeUpdate(query);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new Signup();
    }
}
