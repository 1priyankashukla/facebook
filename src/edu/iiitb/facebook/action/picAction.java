package edu.iiitb.facebook.action;

import java.io.InputStream;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import edu.iiitb.facebook.model.picDAO;

public class picAction {
	int coverPicId;
	
	
	
	public int getCoverPicId() {
		return coverPicId;
	}



	public void setCoverPicId(int coverPicId) {
		this.coverPicId = coverPicId;
	}



	public String loadCoverPic(){
		HttpSession session = ServletActionContext.getRequest().getSession(
				false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			// System.out.println("inside else");
			int profileid = (Integer) session.getAttribute("profileId");
		
		coverPicId=picDAO.getCoverPic(profileid);
		if(coverPicId==0){
			System.out.println("coverpicID before"+coverPicId);
			coverPicId=4;
			System.out.println("coverpicID after"+coverPicId);
		}
		return "success";
		}
	}

}
