package DAO;

import java.sql.*;
import java.util.ArrayList;

public class LoginDao {
	private static Connection c=SingleConnection.getInstance();
	private static Object stmt;
	 private static ResultSet rst;
	public static ArrayList<String> tabLogin () throws SQLException{ 
		ArrayList<String>e=new ArrayList<>();
		 stmt=c.createStatement();
		 rst= ((Statement) stmt).executeQuery("SELECT login  FROM ecole.user");
	
		 while(rst.next()) {
	        String login = rst.getString("login");
	        e.add(login);
	}
		 return e;
	}
	public static ArrayList<String> tabType () throws SQLException{ 
		ArrayList<String>e=new ArrayList<>();
		 stmt=c.createStatement();
		 rst= ((Statement) stmt).executeQuery("SELECT type FROM ecole.user");
	
		 while(rst.next()) {
            String type=rst.getString("type");
            e.add(type);
	}
		 return e;
	}
	public static ArrayList<String> tabPwd () throws SQLException{ 
		ArrayList<String>e=new ArrayList<>();
		 stmt=c.createStatement();
		 rst= ((Statement) stmt).executeQuery("SELECT pwd FROM ecole.user");
	
		 while(rst.next()) {
           String pwd = rst.getString("pwd");
              e.add(pwd);
	}
		 return e;
	}

}
