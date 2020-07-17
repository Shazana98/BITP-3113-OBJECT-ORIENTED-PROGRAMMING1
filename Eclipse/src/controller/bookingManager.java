package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.mySqlDatabase;
import model.Booking;

public class bookingManager {

	public int insertBooking(Booking booking) throws ClassNotFoundException, SQLException
	{
		Connection conn = mySqlDatabase.doConnection();
		String query = "INSERT INTO booking(CheckIn_Date, CheckOut_Date, Total_Room, Adults, Children) VALUES (?,?,?,?,?)";
		PreparedStatement preparedStatement = conn.prepareStatement(query);
		
		preparedStatement.setString(1,  booking.getCheckIn_Date());
		preparedStatement.setString(2,  booking.getCheckOut_Date());
		preparedStatement.setInt(3,  booking.getTotal_room());
		preparedStatement.setInt(4, booking.getAdults());
		preparedStatement.setInt(5, booking.getChildren());
		
		int success = preparedStatement.executeUpdate();
		{
			preparedStatement.close();
			conn.close();
			
			return success;
		}
	}
}
