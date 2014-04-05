package edu.iiitb.facebook.action;

public class workAndEducation {
	String work;
	String education;
	
	
	public String getWork() {
		return work;
	}


	public void setWork(String work) {
		this.work = work;
	}


	public String getEducation() {
		return education;
	}


	public void setEducation(String education) {
		this.education = education;
	}


	public String storeWorkEducation(){
		if(work.equals(null))
			System.out.println("education:::::"+education);
		if(education.equals(null))
			System.out.println("work:::::"+work);
		
		return "success";
	}

}
