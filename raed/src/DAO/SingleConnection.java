package DAO;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class SingleConnection {
	Properties p;

	private static String user;
	private static String password;
	private static String url;
	private static Connection c;
	private SingleConnection() {
		 p=new Properties();
		try {
			p.load(new FileInputStream("connecteur/conf.properties"));
			url=p.getProperty("jdbc.url");
			user=p.getProperty("jdbc.user");
			password=p.getProperty("jdbc.password");
			c=DriverManager.getConnection(url, user, password);
		}catch (Exception e) {
		e.printStackTrace();
		}
	}
	public static Connection getInstance() {
		if(c==null) {
			new SingleConnection();
		}
	return c;
	}

}
