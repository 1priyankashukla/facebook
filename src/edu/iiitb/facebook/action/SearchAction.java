package edu.iiitb.facebook.action;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.facebook.model.FacebookDAO;
import edu.iiitb.facebook.model.Profile;





public class SearchAction extends ActionSupport {
	
	String searchText;
	int userId;
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public ArrayList<Profile> getSearchResult() {
		return searchResult;
	}

	public void setSearchResult(ArrayList<Profile> searchResult) {
		this.searchResult = searchResult;
	}

	ArrayList<Profile> searchResult;
	
	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public String temp() throws Exception 
 {

		HttpSession session = ServletActionContext.getRequest().getSession(
				false);
		if (session == null || session.getAttribute("login") == null) {
			// //System.out.println("inside if");
			return "login";
		} else {
			setUserId((Integer) session.getAttribute("profileId"));
			setSearchResult(FacebookDAO.getSearchResult(searchText,
					(Integer) session.getAttribute("profileId")));
			if (getSearchResult() == null)
				return "result";
			else
				return "success";
		}

	}
	
}
	