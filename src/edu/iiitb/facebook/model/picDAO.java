package edu.iiitb.facebook.model;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.iiitb.facebook.util.DB;

public class picDAO {
	
	public static int getCoverPic(int profileId){
		int coverPicId=0;
		ResultSet resultSet = null;
		
		String query = "select coverPicId from Profile where profileId ="+profileId+";";
		System.out.println(query);
		Connection connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		
			try {
				if (resultSet.next()) {
					 coverPicId=resultSet.getInt("coverPicId");
						//binaryStream=FacebookDAO.getPhoto(coverPicId);
						
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		DB.close(resultSet);
		DB.close(connection);
		return coverPicId;
	}



}
