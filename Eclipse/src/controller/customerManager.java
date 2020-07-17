package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import database.mySqlDatabase;
import model.Customer;

public class customerManager {

	public int insertCustomer(Customer cust) throws ClassNotFoundException, SQLException
	{
		Connection conn = (Connection) mySqlDatabase.doConnection();
		String query = "INSERT INTO customer(Name, Address, Phone, Email) VALUES (?,?,?,?)";
		PreparedStatement preparedStatement = conn.prepareStatement(query);
		
		preparedStatement.setString(1,  cust.getName());
		preparedStatement.setString(2,  cust.getAddress());
		preparedStatement.setString(3, cust.getPhone());
		preparedStatement.setString(4, cust.getEmail());
		
		int success = preparedStatement.executeUpdate();
		{
			preparedStatement.close();
			conn.close();
			
			return success;
		}
	}
	
	public ArrayList<Customer> selectAllCustomer() throws ClassNotFoundException, SQLException
	{
		ArrayList<Customer> alCust = new ArrayList<Customer>();
		
		Connection conn = (Connection) mySqlDatabase.doConnection();
		String query = "SELECT * FROM customer";
		
		PreparedStatement preparedStatement = conn.prepareStatement(query);
		
		ResultSet resultSet =  preparedStatement.executeQuery();
		
		while(resultSet.next())
		{
			int id = resultSet.getInt("ID");
			String name = resultSet.getString("Name");
			String address = resultSet.getString("Address");
			String phone = resultSet.getString("Phone");
			String email = resultSet.getString("Email");
			
			Customer customer = new Customer();
			customer.setId(id);
			customer.setName(name);
			customer.setAddress(address);
			customer.setPhone(phone);
			customer.setEmail(email);
			
			alCust.add(customer);
		}
		
		conn.close();
		preparedStatement.close();
		resultSet.close();
		
		return alCust;
	}
	
	public int deleteCustomer(Customer cust) throws ClassNotFoundException, SQLException
	{
		int success = 0;
		
		Connection conn = (Connection) mySqlDatabase.doConnection();
		String query = "DELETE FROM customer WHERE ID = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(query);
		preparedStatement.setInt(1, cust.getId());
		
		success =  preparedStatement.executeUpdate();
		
		preparedStatement.close();
		conn.close();
		
		return success;
	}
	
}
