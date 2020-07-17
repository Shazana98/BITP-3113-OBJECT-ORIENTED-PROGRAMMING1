package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import database.mySqlDatabase;
import model.Room;

public class roomManager {
	
	public int insertRoom(Room room) throws ClassNotFoundException, SQLException
	{
		Connection conn = (Connection) mySqlDatabase.doConnection();
		String query = "INSERT INTO room(Room_type, rate) VALUES (?,?)";
		PreparedStatement preparedStatement = conn.prepareStatement(query);
		
		preparedStatement.setString(1,  room.getRoomType());
		preparedStatement.setInt(2,  room.getRate());
		
		int success = preparedStatement.executeUpdate();
		{
			preparedStatement.close();
			conn.close();
			
			return success;
		}
	}	
}
