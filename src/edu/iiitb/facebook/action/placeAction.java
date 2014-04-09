package edu.iiitb.facebook.action;

import java.util.ArrayList;


import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import edu.iiitb.facebook.model.addPlaceDAO;

public class placeAction {
	
	String whereto;
	String when;
	String from;
	String story;
	String address;
	ArrayList<placeAction> placesList;
/* ********************************Shubham Code Start *************************************** */
	
	String location;
	String citytype;
	String address1;
	String City;
	/* ********************************Shubham Code End *************************************** */

	
	public ArrayList<placeAction> getPlacesList() {
		return placesList;
	}

	public void setPlacesList(ArrayList<placeAction> placesList) {
		this.placesList = placesList;
	}

	public String getWhereto() {
		return whereto;
	}

	public void setWhereto(String whereto) {
		this.whereto = whereto;
	}

	public String getWhen() {
		return when;
	}

	public void setWhen(String when) {
		this.when = when;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String addNewPlace(){
		System.out.println("inside addNewPlace");
		HttpSession session = ServletActionContext.getRequest().getSession(
				false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			// System.out.println("inside else");
			int profileid = (Integer) session.getAttribute("profileId");
		addPlaceDAO.insertPlace(whereto,address,from,when,story,profileid);
		return "success";
		}
	}
	
	public String retrievePlaces(){
		System.out.println("inside addNewPlace");
		HttpSession session = ServletActionContext.getRequest().getSession(
				false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		} else {
			int profileid = (Integer) session.getAttribute("profileId");
			placesList=addPlaceDAO.getPlaces(profileid);
			for(placeAction place:placesList){
				System.out.println("place in action"+place.whereto);
				
			}
			return "success";
		}
	}
	
/* ********************************Shubham Code Start *************************************** */
	
	public String editLocation1(){
			System.out.println("inside editPlace");
			HttpSession session = ServletActionContext.getRequest().getSession(
					false);
			if (session == null || session.getAttribute("login") == null) {
				return "login";
			} else {
			/*	int profileid = (Integer) session.getAttribute("profileId");
				placesList=addPlaceDAO.getPlaces(profileid);
				for(placeAction place:placesList){
					System.out.println("place in action"+place.whereto);
			*/		
				System.out.println("current"+location);
				}
				return "success";
			}
		
		public String editLocation2(){
			System.out.println("inside editPlace");
			HttpSession session = ServletActionContext.getRequest().getSession(
					false);
			if (session == null || session.getAttribute("login") == null) {
				return "login";
			} else {
				//this.address1=citytype;
				System.out.println("Address=="+address1+"  Location=="+City);
				int profileid = (Integer) session.getAttribute("profileId");
				addPlaceDAO.editPlace(City,address1,profileid);
				System.out.println("current"+location);
				}
			
				return "success";
			}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public String getCitytype() {
			return citytype;
		}

		public void setCitytype(String citytype) {
			this.citytype = citytype;
		}

		public String getAddress1() {
			return address1;
		}

		public void setAddress1(String address1) {
			this.address1 = address1;
		}

		public String getCity() {
			return City;
		}

		public void setCity(String city) {
			City = city;
		}
	
	/* ********************************Shubham Code End *************************************** */

	

}
