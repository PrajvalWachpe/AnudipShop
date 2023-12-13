package com.db.util;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtility {

public static Connection makeConnection() {
		
	Connection con = null;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Anudip_6201?user=root&password=Palakkal*078");
    } catch (Exception e) {
        e.printStackTrace();
    }
    return con;
}
	
}
