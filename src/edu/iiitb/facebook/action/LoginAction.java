package edu.iiitb.facebook.action;

import java.util.Map;



import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import edu.iiitb.facebook.model.Login;

public class LoginAction extends ActionSupport implements SessionAware{

	private long phoneNo;
	private String emailId;
	private String password;
	private String emailOrPhone;
	private String status;
	private int profileId;
	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	private SessionMap<String,Object> sessionMap; 
	public String getEmailOrPhone() {
		return emailOrPhone;
	}
	public void setEmailOrPhone(String emailOrPhone) {
		this.emailOrPhone = emailOrPhone;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long l) {
		this.phoneNo = l;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String doLogin(){
		if(emailOrPhone.equals(""))
			{
			addActionError("Please enter the email id or phone number");
			status = "failure";
			}
		else if(password.equals(""))
			{
			addActionError("Please enter the password");
			status = "failure";
			}
	else{
		
		 if(isEmail(emailOrPhone))
			 {
			 setEmailId(emailOrPhone);
		 if(Login.checkValidity(emailId, password).equals("valid user")){
			 status = "success";
			 setProfileId(Login.getProfileIdByEmail(emailId));
		 sessionMap.put("login","true");
		 sessionMap.put("profileId",getProfileId());

		 }
		else{
			 if(Login.checkValidity(emailId, password).equals("invalid email")) {
				 addActionError("The email id you entered does not belong to any account. Make sure that it is typed correctly");
         		 status = "failure";
				 }
			 
		 if(Login.checkValidity(emailId, password).equals("wrong password")) {
			 addActionError("The password you entered is incorrect"); 
			 status = "failure";
		 }
		}
		 }
		 else
		 {		
			 System.out.println(isEmail(emailOrPhone));
		 setPhoneNo(Long.parseLong(emailOrPhone));
		 if(Login.checkValidity(phoneNo, password).equals("valid user")){
			 status = "success";
			 setEmailId(Login.getEmailIdByPhone(phoneNo));
			 setProfileId(Login.getProfileIdByEmail(getEmailId()));
			 sessionMap.put("login","true");
			 sessionMap.put("profileId",getProfileId());

		 }
		 else{
			 if(Login.checkValidity(phoneNo, password).equals("invalid phone number")) {
				 addActionError("The phone numer you entered is incorrect");
			 status = "failure";
			 }
			 if(Login.checkValidity(phoneNo, password).equals("wrong password")) {
				 addActionError("The password you entered is incorrect"); 
				 status = "failure";
			 }
			
		 }
		 }
	}
		System.out.println();
		return status;
	}
public boolean isEmail(String checkField){
	int i=0; 
	while(i < emailOrPhone.length()) {
        if (!Character.isDigit(checkField.charAt(i))) {
            return true;
        }
        i++;
    }
	return false;

}
@Override
public void setSession(Map<String, Object> map) {
	// TODO Auto-generated method stub
	 sessionMap=(SessionMap)map;
}
}
