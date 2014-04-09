package edu.iiitb.facebook.action;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import edu.iiitb.facebook.model.BirthdayDao;
import edu.iiitb.facebook.model.Birthday;


import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BirthdayFeedAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Birthday> birthday;
	
//	private ArrayList<EventFeedAction> eventD;
	
	private String displayBirthdayList;
	private boolean flag;
	private int session;
	private int profileId;
	private String wish;
	private int birthdayId;
	//private boolean flagEventWished;
	
	
	
	public String birthdayNotification()
			{
		HttpSession session = ServletActionContext.getRequest().getSession(
				false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			// System.out.println("inside else");
			int profileid = (Integer) session.getAttribute("profileId");
	
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// get current date time with Date()
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		Date d2 = new Date();

		d2.setTime(date.getTime() + 1 * 24 * 60 * 60 * 1000);
		System.out.println("today's date:    "+date);
		System.out.println("tommorow's date:   "+d2);
		
		String dt = (dateFormat.format(date)).toString();
		displayBirthdayList="";
		birthday=BirthdayDao.getBirthdayNotification(profileid,dt);
		
		System.out.println(birthday.size());

		if(birthday.size()==1)
			displayBirthdayList=displayBirthdayList + birthday.get(0).getFirstName()+" "+birthday.get(0).getLastName()+"'s birthday is today";
	if(birthday.size()>1)	
		displayBirthdayList=displayBirthdayList + birthday.get(0).getFirstName()+" "+birthday.get(0).getLastName()+" and "+ (birthday.size()-1) +" other ";	
	
	if(birthday.size()>0)
		setFlag(true);
	

		//System.out.println(birthday.get(0).getFirstName());
		//System.out.println(birthday.get(0).getLastName());	
		
		return "success";
		}
	}
	
	public String postWish()
	{
		HttpSession session = ServletActionContext.getRequest().getSession(
				false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			// System.out.println("inside else");
			int profileid = (Integer) session.getAttribute("profileId");
	
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// get current date time with Date()
		Date date = new Date();
		System.out.println(dateFormat.format(date));

		String dt = (dateFormat.format(date)).toString();
		
		System.out.println("SessionId:  "+session);
		System.out.println("ProfileId:  "+profileId);
		System.out.println("Wish:   "+wish);
		
		BirthdayDao.postBirthdayWish(1,profileId,wish);
		
	/*	if(flagEventWished)
		{
			eventD=EventFeedAction.eventListRetrieval();
		}else{
		
	*/	
			birthday=BirthdayDao.getBirthdayNotification(profileid,dt);
	//	}
		
		
		
		return "success";
		}
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public ArrayList<Birthday> getBirthday() {
		return birthday;
	}

	public void setBirthday(ArrayList<Birthday> birthday) {
		this.birthday = birthday;
	}

	public String getDisplayBirthdayList() {
		return displayBirthdayList;
	}

	public void setDisplayBirthdayList(String displayBirthdayList) {
		this.displayBirthdayList = displayBirthdayList;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public int getSession() {
		return session;
	}

	public void setSession(int session) {
		this.session = session;
	}

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public String getWish() {
		return wish;
	}

	public void setWish(String wish) {
		this.wish = wish;
	}

	public int getBirthdayId() {
		return birthdayId;
	}

	public void setBirthdayId(int birthdayId) {
		this.birthdayId = birthdayId;
	}

	/*public boolean isFlagEventWished() {
		return flagEventWished;
	}

	public void setFlagEventWished(boolean flagEventWished) {
		this.flagEventWished = flagEventWished;
	}

	public ArrayList<EventFeedAction> getEventD() {
		return eventD;
	}

	public void setEventD(ArrayList<EventFeedAction> eventD) {
		this.eventD = eventD;
	}
*/
		
}