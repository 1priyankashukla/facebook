package edu.iiitb.facebook.action;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.facebook.model.FacebookDAO;

public class SendFriendRequest extends ActionSupport{
	
	int userId1;
	int userId2;
	String searchText;
	String Submit;
	
	public String getSubmit() {
		return Submit;
	}

	public void setSubmit(String submit) {
		Submit = submit;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public int getUserId1() {
		return userId1;
	}

	public void setUserId1(int userId1) {
		this.userId1 = userId1;
	}

	public int getUserId2() {
		return userId2;
	}

	public void setUserId2(int userId2) {
		this.userId2 = userId2;
	}
	/**
	 * Will check whether the request is to add as frind or to respond to request already sent or to delete a friend
	 * 
	 */

	public String execute() throws Exception {
		System.out.println(getSubmit()+" %%%%%%%%%%%%%");
		if(getSubmit().equals("Friends"))
		{
			FacebookDAO.unFriend(getUserId1(), getUserId2());
			return "success";
		}else if(getSubmit().equals("Add Friends")){
			FacebookDAO.sendFriendRequest(getUserId1(), getUserId2());
			return "success";
			
		}
		else if(getSubmit().equals("Respond to Friend Request"))
		{
			return "success";
			
		}
			
		return "login";
	}
	
}
