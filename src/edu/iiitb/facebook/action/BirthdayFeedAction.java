package edu.iiitb.facebook.action;

import java.util.ArrayList;

import edu.iiitb.facebook.model.BirthdayDao;

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
	private ArrayList<BirthdayAction> birthday;
	private String displayBirthdayList;
	private boolean flag;
	
	
	public String birthdayNotification()
	{
		//session changes
		HttpSession session = ServletActionContext.getRequest().getSession(
				false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			// System.out.println("inside else");
			int profileid = (Integer) session.getAttribute("profileId");
			// System.out.println("id::::inside profileaction"+id);
		displayBirthdayList="";
		birthday=BirthdayDao.getBirthdayNotification(profileid);
		
		System.out.println(birthday.size());

		if(birthday.size()==1)
			displayBirthdayList=displayBirthdayList + birthday.get(0).getFirstName()+" "+birthday.get(0).getLastName();
	if(birthday.size()>1)	
		displayBirthdayList=displayBirthdayList + birthday.get(0).getFirstName()+" "+birthday.get(0).getLastName()+" and "+ (birthday.size()-1) +" other ";	
	
	if(birthday.size()>0)
		setFlag(true);
	

		//System.out.println(birthday.get(0).getFirstName());
		//System.out.println(birthday.get(0).getLastName());	
		
		return "success";
		}
	}

	public ArrayList<BirthdayAction> getBirthday() {
		return birthday;
	}

	public void setBirthday(ArrayList<BirthdayAction> birthday) {
		this.birthday = birthday;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
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


	
	
	
	
}
