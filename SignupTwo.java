import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;



public class SignupTwo extends JFrame implements ActionListener{

    
    JTextField adhrText,eduText,panText;
    JRadioButton exist,nonexist;
    JComboBox religionBox,occBox,incomeBox;
    JButton next;
    String formno;

    SignupTwo(String formno){

        this.formno = formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details ");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 22));
        religion.setBounds(100, 140, 100, 30);
        add(religion);

        String valR[] = {"Hindu","Muslim","Christian","Sikh","Other"};
        religionBox = new JComboBox(valR);
        religionBox.setBounds(300, 140, 400, 30);
        religionBox.setBackground(Color.WHITE);
        add(religionBox);

        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 22));
        income.setBounds(100, 190, 170, 30);
        add(income);

        String valI[] = {"Null","< 1,50,000 ","< 2,50,000","< 5,00,000",">= 10,00,000"};
        incomeBox = new JComboBox(valI);
        incomeBox.setBounds(300, 190, 400, 30);
        incomeBox.setBackground(Color.WHITE);
        add(incomeBox);

        JLabel edqual1= new JLabel("Educational");
        edqual1.setFont(new Font("Raleway", Font.BOLD, 22));
        edqual1.setBounds(100, 240, 200, 30);
        add(edqual1);

        JLabel edqual2= new JLabel("Qualification:");
        edqual2.setFont(new Font("Raleway", Font.BOLD, 22));
        edqual2.setBounds(100, 265, 200, 30);
        add(edqual2);

        eduText = new JTextField();
        eduText.setFont(new Font("Raleway", Font.BOLD, 14));
        eduText.setBounds(300, 260,400 , 30);
        add(eduText);

        JLabel occ = new JLabel("Occupation:");
        occ.setFont(new Font("Raleway", Font.BOLD, 22));
        occ.setBounds(100, 340, 200, 30);
        add(occ);

        String occVal[] = {"Salaried","Self-Employed","Businessess","Student","Retired"};
        occBox = new JComboBox(occVal);
        occBox.setBounds(300, 340, 400, 30);
        occBox.setBackground(Color.WHITE);
        add(occBox);
       

        JLabel panNum = new JLabel("PAN Number:");
        panNum.setFont(new Font("Raleway", Font.BOLD, 22));
        panNum.setBounds(100, 390, 200, 30);
        add(panNum);

        panText = new JTextField();
        panText.setFont(new Font("Raleway", Font.BOLD, 14));
        panText.setBounds(300, 390,400 , 30);
        add(panText);


        JLabel adhrNum = new JLabel("Aadhar Number:");
        adhrNum.setFont(new Font("Raleway", Font.BOLD, 22));
        adhrNum.setBounds(100, 440, 200, 30);
        add(adhrNum);

        adhrText = new JTextField();
        adhrText.setFont(new Font("Raleway", Font.BOLD, 14));
        adhrText.setBounds(300, 440,400 , 30);
        add(adhrText);

        JLabel exAcc = new JLabel("Existing Account?");
        exAcc.setFont(new Font("Raleway", Font.BOLD, 22));
        exAcc.setBounds(100, 490, 200, 30);
        add(exAcc);

        exist = new JRadioButton("YES");
        exist.setBounds(320, 490, 90, 30);
        exist.setBackground(Color.WHITE);
        add(exist);
 
        nonexist = new JRadioButton("NO");
        nonexist.setBounds(410,490,90,30);
        nonexist.setBackground(Color.WHITE);
        add(nonexist);

        ButtonGroup existGroup = new ButtonGroup(); /*This is to make 
                                         sure only one button gets selected*/ 
        existGroup.add(exist);
        existGroup.add(nonexist);

       
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
        String sreligion = (String) religionBox.getSelectedItem();
        String sincome = (String) incomeBox.getSelectedItem();
        String sedu = eduText.getText();
        String socc = (String) occBox.getSelectedItem();
        String sPan = panText.getText();
        String sAdhr = adhrText.getText();
    
        String sAcc = null;
        if(exist.isSelected()){
            sAcc="exists";
        }else if(nonexist.isSelected()){
            sAcc="doesn't exist";
        }
       

        try {
            if(sedu.equals("")){
                JOptionPane.showMessageDialog(null,"Educational Qualification is Required!");
            }else if(sPan.equals("")){
                JOptionPane.showMessageDialog(null,"PAN Number is Required!");
            }else if(sAdhr.equals("")){
                JOptionPane.showMessageDialog(null,"Aadhar Number Status is Required!");
            }else if(sAcc.equals("")){
                JOptionPane.showMessageDialog(null,"Exists field Required!");
            }else{
                DBconnection c = new DBconnection();
                String query = "insert into signuptwo values ('"+formno+"','"+sreligion+"','"+sincome+"','"+sedu+"','"+socc+"','"+sPan+"','"+sAdhr+"','"+sAcc+"')";
                c.s.executeUpdate(query);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new SignupTwo("");
    }
}
