package edu.iiitb.facebook.action;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.ListIterator;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import edu.iiitb.facebook.model.LastConversation;
import edu.iiitb.facebook.model.Message;
import edu.iiitb.facebook.model.MessageDao;


public class MessageAction {
	private String reply;
	private int user2Id;
	private static int selectedUser;
	private ArrayList<Message> fullConversation ;
	private ArrayList<LastConversation> recentConversationWithAll ; 
	 	
	
	public String getAllMessagesInDatabase ()throws Exception
	{
	    
		MessageDao messageDao = new MessageDao();
		messageDao.getAllMessagesInDatabase();		
		System.out.println(user2Id);
		return "success";		
	}
	public String displayFullConversation ()throws Exception
	{
		HttpSession session = ServletActionContext.getRequest().getSession(
				false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			// System.out.println("inside else");
			int profileid = (Integer) session.getAttribute("profileId");
		
		MessageDao messageDao = new MessageDao();
		fullConversation=messageDao.displayFullConversation(profileid,7);
		recentConversationWithAll=messageDao.displayRecentConversationWithAll(profileid);
		Iterator<Message> itr = fullConversation.iterator();
		
		return "success";	
		}
	}
	
	public String displayRecentConversationWithAll ()throws Exception
	{
		HttpSession session = ServletActionContext.getRequest().getSession(
				false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			// System.out.println("inside else");
			int profileid = (Integer) session.getAttribute("profileId");
		
		MessageDao messageDao = new MessageDao();
		messageDao.displayRecentConversationWithAll(profileid);
		return "success";
		}
	}
	
	public String loadBasicMessagePage() throws Exception
	{
		HttpSession session = ServletActionContext.getRequest().getSession(
				false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			// System.out.println("inside else");
			int profileid = (Integer) session.getAttribute("profileId");
		
        int user2Id;
		MessageDao messageDao = new MessageDao();		
		recentConversationWithAll=messageDao.displayRecentConversationWithAll(profileid);
		System.out.println(recentConversationWithAll.size());
        user2Id=recentConversationWithAll.get(0).getUser2Id();
        if(selectedUser==0)
        selectedUser=user2Id;
        //by default the first person in the list will be the selected user
        fullConversation=messageDao.displayFullConversation(profileid,user2Id);
		return "success";
		}
	}
	
	public String loadConversationWithSelectedUser() throws Exception
	{
		HttpSession session = ServletActionContext.getRequest().getSession(
				false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			// System.out.println("inside else");
			int profileid = (Integer) session.getAttribute("profileId");
		
		MessageDao messageDao = new MessageDao();
		recentConversationWithAll=messageDao.displayRecentConversationWithAll(profileid);
		fullConversation=messageDao.displayFullConversation(profileid,selectedUser);
		return "success";
		}
	}
	
	public String storeReplyToSelectedConversation()throws Exception
	{
		System.out.println(reply);
		loadBasicMessagePage();
		System.out.println(selectedUser);
		return "success";
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
	public final ArrayList<LastConversation> getRecentConversationWithAll() {
		return recentConversationWithAll;
	}
	public final void setRecentConversationWithAll(
			ArrayList<LastConversation> recentConversationWithAll) {
		this.recentConversationWithAll = recentConversationWithAll;
	}
	public final int getSelectedUser() {
		return selectedUser;
	}
	public final void setSelectedUser(int selectedUser) {
		this.selectedUser = selectedUser;
	}
	public final String getReply() {
		return reply;
	}
	public final void setReply(String reply) {
		this.reply = reply;
	}
	
	
}
