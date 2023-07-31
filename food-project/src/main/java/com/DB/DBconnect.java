package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnect {
private static Connection conn;
public static Connection getConn() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/food_order","root","2580");
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return conn;
	
}
public static void main(String[] args) {
	System.out.println(DBconnect.getConn());
}
}
