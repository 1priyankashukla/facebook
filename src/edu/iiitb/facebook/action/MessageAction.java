package edu.iiitb.facebook.action;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.ListIterator;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import edu.iiitb.facebook.model.Message;
import edu.iiitb.facebook.model.MessageDao;





public class MessageAction {
	private int user2Id;
	private ArrayList<Message> fullConversation ;
	
	
	public String getAllMessagesInDatabase ()throws Exception
	{
	    
		MessageDao messageDao = new MessageDao();
		messageDao.getAllMessagesInDatabase();		
		System.out.println(user2Id);
		return "success";		
	}
	public String displayFullConversation ()throws Exception
	{
		//session changes
				HttpSession session = ServletActionContext.getRequest().getSession(
						false);
				if (session == null || session.getAttribute("login") == null) {
					return "login";
				} else {
					// System.out.println("inside else");
					int profileid = (Integer) session.getAttribute("profileId");
		MessageDao messageDao = new MessageDao();
		fullConversation=messageDao.displayFullConversation(profileid,3);
		System.out.println("after message 1");
		Iterator<Message> itr = fullConversation.iterator();
		while (itr.hasNext())
		{
			Message msg = itr.next();
			System.out.println(msg.getText());
		}
		
		return "success";		
				}
	}
	
	public final int getUser2Id() {
		return user2Id;
	}
	public final void setUser2Id(int user2Id) {
		this.user2Id = user2Id;
	}
	public final void setFullConversation(ArrayList<Message> fullConversation) {
		this.fullConversation = fullConversation;
	}
	public final ArrayList<Message> getFullConversation() {
		return fullConversation;
	}
	
	
}
