package edu.iiitb.facebook.model;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.iiitb.facebook.util.DB;

public class FacebookDAO {

	public static ArrayList<Profile> getSearchResult(String searchText) {
		ArrayList<Profile> searchResult = new ArrayList<Profile>();
		PreparedStatement stmt = null;
		// Get a Statement object
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
			//System.out.println("Semester in getSubjList " + semester);

			// //System.out.println("Priyanka!!!!!!!!");
			String query="select photo photo from Photo";
			
			stmt = con.prepareStatement(query);
			ResultSet rs;
			rs = stmt.executeQuery();
			Blob image=null;
			
			while(rs.next())
			{
				image=rs.getBlob("photo");
			}
			
			 query = "select p.loginId loginId, p.profileId profileId, " +
					"p.firstName firstName, p.lastName lastName from Profile p where" +
					" p.firstName like ? and p.lastName like ?";
			//System.out.println(query);
			stmt = con.prepareStatement(query);

			stmt.setString(1, firstName+"%");
			stmt.setString(2, lastName+"%");
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Profile p=new Profile();
				p.setLoginId(rs.getInt("loginId"));
				p.setProfileId(rs.getInt("profileId"));
				p.setFirstName(rs.getString("firstName"));
				p.setLastName(rs.getString("lastName"));
				p.setProfileImage(image);
				searchResult.add(p);
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
	
	public static void insertImage()
 {
		try {
			File file = new File("/home/priyanka/Desktop/2.jpg");

			FileInputStream inputStream = new FileInputStream(file);
			PreparedStatement stmt = null;
			// Get a Statement object
			Connection con;
			con = DB.getConnection();
			// System.out.println("Semester in getSubjList " + semester);

			// //System.out.println("Priyanka!!!!!!!!");
			String query = "insert into Photo(albumId,caption,ownerId,photo) VALUES ('1','profile pic','2',?)";
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
}
