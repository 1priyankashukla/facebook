package edu.iiitb.facebook.model;
import edu.iiitb.facebook.util.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
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
			String query="Select firstName from facebook.Profile where profileId = "+msg.getSender()+";";
			stmt=con.prepareStatement(query);
			ResultSet rs=stmt.executeQuery();		
			rs.next();
			msg.setSenderName(rs.getString("firstName"));
			//System.out.println(msg.getSenderName());
			DB.close(con);
		}catch(Exception e)
		{
			//System.out.println(e.getMessage());
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
			String query="Select *from facebook.Messages;";
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
			    poplulateMessageObject(rs, msg);
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
				//System.out.println(fullConversation.size());
			
			}
			DB.close(con);
			populateSenderNames(fullConversation);		
		}catch(Exception e)
		{

		}
		
		return fullConversation;
	}
	public ArrayList<LastConversation> displayRecentConversationWithAll(int user1Id) 
	{
        
		ArrayList<Integer> messageIdList = new ArrayList<Integer>();
		ArrayList<LastConversation> lastConversationWithAllList 
		= new ArrayList<LastConversation>();
		Integer otherPersonId;
        String otherPersonName;
		
        try
		{
			PreparedStatement stmt=null,stmt1=null,stmt2=null,stmt3=null;
			Connection con=DB.getConnection(); 
			
			//first find the latest messages from the conversations table;
			//select * from facebook.Conversations where user1Id=6 or user2Id=6;
			//above query got executed in the terminal , but dint run here .
			// now populate the array list according to the message Id we get from above query
			
			String query="select * from facebook.conversations where  user2Id="+user1Id;			
			String query1 = "select * from facebook.conversations where user1Id="+user1Id;
			stmt=con.prepareStatement(query);
			stmt1=con.prepareStatement(query1);
			ResultSet rs=stmt.executeQuery();		
			ResultSet rs1=stmt1.executeQuery();
			while(rs.next())
			{				  
				messageIdList.add(rs.getInt("lastMessageId"));	
			}
			while(rs1.next())
			{
				messageIdList.add(rs1.getInt("lastMessageId"));
			}
			
		    ListIterator iterator = messageIdList.listIterator();
		   
		    //now from the required message Id list , 
		    //get the last message and get the name of the second user (other than the 1 currently logged in)

		    Message msg = new Message();
		
		    //for each last conversation found !
		    while(iterator.hasNext())
			{						
			    LastConversation lastConversation = new LastConversation();
		    	String query2 = "select * from facebook.Messages where messageId="+iterator.next();
			    stmt2=con.prepareStatement(query2);
			    ResultSet rs2=stmt2.executeQuery();
			    rs2.next();
			    poplulateMessageObject(rs2,msg);
			    // now find the  name of the other person
			    // for that first find Id of other person
			    if(msg.getSender()==user1Id)
			    {
		           otherPersonId=msg.getReceiver();	    	
			    }
			    else otherPersonId=msg.getSender();
			    String query3 = "select firstName from facebook.Profile where profileId="+otherPersonId;
			    stmt3=con.prepareStatement(query3);
			    ResultSet rs3=stmt3.executeQuery();
			    rs3.next();
			    otherPersonName=rs3.getString("firstName");
                lastConversation.setUser2Name(otherPersonName);
                lastConversation.setLastMessageText(rs2.getString("text"));
                lastConversation.setUser2Id(otherPersonId);
                lastConversationWithAllList.add(lastConversation);
			   // System.out.println(otherPersonName);
			}
		    
		    
			DB.close(con);
					
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

		return lastConversationWithAllList;
	}  
	public void poplulateMessageObject(ResultSet rs , Message msg ) throws SQLException
	{
		// given msg object is populated , 
		//here by default refernce of message object is passed 
		msg.setReceiver(rs.getInt("receiver"));
		msg.setText(rs.getString("text"));
	    msg.setSender(rs.getInt("sender"));
		msg.setFromValidity(rs.getBoolean("fromValidity"));
		msg.setToValidity(rs.getBoolean("toValidity"));
		msg.setSeenAt(rs.getTimestamp("seenAt"));
		msg.setSentAt(rs.getTimestamp("sentAt"));
	}
	
	

}
