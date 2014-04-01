package edu.iiitb.facebook.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.facebook.model.FacebookDAO;
import edu.iiitb.facebook.model.Profile;





public class SearchAction extends ActionSupport {
	
	String searchText;
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

		setSearchResult(FacebookDAO.getSearchResult(searchText));
		if (getSearchResult() == null)
			return "result";
		else
			return "success";

	}
	
}
	