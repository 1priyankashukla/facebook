package edu.iiitb.facebook.model;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
				comment.setTime(resultSet.getTime("commentTime")/*.getHours()*//*+":"+resultSet.getDate("commentTime").getMinutes()+":"+resultSet.getDate("commentTime").getSeconds()*/+"");
				//System.out.println("Comment Time "+comment.getTime()+" newTime"+convertTime(comment.getTime()));
				
				comment.setTime(convertTime(comment.getTime()));
				comment.setDate(convertDate(resultSet.getDate("commentTime")+""));
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
	public static String convertDate(String oldDate)
	{
		String newDate=" ";
		String ddMM[]=oldDate.split("-");
		switch(Integer.parseInt(ddMM[1]))
		{
		case 1:newDate+="January";
		break;
		case 2:newDate+="February";
		break;
		case 3:newDate+="March";
		break;
		case 4:newDate+="April";
		break;
		case 5:newDate+="May";
		break;
		case 6:newDate+="June";
		break;
		case 7:newDate+="July";
		break;
		case 8:newDate+="August";
		break;
		case 9:newDate+="September";
		break;
		case 10:newDate+="October";
		break;
		case 11:newDate+="November";
		break;
		case 12:newDate+="December";
		break;

		}
		if(ddMM[2].charAt(0)!='0')
		newDate+=" "+ddMM[2];
		else 
		newDate+=" "+ddMM[2].charAt(1);
			
		return newDate;
	}	
	public static InputStream getPic(int photoId)
	{
		ResultSet resultSet= null;
		String query;
		InputStream binaryStream=null;
		query= "select photo from Photo where photoId="+photoId;
		Connection connection;
		connection= DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			while (resultSet.next()) {

			binaryStream = resultSet.getBinaryStream("photo");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return binaryStream;
	}
	public static String convertTime(String time)
	{
		String newTime=" ";
		String hhMM[]=time.split(":");
		if(Integer.parseInt(hhMM[0])>12)
		{
			newTime+=(Integer.parseInt(hhMM[0])-12)+":"+hhMM[1]+"pm";
		}
		else
			newTime+=hhMM[0]+":"+hhMM[1]+"am";
			
		return newTime;
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
	      System.out.println(sql);
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
				"where owner in (select userId2 as friend from Friendship where areFriends='Y' and userId1="+userId+")" +
				" or owner="+ userId+
				" or owner in (select userId1 as friend from Friendship where areFriends='Y' and userId2="+userId+")" +
				" order by postId Desc limit 10;";
		System.out.println(query);
		Connection connection;
		connection= DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			while (resultSet.next()) {
				System.out.println("here");
				post=new Post();
				post.setPostId(resultSet.getInt("postId"));
				System.out.println("Post ID"+resultSet.getInt("postId"));
				post.setPeopleLiked(getPostLikes(resultSet.getInt("postId"), userId));
				if(post.getPeopleLiked().contains("You"))
					post.setYouLiked(true);
				post.setLikeCount(post.getPeopleLiked().size());
				System.out.println("Like count "+post.getPeopleLiked().size());
				post.setPostOwner(getOwnerDetails(resultSet.getInt("owner")));
				post.setPostTime(convertTime(resultSet.getTime("time")+""));
				post.setPostDate(convertDate(resultSet.getDate("time")+""));
				System.out.println(post.getPostDate());
				post.setType(resultSet.getString("type"));
				System.out.println(resultSet.getString("type"));
				if(post.getType().equals("text"))
				{
				post.setUserStatus(getUserStatus(resultSet.getInt("statusId")));
				System.out.println("text");
				}
				System.out.println(post.getUserStatus());

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
		query= "select firstName,lastName,profilePicId from Profile where profileId="+ownerId; 
		Connection connection;
		connection= DB.getConnection();
		resultSet = DB.readFromDB(query, connection);
		try {
			while (resultSet.next()) {
				if(resultSet.getString("lastName")!=null)
				postOwner.setUserName(resultSet.getString("firstName")+" "+resultSet.getString("lastName"));
				else
					postOwner.setUserName(resultSet.getString("firstName"));
				postOwner.setPhotoId(resultSet.getInt("profilePicId"));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(resultSet);
		DB.close(connection);
		
		return postOwner;
	}
}
