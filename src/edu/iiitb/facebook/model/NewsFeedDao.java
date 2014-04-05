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

public class NewsFeedDao {
	public static ArrayList<Comment> getComments(int postId, int userId)
	{
		ArrayList<Comment> comments=new ArrayList<Comment>();
		Comment comment;
		String query;
		query= "select commentId,profileId, description, commentTime from Comment where postId="+postId;
		Connection connection;
		connection= DB.getConnection();
		ResultSet resultSet= null;
		resultSet = DB.readFromDB(query, connection);
		PostOwner postOwner;
		try {
			while (resultSet.next()) {
				comment=new Comment();
				System.out.println("In comment Date="+resultSet.getDate("commentTime")+"");
				comment.setDescription(resultSet.getString("description"));
				postOwner=new PostOwner();
				postOwner=getOwnerDetails(resultSet.getInt("profileId"));
				comment.setCommentOwner(postOwner);
				comment.setCommentId(resultSet.getInt("commentId"));
				comment.setLikeCount(getCommentLikes(resultSet.getInt("commentId")).size());
				comment.setPeopleLiked(getCommentLikes(resultSet.getInt("commentId")));
				if(getCommentLikes(resultSet.getInt("commentId")).contains(getOwnerDetails(userId).getUserName()))
					comment.setYouLiked(true);

				comments.add(comment);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return comments;
	}

	public static void insertComment(int userId,String description, int postId)
	{
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		try { 
			Statement stmt=null;
		    Connection con=DB.getConnection();
	        stmt = con.createStatement();
	      
	      String sql = "INSERT INTO Comment (profileId, postId, commentTime, description) " +
	                   "VALUES ("+userId+", "+postId+", '"+dateFormat.format(date).toString()+"', '"+description+"');"; 
	      stmt.executeUpdate(sql);
	      stmt.close();
			con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void insertPostLike(int postId, int userId)
	{
		
		if(!getPostLikes(postId, userId).contains("You"))
		{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		try { 
			Statement stmt=null;
		    Connection con=DB.getConnection();
	        stmt = con.createStatement();
	      
	      String sql = "INSERT INTO Likes (profileId,type, postId, likeTime) " +
	                   "VALUES ("+userId+", 'post', "+postId+", '"+dateFormat.format(date).toString()+"');"; 
	      stmt.executeUpdate(sql);
	      stmt.close();
			con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		}
	}
	public static void deletePostLike(int postId, int userId)
	{
		try { 
			Statement stmt=null;
		    Connection con=DB.getConnection();
	        stmt = con.createStatement();
	      
	      String sql = "DELETE FROM Likes WHERE postId="+postId+" and profileId="+userId+";";
	      stmt.executeUpdate(sql);
      
	      stmt.close();
			con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
    
	}

	public static void insertCommentLike(int commentId, int userId)
	{
		if(!getCommentLikes(commentId).contains(getOwnerDetails(userId).getUserName()))
		{

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		try { 
			Statement stmt=null;
		    Connection con=DB.getConnection();
	        stmt = con.createStatement();
	      
	      String sql = "INSERT INTO Likes (profileId,type, commentId, likeTime) " +
	                   "VALUES ("+userId+", 'comment', "+commentId+", '"+dateFormat.format(date).toString()+"');"; 
	      stmt.executeUpdate(sql);
	      stmt.close();
			con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		}
	}
	public static void deleteCommentLike(int commentId, int userId)
	{
		try { 
			Statement stmt=null;
		    Connection con=DB.getConnection();
	        stmt = con.createStatement();
	      
	      String sql = "DELETE FROM Likes WHERE commentId="+commentId+" and profileId="+userId+";";
	      stmt.executeUpdate(sql);
      
	      stmt.close();
			con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
    
	}
	
	public static ArrayList<PostOwner> showCommentLikes(int commentId)
	{
		ArrayList<PostOwner> peopleLiked=new ArrayList<PostOwner>();
		ResultSet resultSet= null;
		String query;
		query= "select profileId from Likes where type='comment' and commentId="+commentId;
		Connection connection;
		connection= DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		PostOwner postOwner=new PostOwner();
		try {
			while (resultSet.next()) {
				postOwner=getOwnerDetails(resultSet.getInt("profileId"));
				peopleLiked.add(postOwner);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		System.out.println(peopleLiked);
		return peopleLiked;
	}
	public static ArrayList<PostOwner> showPostLikes(int postId)
	{
		ArrayList<PostOwner> peopleLiked=new ArrayList<PostOwner>();
		ResultSet resultSet= null;
		String query;
		query= "select profileId from Likes where type='post' and postId="+postId;
		Connection connection;
		connection= DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		PostOwner postOwner=new PostOwner();
		try {
			while (resultSet.next()) {
				postOwner=getOwnerDetails(resultSet.getInt("profileId"));
				peopleLiked.add(postOwner);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		System.out.println(peopleLiked);
		return peopleLiked;
	}

	public static ArrayList<String> getPostLikes(int postId, int userId)
	{
		ArrayList<String> peopleLiked=new ArrayList<String>();
		ResultSet resultSet= null;
		String query;
		query= "select profileId from Likes where postId="+postId;
		Connection connection;
		connection= DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		PostOwner postOwner=new PostOwner();
		try {
			while (resultSet.next()) {
				if(resultSet.getInt("profileId")==userId)
				{
					if(peopleLiked.size()!=0 && !peopleLiked.get(0).equals("You"))
					peopleLiked.add(0, "You");
					else if (peopleLiked.size()==0)
						peopleLiked.add(0, "You");
				}
				else
				{
				postOwner=getOwnerDetails(resultSet.getInt("profileId"));
				peopleLiked.add(postOwner.getUserName());
				}
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		System.out.println(peopleLiked);
		return peopleLiked;
	}

	public static ArrayList<String> getCommentLikes(int commentId)
	{
		ArrayList<String> peopleLiked=new ArrayList<String>();
		ResultSet resultSet= null;
		String query;
		query= "select profileId from Likes where commentId="+commentId;
		Connection connection;
		connection= DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		PostOwner postOwner=new PostOwner();
		try {
			while (resultSet.next()) {
				postOwner=getOwnerDetails(resultSet.getInt("profileId"));
				peopleLiked.add(postOwner.getUserName());
				}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		System.out.println("Comment "+peopleLiked);
		return peopleLiked;
	}

	public static ArrayList<Post> getPosts(int userId)
	{
		ArrayList<Post> posts=new ArrayList<Post>();
		Post post;
		ResultSet resultSet= null;
		String query;
		query= "SELECT postId,owner,type,time,statusId,photoId,pollId FROM Post " +
				"where owner in (select userId2 as friend from Friendship where areFriends=1 and userId1="+userId+")" +
				" or owner="+ userId+
				" or owner in (select userId1 as friend from Friendship where areFriends=1 and userId2="+userId+")" +
				" order by postId Desc limit 10;";
		System.out.println(query);
		Connection connection;
		connection= DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			while (resultSet.next()) {
				post=new Post();
				post.setPostId(resultSet.getInt("postId"));
				post.setPeopleLiked(getPostLikes(resultSet.getInt("postId"), userId));
				if(post.getPeopleLiked().contains("You"))
					post.setYouLiked(true);
				post.setLikeCount(post.getPeopleLiked().size());
				post.setPostOwner(getOwnerDetails(resultSet.getInt("owner")));
				post.setUpdatedTime(resultSet.getDate("time")+" "+resultSet.getTime("time")+"");
				post.setType(resultSet.getString("type"));
				if(post.getType().equals("text"))
				{
				post.setUserStatus(getUserStatus(resultSet.getInt("statusId")));
				}
				post.setComment(getComments(resultSet.getInt("postId"),1));
				post.setCommentCount(post.getComment().size());
				posts.add(post);
				
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		
		return posts;
	}

	public static String getUserStatus(int userStatusId)
	{
		String userStatus=new String();
		//get userStatus details
		ResultSet resultSet= null;
		String query;
		query= "select description from UserStatus where userStatusId="+userStatusId; 
		Connection connection;
		connection= DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			while (resultSet.next()) {
				userStatus=resultSet.getString("description");
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		return userStatus;

	}
	public static PostOwner getOwnerDetails(int ownerId)
	{
		//get postOwner Name and pic
		PostOwner postOwner=new PostOwner();
		ResultSet resultSet= null;
		String query;
		query= "select firstName,lastName from Profile where profileId="+ownerId; 
		Connection connection;
		connection= DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			while (resultSet.next()) {
				postOwner.setUserName(resultSet.getString("firstName")+" "+resultSet.getString("lastName"));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		
		return postOwner;
	}
}
