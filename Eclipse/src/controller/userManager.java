package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.mySqlDatabase;
import model.userBean;

public class userManager {
	
	public boolean loginUser(userBean user) throws ClassNotFoundException, SQLException
	{
		boolean success = false; 
		
		Connection conn = mySqlDatabase.doConnection();
		String query = "SELECT * FROM account_table WHERE username = ? AND password = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(query);
		
		preparedStatement.setString(1, user.getUsername());
		preparedStatement.setString(2, user.getPassword());
				
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while (resultSet.next())
		{
			success = true; 
		}
		
		preparedStatement.close();
		conn.close();
		
		return success;
	}

	public int insertUser(userBean user) throws ClassNotFoundException, SQLException
	{
		Connection conn = mySqlDatabase.doConnection();
		String query = "INSERT INTO account_table(username, password) VALUES (?,?)";
		PreparedStatement preparedStatement = conn.prepareStatement(query);
		
		preparedStatement.setString(1,  user.getUsername());
		preparedStatement.setString(2,  user.getPassword());
		
		int success = preparedStatement.executeUpdate();
		{
			preparedStatement.close();
			conn.close();
			
			return success;
		}
	}
	
	public ArrayList<userBean>  selectUser(userBean user) throws ClassNotFoundException, SQLException
	{
		ArrayList<userBean> alUser = new ArrayList<userBean>();
		
		Connection conn = mySqlDatabase.doConnection();
		String query = "SELECT * FROM account_table WHERE  username = ? AND password = ? ";
		PreparedStatement preparedStatement = conn.prepareStatement(query);
		
		preparedStatement.setString(1, user.getUsername());
		preparedStatement.setString(2, user.getPassword());
				
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while (resultSet.next())
		{
			String name = resultSet.getString("username");
			String password = resultSet.getString("password");
			
			userBean userbean = new userBean();
			userbean.setUsername(name);
			userbean.setPassword(password);
			
			alUser.add(userbean);
		}
		
		preparedStatement.close();
		conn.close();
		
		return alUser;
	}
}
