package edu.iiitb.facebook.action;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class EventDisplayAction {

	private ArrayList<EventFeedAction> eventD;
	private int sessionId;
	

	
	public String eventDisplay() {
		HttpSession session = ServletActionContext.getRequest().getSession(
				false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			// System.out.println("inside else");
			int profileid = (Integer) session.getAttribute("profileId");
	

		eventD = EventFeedAction.eventListRetrieval(profileid);

	setSessionId(profileid);
		
		if (!eventD.isEmpty())
			System.out.println("in eventDisplay function:   "
					+ eventD.get(0).getDt());

		return "success";
		}

	}

	public ArrayList<EventFeedAction> getEventD() {
		return eventD;
	}

	public void setEventD(ArrayList<EventFeedAction> eventD) {
		this.eventD = eventD;
	}

	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

	

}
