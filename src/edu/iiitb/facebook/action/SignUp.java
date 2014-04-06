package edu.iiitb.facebook.action;



import java.util.Date;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import edu.iiitb.facebook.model.Login;
import edu.iiitb.facebook.model.Profile;
import edu.iiitb.facebook.model.SignUpDao;

public class SignUp implements SessionAware {
	String fname;
	String lname;
	String email;
	String password;
	String reEnteredEmail;
	String day;
	String month;
	String year;
	String gender;
	java.sql.Date birthDate;
	int dobMonth;
	String schoolName;
	String collegeName;
	String companyName;
	String currentCity;
	String hometown;
	private SessionMap<String,Object> sessionMap;
public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCurrentCity() {
		return currentCity;
	}
	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}
	public String getHometown() {
		return hometown;
	}
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getReEnteredEmail() {
		return reEnteredEmail;
	}
	public void setReEnteredEmail(String reEnteredEmail) {
		this.reEnteredEmail = reEnteredEmail;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
public String signUp(){
	String status = null;
	int loginId;
	Profile newProfile = new Profile();
	
	newProfile.setFirstName(fname);
	newProfile.setLastName(lname);
	newProfile.setGender(gender);
	setDate();
	newProfile.setBirthDate(birthDate);
	
	loginId = SignUpDao.createAccount(email, password, fname, lname);
	newProfile.setProfileId(SignUpDao.addNewProfile(newProfile, loginId));
	if(newProfile.getProfileId()!=0)
	{
		status = "success";
		sessionMap.put("login","true");
		sessionMap.put("profileId",newProfile.getProfileId());
	}
	else
		status = "failure";
	
	return status;
	}
public String fillOutInfo(){
		int profileId;
	String status = null;
	HttpSession session=ServletActionContext.getRequest().getSession(false);  
    if(session==null || session.getAttribute("login")==null){  
        return "login";  
    } 
    else{
    	 profileId = (Integer) session.getAttribute("profileId");
        System.out.println("pid in show"+profileId);
   }
	if(SignUpDao.fillOutInfo(profileId, currentCity, hometown, companyName, schoolName, collegeName).equals("info added successfully"))
	{
		status = "success";
	}
	else
		{status = "failure";}
			return status;
}

public void setDate(){
	switch(month){
	case "Jan":
		dobMonth = 1;
		break;
	case "Feb":
		dobMonth = 2;
		break;
	case "Mar":
		dobMonth = 3;
		break;
	case "Apr":
		dobMonth = 4;
		break;
	case "May":
		dobMonth = 5;
		break;
	case "Jun":
		dobMonth = 6;
		break;
	case "Jul":
		dobMonth = 7;
		break;
	case "Aug":
		dobMonth = 8;
		break;
	case "Sept":
		dobMonth = 9;
		break;
	case "Oct":
		dobMonth = 10;
		break;
	case "Nov":
		dobMonth = 11;
		break;
	case "Dec":
		dobMonth = 12;
		
	}
	//birthDate = (java.sql.Date) new Date(Integer.parseInt(year), dobMonth, Integer.parseInt(day));
	birthDate = java.sql.Date.valueOf(Integer.parseInt(year)+"-"+dobMonth+"-"+Integer.parseInt(day));
	
	
}
public void setSession(Map<String, Object> map) {
	// TODO Auto-generated method stub
	 sessionMap=(SessionMap)map;
}
}
