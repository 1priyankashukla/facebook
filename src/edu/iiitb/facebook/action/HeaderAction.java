package edu.iiitb.facebook.action;


import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.facebook.model.FacebookDAO;
import edu.iiitb.facebook.model.Profile;

public class HeaderAction extends ActionSupport implements SessionAware {

	private SessionMap<String, Object> sessionMap;
	private Profile user;
	private int profileId;


	public String execute() throws Exception {
		
		HttpSession session=ServletActionContext.getRequest().getSession(false);  
        if(session==null || session.getAttribute("login")==null){  
        	
            return "login";  
        } 
        else{
        	
        	setProfileId((Integer)session.getAttribute("profileId"));
        	System.out.println("profile Id "+getProfileId());
        	setUser(FacebookDAO.getProfile(getProfileId()));
        	System.out.println("##"+user.getFirstName()+"##"+user.getProfilePicId());
        	
        	return "success";
        }

	}

	@Override
	public void setSession(Map<String, Object> map) {

		sessionMap = (SessionMap) map;
	}

	public Profile getUser() {
		return user;
	}

	public void setUser(Profile user) {
		this.user = user;
	}
	

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
}
