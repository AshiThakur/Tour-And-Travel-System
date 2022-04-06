package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class BookPackage extends JFrame implements ActionListener {
    Choice c1;
    JLabel l11,l12,l13,l14,l15;
    JTextField t1;
    JButton b1,b2,b3;
    BookPackage(String username){

        setBounds(500,240,1100,500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("com/company/Icons/bookpackage.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l10=new JLabel(i3);
        l10.setBounds(550,50,500,300);
        add(l10);

        JLabel l1=new JLabel("BOOK PACKAGE");
        l1.setBounds(100,10,200,30);
        l1.setFont(new Font("Yu Mincho", Font.PLAIN,20));
        add(l1);

        JLabel l2=new JLabel("Username : ");
        l2.setBounds(40,70,150,30);
        l2.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(l2);

        l11=new JLabel();
        l11.setBounds(250,70,100,30);
        l11.setFont(new Font("Thaoma",Font.PLAIN,16));
        add(l11);

        JLabel l3=new JLabel("Select Package");
        l3.setBounds(40,110,150,30);
        l3.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(l3);

        c1=new Choice();
        c1.add("Gold Package");
        c1.add("Silver Package");
        c1.add("Bronze Package");
        c1.setBounds(250,110,200,30);
        add(c1);


        JLabel l4=new JLabel("Total Person : ");
        l4.setBounds(40,150,150,30);
        l4.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(l4);

        t1=new JTextField("1");
        t1.setBounds(250,150,200,25);
        add(t1);

        JLabel l5=new JLabel("ID :");
        l5.setBounds(40,190,100,30);
        l5.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(l5);

        l12=new JLabel();
        l12.setBounds(250,190,100,30);
        l12.setFont(new Font("Thaoma",Font.PLAIN,16));
        add(l12);


        JLabel l6=new JLabel("Number :");
        l6.setBounds(40,230,100,30);
        l6.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(l6);

        l13=new JLabel();
        l13.setBounds(250,230,100,30);
        l13.setFont(new Font("Thaoma",Font.PLAIN,16));
        add(l13);


        JLabel l7=new JLabel("Phone : ");
        l7.setBounds(40,270,100,30);
        l7.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(l7);

        l14=new JLabel();
        l14.setBounds(250,270,100,30);
        l14.setFont(new Font("Thaoma",Font.PLAIN,16));
        add(l14);

        JLabel l8=new JLabel("Total Price : ");
        l8.setBounds(40,310,200,30);
        l8.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(l8);

        l15=new JLabel();
        l15.setBounds(250,310,100,30);
        l15.setForeground(Color.RED);
        l15.setFont(new Font("Thaoma",Font.PLAIN,16));
        add(l15);


        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer where username = '"+username+"'");
            while (rs.next()){
                l11.setText(rs.getString("username"));
                l12.setText(rs.getString("id"));
                l13.setText(rs.getString("number"));
                l14.setText(rs.getString("phone"));
            }
        }catch (Exception e){

        }

        b1=new JButton("Check Price");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(60,360,120,25);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Book Package");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(200,360,120,25);
        b2.addActionListener(this);
        add(b2);

        b3=new JButton("Back");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(340,360,120,25);
        b3.addActionListener(this);
        add(b3);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String p=c1.getSelectedItem();
            int cost=0;
            if(p.equals("Gold Package")){
                cost+=12000;
            }
            else if(p.equals("Silver Package")){
                cost+=24000;
            }else if(p.equals("Bronze Package")){
                cost+=32000;
            }
           int persons=Integer.parseInt(t1.getText()); // TextField Return String Character so no calculation can be done in it
            cost*=persons;

            l15.setText("Rs"+cost);
        }
        else if(ae.getSource()==b2){
            try{
                Conn c=new Conn();
                c.s.executeUpdate("insert into bookpackage values('" +l11.getText()+ "', '" +c1.getSelectedItem()+ "', '" +t1.getText()+ "', '" +l12.getText()+ "' , '" +l13.getText()+ "','" +l14.getText()+ "','" +l15.getText()+ "')");
                JOptionPane.showMessageDialog(null,"Package Booked Successfully");
                this.setVisible(false);
            }catch (Exception e){
            }

        }else if(ae.getSource()==b3){
            this.setVisible(false);
        }
    }

    public static void main(String[] args){
        new BookPackage("").setVisible(true);
    }
}
