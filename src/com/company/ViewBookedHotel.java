package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

    public class ViewBookedHotel extends JFrame implements ActionListener {
        JButton b1,b2;
        ViewBookedHotel(String username){
            setBounds(610,240,1000,600);
            getContentPane().setBackground(Color.WHITE);
            setLayout(null);

            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("com/company/Icons/bookedDetails.jpg"));
            Image i2=i1.getImage().getScaledInstance(500,400,Image.SCALE_DEFAULT);
            ImageIcon i3=new ImageIcon(i2);
            JLabel l10=new JLabel(i3);
            l10.setBounds(450,20,500,400);
            add(l10);

            JLabel heading=new JLabel("VIEW BOOKED HOTEL DETAILS");
            heading.setBounds(60,0,200,30);
            heading.setFont(new Font("Tahoma",Font.PLAIN,20));
            add(heading);

            JLabel l1=new JLabel("Username : ");
            l1.setBounds(30,50,100,30);
            add(l1);

            JLabel l11=new JLabel();
            l11.setBounds(250,50,200,30);
            add(l11);


            JLabel l2=new JLabel("Hotel Name : ");
            l2.setBounds(30,90,100,30);
            add(l2);

            JLabel l12=new JLabel();
            l12.setBounds(250,90,200,30);
            add(l12);

            JLabel l3=new JLabel("Total Person :");
            l3.setBounds(30,130,100,30);
            add(l3);

            JLabel l13=new JLabel();
            l13.setBounds(250,130,200,30);
            add(l13);


            JLabel l4=new JLabel("Total Days : ");
            l4.setBounds(30,170,100,30);
            add(l4);

            JLabel l14=new JLabel();
            l14.setBounds(250,170,200,30);
            add(l14);

            JLabel l5=new JLabel("Ac Included : ");
            l5.setBounds(30,210,100,30);
            add(l5);

            JLabel l15=new JLabel();
            l15.setBounds(250,210,200,30);
            add(l15);

            JLabel l6=new JLabel("Food Included : ");
            l6.setBounds(30,250,100,30);
            add(l6);

            JLabel l16=new JLabel();
            l16.setBounds(250,250,200,30);
            add(l16);

            JLabel l7=new JLabel("ID : ");
            l7.setBounds(30,290,100,30);
            add(l7);

            JLabel l17=new JLabel();
            l17.setBounds(250,290,200,30);
            add(l17);

            JLabel l8=new JLabel("Number: ");
            l8.setBounds(30,330,100,30);
            add(l8);

            JLabel l18=new JLabel();
            l18.setBounds(250,330,200,30);
            add(l18);

            JLabel l9=new JLabel("Phone: ");
            l9.setBounds(30,370,100,30);
            add(l9);

            JLabel l19=new JLabel();
            l19.setBounds(250,370,200,30);
            add(l19);

            JLabel l30=new JLabel("ID : ");
            l30.setBounds(30,410,100,30);
            add(l30);

            JLabel l20=new JLabel();
            l20.setBounds(250,410,200,30);
            add(l20);

            try{
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery("select * from bookHotel where username='"+username+"'");
                while(rs.next()){
                    l11.setText(rs.getString("username"));
                    l12.setText(rs.getString("package"));
                    l13.setText(rs.getString(3));
                    l14.setText(rs.getString(4));
                    l15.setText(rs.getString(5));
                    l16.setText(rs.getString(6));
                    l17.setText(rs.getString(7));
                    l18.setText(rs.getString(8));
                    l19.setText(rs.getString(9));
                    l20.setText(rs.getString(10));

                }

            }catch (Exception e){

            }

            b1=new JButton("Back");
            b1.setBounds(150,460,150,25);
            b1.setBackground(Color.BLACK);
            b1.setForeground(Color.WHITE);
            b1.addActionListener(this);
            add(b1);
        }
        public void actionPerformed(ActionEvent ae){
            this.setVisible(false);

        }


        public void main(String[] args){
            new ViewBookedHotel("").setVisible(true);
        }
    }


