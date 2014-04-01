package edu.iiitb.facebook.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import edu.iiitb.facebook.util.DB;
public class MessageDao {

	
public void populateSenderNames(ArrayList<Message> fullConversation)
{
	Iterator iterator = fullConversation.iterator();
	while ( iterator.hasNext())
	{
		Message msg = (Message) iterator.next();
		try
		{

			PreparedStatement stmt=null;
			Connection con=DB.getConnection();
			String query="Select firstName from Profile where profileId = "+msg.getSender()+";";
			stmt=con.prepareStatement(query);
			ResultSet rs=stmt.executeQuery();		
			rs.next();
			msg.setSenderName(rs.getString("firstName"));
			System.out.println(msg.getSenderName());
			DB.close(con);
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
    	
	}
		
}
	public ArrayList<Message> getAllMessagesInDatabase()
	{
		ArrayList<Message>allMessageList = new ArrayList<Message>();

		try
		{

			PreparedStatement stmt=null;
			Connection con=DB.getConnection();
			String query="Select *from Messages;";
			stmt=con.prepareStatement(query);
			ResultSet rs=stmt.executeQuery();		
			while(rs.next())
				//here i create a new msg object for each message that i want to store
				//the arraylist will only hold only references to the objects .. 
				//the objects should first be formed ,
				// if a new message is not creadted for each object 
				// all objects stored so far in the arraylist contain a reference only to the last mesage
			{	Message msg = new Message();
			msg.setMessageId(rs.getInt("messageId"));
			msg.setSender(rs.getInt("sender"));
			msg.setReceiver(rs.getInt("receiver"));
			msg.setText(rs.getString("text"));
			msg.setFromValidity(rs.getBoolean("fromValidity"));
			msg.setToValidity(rs.getBoolean("toValidity"));
			msg.setSeenAt(rs.getTimestamp("seenAt"));
			msg.setSentAt(rs.getTimestamp("sentAt"));
			allMessageList.add(msg); 

			}
			Iterator iterator = allMessageList.iterator();
			ListIterator litr  = allMessageList.listIterator();	
			Message msg = new Message();
			//here msg object created only once everytime only what it reference to 
			//gets changed
			while(litr.hasNext())
			{			
				msg = (Message) litr.next(); 
				System.out.println(msg.getText());
			}
			DB.close(con);
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return allMessageList;
	}

	public ArrayList<Message> displayFullConversation(int user1Id,int user2Id)
	{
		ArrayList<Message>fullConversation = new ArrayList<Message>();

		try
		{
			PreparedStatement stmt=null;
			Connection con=DB.getConnection();
			String query="select * from Messages " +
					"where " +
					"sender ="+user1Id+" and receiver="+user2Id+" " +
							"or sender="+user2Id+" and receiver ="+user1Id+";";
			stmt=con.prepareStatement(query);
			stmt=con.prepareStatement(query);
			ResultSet rs=stmt.executeQuery();		
			while(rs.next())
				//here i create a new msg object for each message that i want to store
				//the arraylist will only hold only references to the objects .. 
				//the objects should first be formed ,
				// if a new message is not creadted for each object 
				// all objects stored so far in the arraylist contain a reference only to the last mesage
			{	Message msg = new Message();
			msg.setReceiver(rs.getInt("receiver"));
			msg.setText(rs.getString("text"));
		    msg.setSender(rs.getInt("sender"));
			msg.setFromValidity(rs.getBoolean("fromValidity"));
			msg.setToValidity(rs.getBoolean("toValidity"));
			msg.setSeenAt(rs.getTimestamp("seenAt"));
			msg.setSentAt(rs.getTimestamp("sentAt"));
			fullConversation.add(msg); 

			}
			Iterator iterator = fullConversation.iterator();
			ListIterator litr  = fullConversation.listIterator();	
			Message msg = new Message();
			//here msg object created only once everytime only what it reference to 
			//gets changed
			while(litr.hasNext())
			{			
				msg = (Message) litr.next(); 
				//System.out.println(msg.getText());
				System.out.println(fullConversation.size());
			
			}
			DB.close(con);
			populateSenderNames(fullConversation);		
		}catch(Exception e)
		{

		}
		
		return fullConversation;
	}

}
