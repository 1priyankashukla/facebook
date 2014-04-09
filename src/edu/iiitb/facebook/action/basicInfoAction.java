package edu.iiitb.facebook.action;




import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;



import edu.iiitb.facebook.model.basicInfoDAO;

public class basicInfoAction {
	Date birthDate;
	String bDate;
	int bYear;
	basicInfoAction basicInfo; 
	String relWith;
	ArrayList<String> relStatusList;
	ArrayList<String> genderOptions;
	ArrayList<String> menWomen=new ArrayList<String>();
	public ArrayList<String> getMenWomen() {
		return menWomen;
	}

	public void setMenWomen(ArrayList<String> menWomen) {
		this.menWomen = menWomen;
	}

	public ArrayList<String> getGenderOptions() {
		return genderOptions;
	}

	public void setGenderOptions(ArrayList<String> genderOptions) {
		this.genderOptions = genderOptions;
	}


	String editParam;
	
	public String getEditParam() {
		return editParam;
	}

	public void setEditParam(String editParam) {
		this.editParam = editParam;
	}

	public ArrayList<String> getRelStatusList() {
		return relStatusList;
	}

	public void setRelStatusList(ArrayList<String> relStatusList) {
		this.relStatusList = relStatusList;
	}


	
	
	
	
	public String getRelWith() {
		return relWith;
	}

	public void setRelWith(String relWith) {
		this.relWith = relWith;
	}

	public String getbDate() {
		return bDate;
	}

	public void setbDate(String bDate) {
		this.bDate = bDate;
	}

	
	public int getbYear() {
		return bYear;
	}

	public void setbYear(int bYear) {
		this.bYear = bYear;
	}


	String interests;
	String religion;
	String gender;
	String relationship;
	
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String retrieveBasicInfo(){
		HttpSession session = ServletActionContext.getRequest().getSession(
				false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			int profileid = (Integer) session.getAttribute("profileId");
		
		 basicInfo=basicInfoDAO.getBasicInfo(profileid);
		if(basicInfo!=null){
			System.out.println("inside if");
			System.out.println("birth date:::"+basicInfo.getBirthDate());
			
		return "success";
		
		}
		}
		return "failure";
	}

	public basicInfoAction getBasicInfo() {
		return basicInfo;
	}

	public void setBasicInfo(basicInfoAction basicInfo) {
		this.basicInfo = basicInfo;
	}
	
	
	public String retrieveRelStatusList(){
		System.out.println("isnide retrieveRelStatusList");
		relStatusList=basicInfoDAO.getRelStatusList();
		if(relStatusList!=null){
			System.out.println("inside  if list not null");
			return "success";
		}
		return "failure";
	}
	
	public String saveRelStatus(){
		HttpSession session = ServletActionContext.getRequest().getSession(
				false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			int profileid = (Integer) session.getAttribute("profileId");
			
			int success=basicInfoDAO.updateRelStatus(relStatusList.get(0),relWith,profileid);
			return "success";
		
		}
	}
	
	public String gender_temp(){
		System.out.println("inside gender_temp:::"+editParam);
		if(editParam.equals("interests")){
			menWomen.add("Men");
			menWomen.add("Women");
			
		}
		return editParam;
	}
	
	public String saveGender(){
		HttpSession session = ServletActionContext.getRequest().getSession(
				false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			int profileid = (Integer) session.getAttribute("profileId");
			
			int success=basicInfoDAO.updateGender(genderOptions.get(0),profileid);
			return "success";
		
		}
	}
		
		public String saveInterestedIn(){
			HttpSession session = ServletActionContext.getRequest().getSession(
					false);
			if (session == null || session.getAttribute("login") == null) {
				return "login";
			} else {
				int profileid = (Integer) session.getAttribute("profileId");
				if(menWomen.size()==1)
					basicInfoDAO.updateInterestedIn(menWomen.get(0),profileid);
				else
					basicInfoDAO.updateInterestedIn("Men and Women",profileid);
				return "success";
			
			}
	}

}
