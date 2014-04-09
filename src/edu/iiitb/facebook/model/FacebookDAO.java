package edu.iiitb.facebook.model;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.iiitb.facebook.util.DB;

public class FacebookDAO {

	public static ArrayList<Profile> getSearchResult(String searchText,int userId) {
		ArrayList<Profile> searchResult = new ArrayList<Profile>();
		PreparedStatement stmt = null;
		
		Connection con;
		if(searchText==null || searchText=="")
		{
			return null;
		}
		String[] inputTextList=searchText.split(" ");
		if(inputTextList.length>2)
		{
			return null;
		}
		else
		{
			String firstName=inputTextList[0];
			String lastName="";
			if(inputTextList.length==2)
				lastName=inputTextList[1];
			
		try {
			con = DB.getConnection();
			
			
		
			
			 String query = "select p.loginId loginId, p.profileId profileId, " +
					"p.firstName firstName, p.lastName lastName, profilePicId profilePicId from Profile p where" +
					" p.firstName like ? and p.lastName like ?";
			
			stmt = con.prepareStatement(query);

			stmt.setString(1, firstName+"%");
			stmt.setString(2, lastName+"%");
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Profile p=new Profile();
				p.setLoginId(rs.getInt("loginId"));
				p.setProfileId(rs.getInt("profileId"));
				if(p.getProfileId()!=userId)
				{
				p.setFirstName(rs.getString("firstName"));
				p.setLastName(rs.getString("lastName"));
				p.setProfilePicId(rs.getInt("profilePicId"));
				searchResult.add(p);
				}
			}
			
			ArrayList<Integer> friendsList =getFriendList(userId);
			ArrayList<Integer> friendsRequestSentList =getFriendRequestSentList(userId);
			ArrayList<Integer> friendsRequestRecievedList =getFriendsRequestRecievedList(userId);
			
			
			
			for(Profile p:searchResult)
			{
				if(friendsList.contains(p.getProfileId()))
				{
				  p.setIsFriend("Y");
				}
				else if(friendsRequestSentList.contains(p.getProfileId()))
				{
					p.setIsFriend("S");
				}
				else if(friendsRequestRecievedList.contains(p.getProfileId()))
				{
					p.setIsFriend("R");
				}
				else
					p.setIsFriend("N");
				
			}
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	 if(searchResult.size()==0)
		 return null;
	 else
	 {
		 
	 for(Profile p:searchResult)
		 System.out.println("Name "+p.getFirstName());
		 return searchResult;

	 }	
	}
	}
	
	private static ArrayList<Integer> getFriendsRequestRecievedList(int userId) {

		PreparedStatement stmt = null;
		// Get a Statement object
		Connection con;
		ArrayList<Integer> friendsRequestRecievedList =new ArrayList<Integer>();
		try {
			con = DB.getConnection();

			String query="SELECT  f.userId1 userId FROM facebook.Friendship f where f.userId2=? and f.areFriends='N'";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, userId);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				Integer temp=rs.getInt("userId");
				friendsRequestRecievedList.add(temp);
				
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return friendsRequestRecievedList;

	}

	private static ArrayList<Integer> getFriendRequestSentList(int userId) {

		PreparedStatement stmt = null;
		// Get a Statement object
		Connection con;
		ArrayList<Integer> friendsRequestSentList =new ArrayList<Integer>();
		try {
			con = DB.getConnection();

			String query="SELECT  f.userId2 userId FROM facebook.Friendship f where f.userId1=? and f.areFriends='N'";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, userId);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				Integer temp=rs.getInt("userId");
				friendsRequestSentList.add(temp);
				
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return friendsRequestSentList;

	}

	private static ArrayList<Integer> getFriendList(int userId) {

		PreparedStatement stmt = null;
		// Get a Statement object
		Connection con;
		ArrayList<Integer> friendsList = new ArrayList<Integer>();
		try {
			con = DB.getConnection();

			String query = "(SELECT  f.userId2 userId FROM facebook.Friendship f where f.userId1=? and f.areFriends='Y')"
					+ " UNION "
					+ "(SELECT  f.userId1 userId FROM facebook.Friendship f where f.userId2=? and f.areFriends='Y')";
			stmt = con.prepareStatement(query);

			stmt.setInt(1, userId);
			stmt.setInt(2, userId);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Integer temp = rs.getInt("userId");
				friendsList.add(temp);

			}
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return friendsList;

	}

	public static void insertImage()
 {
		try {
			File file = new File("/home/apurva/Desktop/jj.jpg");

			FileInputStream inputStream = new FileInputStream(file);
			PreparedStatement stmt = null;
			// Get a Statement object
			Connection con;
			con = DB.getConnection();
			// System.out.println("Semester in getSubjList " + semester);

			// //System.out.println("Priyanka!!!!!!!!");
			String query = "insert into Photo(albumId,caption,owner,photo) VALUES ('3','profile pic','19',?)";
			// System.out.println(query);

			stmt = con.prepareStatement(query);

			stmt.setBlob(1, inputStream,file.length());
			stmt.executeUpdate();
			con.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getCause();
			System.out.println(e);
		}

	}
	
	public static void main(String arg[])
	{
		insertImage();
	}

	public static InputStream getPhoto(int photoId) {
		
		InputStream binaryStream=null;
		
		PreparedStatement stmt = null;
		// Get a Statement object
		Connection con;
		// TODO Auto-generated method st
		try{
			con=DB.getConnection();
		String query = "SELECT photo photo FROM Photo where photoId=?";
		
		stmt = con.prepareStatement(query);

		stmt.setInt(1, photoId);
		
		
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			binaryStream = rs.getBinaryStream("photo");
			
		}
		
		con.close();
	} catch (Exception e) {
		e.printStackTrace();
	}		
		return binaryStream;
	}

	public static Profile getProfile(int profileId) {
		
		
		
		PreparedStatement stmt = null;
		Profile user=new Profile();
	
		Connection con;
		
		try{
			con=DB.getConnection();
		String query = "SELECT p.firstName firstName, p.profilePicId profilePicId FROM Profile p where p.profileId=?";
		
		stmt = con.prepareStatement(query);

		stmt.setInt(1, profileId);
		
		
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			user.setFirstName(rs.getString("firstName"));
			System.out.println(user.getFirstName());
			user.setProfilePicId(rs.getInt("profilePicId"));
			
			
			
		}
		
		
		con.close();
	} catch (Exception e) {
		e.printStackTrace();
	}		
		return user;
	}
	
	/**
	 * sends a friend request from user1 to user2
	 * @param userId1
	 * @param userId2
	 */
	public static void sendFriendRequest(int userId1, int userId2) {



		PreparedStatement stmt = null;
		// Get a Statement object
		Connection con;
		
		try {
			con = DB.getConnection();

			String query = "INSERT into facebook.Friendship (userId1,userId2) values(?,?)";
			stmt = con.prepareStatement(query);

			stmt.setInt(1, userId1);
			stmt.setInt(2, userId2);

			 stmt.executeUpdate();
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	
	
	}

	public static void unFriend(int userId1, int userId2) {



		PreparedStatement stmt = null;
		// Get a Statement object
		Connection con;
		
		try {
			con = DB.getConnection();

			String query = "SELECT friendshipId FROM Friendship where (userId1=? AND userId2=?) OR (userId1=? AND userId2=?)";
			stmt = con.prepareStatement(query);

			stmt.setInt(1, userId1);
			stmt.setInt(2, userId2);
			stmt.setInt(3, userId2);
			stmt.setInt(4, userId1);
			System.out.println(stmt);
			int friendshipId=0;
			 ResultSet rs=stmt.executeQuery();
			 
				 while(rs.next())
				  {
					  friendshipId=rs.getInt("friendshipId");
				  }
				 
			
			 
			 
			 query="DELETE  FROM Friendship where friendshipId=?";
			 stmt = con.prepareStatement(query);
			 stmt.setInt(1, friendshipId);
			 System.out.println(stmt);
			 stmt.executeUpdate();
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	
	
	}
	
	
}
