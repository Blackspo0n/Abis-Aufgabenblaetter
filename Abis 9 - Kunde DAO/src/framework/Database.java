package framework;

import java.sql.DriverManager;

import java.sql.Connection;

public class Database {
	static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/xdb", "root", "");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
	}
}
