package edu.iiitb.facebook.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.facebook.model.Birthday;
import edu.iiitb.facebook.model.BirthdayDao;
import edu.iiitb.facebook.model.Event;
import edu.iiitb.facebook.model.EventDao;

public class EventFeedAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<Event> event;
	private ArrayList<Birthday> birthday;
	private String dt;

	public static ArrayList<EventFeedAction> eventListRetrieval(int profileID) {
		
		

		ArrayList<EventFeedAction> eventDisplay = new ArrayList<EventFeedAction>();
		EventFeedAction evD;

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss aa");
		// get current date time with Date()
		Date date = new Date();
		System.out.println("date :"+dateFormat.format(date));

		Date d2 = new Date();
		String d3;
		Date d5 = new Date();
		String d4;

		for (int i = 1; i <= 10; i++) {

			evD = new EventFeedAction();
			if(i==1)
				d4="Today";
			
			else if(i>=2 && i<7)
{
	
				DateFormat format2 = new SimpleDateFormat("EEEE");
				 d4 = format2.format(d5);

}
			else
			{

			DateFormat format2 = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
			d4 = format2.format(d5);
			}
			d3 = (dateFormat.format(date)).toString();

	
			
			evD.dt=d4;
			

			evD.event = EventDao.getEventList(profileID, d3);
			evD.birthday = BirthdayDao.getBirthdayNotification(profileID, d3);

			if (!evD.event.isEmpty() || !evD.birthday.isEmpty())
				eventDisplay.add(evD);

			d2.setTime(date.getTime() + 1 * 24 * 60 * 60 * 1000);
			date = d2;
			d5 = d2;
		}

		return eventDisplay;
		

	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Event> getEvent() {
		return event;
	}

	public void setEvent(ArrayList<Event> event) {
		this.event = event;
	}

	public ArrayList<Birthday> getBirthday() {
		return birthday;
	}

	public void setBirthday(ArrayList<Birthday> birthday) {
		this.birthday = birthday;
	}

	public String getDt() {
		return dt;
	}

	public void setDt(String dt) {
		this.dt = dt;
	}

}
