package com.login.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class LoginEntity {
	private String username,password;
	public LoginEntity(String username,String password) throws Exception {
		this.username = username;
		this.password = password;
		try {
			createTable();
			insertValues();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	private void insertValues() throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement insert = con.prepareStatement("INSERT INTO dbuser(username,password)VALUES('"+username+"','"+password+"')");
			insert.executeUpdate();
			System.out.println("Inserted");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	private void createTable() throws Exception{
		try {
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS dbuser(id int NOT NULL AUTO_INCREMENT, username varchar(255),password varchar(255),PRIMARY KEY(id))");
			create.executeUpdate();
			System.out.println("Table created");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public static Connection getConnection() throws Exception{
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://mydatabase.cmlal0aall18.us-east-2.rds.amazonaws.com/dbuser";
			String user = "admin";
			String password = "password";
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,user,password);
			System.out.println("Connected");
			return con; 
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
}
