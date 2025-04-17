package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtility {

	private DBUtility() {
		super();
	}
	private static Connection con=null;
	public static Connection getDBConnection() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","root");
	}
	catch(Exception e){
		System.out.println("DButility "+e);
	}
		return con;
	}
}







