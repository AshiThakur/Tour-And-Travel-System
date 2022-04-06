package com.company;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

//Created UI for the user to login

public class Login extends JFrame implements ActionListener {
    JButton b1,b2,b3;
    JTextField t1;
    JPasswordField t2;
    Login(){

        setLayout(null);//Boarder Layout by default,FlowLayout,GridLayout
        getContentPane().setBackground(Color.WHITE);
        setBounds(500,250,900,400);

        JPanel p1=new JPanel(); //Same as div in HTML
        p1.setBackground(new Color(131,193,233));
        p1.setBounds(0,0,400,400);
        p1.setLayout(null);
        add(p1);

            //To Add the Image on left side of the panel
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("com/company/Icons/login.png"));

        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT); //To Scale the Image
        ImageIcon i3=new ImageIcon(i2);

        JLabel l1=new JLabel(i3);
        l1.setBounds(100,100,200,200);
        p1.add(l1);

        //FOR RIGHT SIDE OF THE PANEL
        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBounds(400,20,500,300);
        add(p2);

        JLabel l2=new JLabel("Username");
        l2.setBounds(60,10,100,25);
        l2.setFont(new Font("SAN_SERIF" ,Font.PLAIN,20));
        p2.add(l2);

        t1=new JTextField();
        t1.setBounds(60,60,300,30);
        t1.setBorder(BorderFactory.createEmptyBorder());
        p2.add(t1);

        JLabel l3=new JLabel("Password");
        l3.setBounds(60,110,100,25);
        l3.setFont(new Font("SAN_SERIF" ,Font.PLAIN,20));
        p2.add(l3);

        t2=new JPasswordField();
        t2.setBounds(60,150,300,30);
        t2.setBorder(BorderFactory.createEmptyBorder());
        p2.add(t2);

        b1=new JButton("Login");
        b1.setBounds(60,200,130,30);
        b1.setBackground(new Color(133,193,233));
        b1.setForeground(Color.WHITE); //To Change txt color
        b1.setBorder(BorderFactory.createEmptyBorder());
        b1.addActionListener(this);
        p2.add(b1);

        b2=new JButton("SignUp");
        b2.setBounds(230,200,130,30);
        b2.setForeground(Color.WHITE); //To Change txt color
        b2.setBackground(new Color(133,193,233));
        b2.setBorder(new LineBorder(new Color(133,193,233)));
        b2.addActionListener(this);
        p2.add(b2);

        b3= new JButton("Forget Password");
        b3.setBounds(130,250,160,30);
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(133,193,233));
        b3.setBorder(new LineBorder(new Color(133,193,233)));
        b3.addActionListener(this);
        p2.add(b3);

        JLabel l4=new JLabel("Trouble in Login...");
        l4.setForeground(Color.red);
        l4.setBounds(300,255,100,20);
        p2.add(l4);


        setVisible(true);

    }

    //overriding method for ActionListener

    public void actionPerformed(ActionEvent ae){
        Conn c=new Conn();
        if(ae.getSource()==b1){
            try{
                String username=t1.getText();
                String password=t2.getText();
                String sql="select * from account where username= '"+username+"' AND password ='"+password+"'";

              ResultSet rs=c.s.executeQuery(sql);
              if(rs.next()){
                  this.setVisible(false);
                  new Loading(username).setVisible(true);
              }else{
                  JOptionPane.showMessageDialog(null,"Invalid Login");
              }
            }catch(Exception e){

            }

        }else if(ae.getSource()==b2){
            this.setVisible(false);
            new Signup().setVisible(true);
        }else{
            this.setVisible(false);
            new ForgotPassword().setVisible(true);

        }
    }

    public static void main(String[] args){

        new Login().setVisible(true);
    }

}
