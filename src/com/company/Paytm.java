package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Paytm extends JFrame implements ActionListener {
    Paytm(){
        JEditorPane j=new JEditorPane();
        j.setEditable(false);

        try{
            j.setPage("https://paytm.com/credit-card-bill-payment");
        }catch (Exception e){
            j.setContentType("text/html");
            j.setText("<html>Could not load, Error 404</html>");
        }
        JScrollPane js=new JScrollPane(j);
        getContentPane().add(js);

        JButton b1=new JButton("Back");
        b1.setBounds(610,20,80,40);
        b1.addActionListener(this);
        j.add(b1);

        setBounds(670,240,800,600);
    }

    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);

        new Payment().setVisible(true);
    }

    public static void main(String[] args){
        new Paytm().setVisible(true);
    }
}
