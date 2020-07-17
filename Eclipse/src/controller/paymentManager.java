package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import database.mySqlDatabase;
import model.Payment;

public class paymentManager {

	public int insertPayment(Payment payment) throws ClassNotFoundException, SQLException
	{
		Connection conn = (Connection) mySqlDatabase.doConnection();
		String query = "INSERT INTO payment(CreditCard_no, Expired_date) VALUES (?,?)";
		PreparedStatement preparedStatement = conn.prepareStatement(query);
		
		preparedStatement.setString(1,  payment.getCreditCardNo());
		preparedStatement.setString(2,  payment.getExpiredDate());
		
		int success = preparedStatement.executeUpdate();
		{
			preparedStatement.close();
			conn.close();
			
			return success;
		}
	}	
}
