package edu.iiitb.facebook.model;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import edu.iiitb.facebook.action.BirthdayAction;
import edu.iiitb.facebook.util.DB;

public class BirthdayDao {
	
	
	public static ArrayList<BirthdayAction> getBirthdayNotification(int id)
	{ 
		 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		   //get current date time with Date()
		   Date date = new Date();
		   System.out.println(dateFormat.format(date));
		
		String dt=(dateFormat.format(date)).toString();
		   
		   
		ArrayList<BirthdayAction> birthdayPost=new ArrayList<BirthdayAction>();
		
		BirthdayAction ba;
		
		ResultSet resultSet= null;
		String query;
		query= " select profilePicAlbumId,firstName,lastName from Profile where profileId IN(select distinct profileId from Profile,Friendship where birthDate = '" + dt +"' and profileId IN (select Friendship.userId2 from Friendship where Friendship.userId1=1 and Friendship.areFriends=1));";
		System.out.println(query);
		Connection connection;
		connection= DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		
				
		try {
			while (resultSet.next()) {
				ba=new BirthdayAction();
				ba.setProfilePicAlbumId((resultSet.getInt("profilePicAlbumId")));
				ba.setFirstName(resultSet.getString("firstName"));
				ba.setLastName(resultSet.getString("lastName"));

				birthdayPost.add(ba);
				System.out.println("Iterating birthday list");
			}
			
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		
		
		return birthdayPost;
		
	}
	

}
