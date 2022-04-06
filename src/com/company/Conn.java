package com.company;

// 5 steps in JDBC(Java Database Connectivity is an API which connects the java code with sql)
// 1 :- Register the Driver Class
//2:- Create connection
//3:- Create Statement
//4 :-Execute queries
//5: -Close connection

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    public Conn(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///tms","root","Ambul@nce108");
            s = c.createStatement();
        }catch(Exception e){

        }
    }

}
