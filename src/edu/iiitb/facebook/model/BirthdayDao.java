package edu.iiitb.facebook.model;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;

import edu.iiitb.facebook.util.DB;

public class BirthdayDao {

	public static ArrayList<Birthday> getBirthdayNotification(int id,String dt) {
	
		String bd;

		int a;
		ArrayList<Birthday> birthdayPost = new ArrayList<Birthday>();

		Birthday ba;

		ResultSet resultSet = null;
		String query;
		query = " select profileId,profilePicAlbumId,firstName,lastName,birthDate,gender from Profile where profileId IN(select distinct profileId from Profile,Friendship where birthDate like '%"
				+ dt.substring(5, 10)
				+ "' and profileId IN (select Friendship.userId2 from Friendship where Friendship.userId1="+id+" and Friendship.areFriends='Y'));";
		System.out.println(query);
		Connection connection;
		connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);

		try {
			while (resultSet.next()) {
				ba = new Birthday();
				ba.setProfilePicAlbumId((resultSet.getInt("profilePicAlbumId")));
				ba.setFirstName(resultSet.getString("firstName"));
				ba.setLastName(resultSet.getString("lastName"));
				ba.setProfileId(resultSet.getInt("profileId"));
				ba.setGender(resultSet.getString("gender"));

				bd = resultSet.getString("birthDate");

				a = Integer.parseInt(dt.substring(0, 4))
						- Integer.parseInt(bd.substring(0, 4));

				if (Integer.parseInt(dt.substring(5, 7)) < Integer.parseInt(bd
						.substring(5, 7))
						|| (Integer.parseInt(dt.substring(5, 7)) == Integer
								.parseInt(dt.substring(5, 7)) && Integer
								.parseInt(dt.substring(8, 10)) < Integer
								.parseInt(bd.substring(8, 10)))) {
					--a;
				}

				System.out.println(dt.substring(0, 4));
				System.out.println(dt.substring(5, 7));
				System.out.println(dt.substring(8, 10));

				ba.setAge(a);

				int bid = getBirthdayId(id, resultSet.getInt("profileId"));

				if (bid != 0)
					ba.setFlagB(true);
				else
					ba.setFlagB(false);

				birthdayPost.add(ba);
				System.out.println("Iterating birthday list");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);

		return birthdayPost;

	}

	public static void postBirthdayWish(int session, int profileId, String wish) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// get current date time with Date()
		Date date = new Date();

		String dt = (dateFormat.format(date)).toString();

		String query;

		query = "INSERT INTO `Birthday` (`time`, `message`, `fromId`, `toId`) VALUES ('"
				+ dt + "', '" + wish + "'," + session + "," + profileId + ");";
		System.out.println(query);

		Connection connection;
		connection = DB.getConnection();
		Statement stmt;
		try {
			stmt = connection.createStatement();

			stmt.executeUpdate(query);

			int bid = getBirthdayId(session, profileId);

			query = "INSERT INTO `Post` (`owner`, `type`, `time`, `birthdayId`) VALUES ("
					+ session + ", 'text', '" + dt + "', " + bid + ");";
			System.out.println(query);
			stmt.executeUpdate(query);

		} catch (SQLException e) {

			e.printStackTrace();
		}
		DB.close(connection);

	}

	public static int getBirthdayId(int from, int to) {

		ResultSet resultSet = null;
		String query;
		int bId = 0;
		query = " select birthdayId from Birthday where fromId=" + from
				+ " and toId=" + to + ";";
		System.out.println(query);
		Connection connection;
		connection = DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			if (resultSet.next())
				bId = resultSet.getInt("birthdayId");
			System.out.println(bId);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);

		return bId;
	}

}