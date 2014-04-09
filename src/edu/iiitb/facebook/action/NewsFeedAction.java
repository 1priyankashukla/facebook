package edu.iiitb.facebook.action;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.facebook.model.NewsFeedDao;
import edu.iiitb.facebook.model.Post;
import edu.iiitb.facebook.model.PostOwner;

public class NewsFeedAction extends ActionSupport implements SessionAware {
	private ArrayList<Post> posts;
	private ArrayList<String> description;
	private ArrayList<String> postId1;
	public ArrayList<String> getPostId1() {
		return postId1;
	}

	public void setPostId1(ArrayList<String> postId1) {
		this.postId1 = postId1;
	}

	private int photoId;

	public int getPhotoId() {
		return photoId;
	}

	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}

	public ArrayList<String> getDescription() {
		return description;
	}

	public void setDescription(ArrayList<String> description) {
		this.description = description;
	}

	private ArrayList<PostOwner> peopleLiked;

	private int index;
	private int postId;

	private int commentIndex;

	public int getCommentIndex() {
		return commentIndex;
	}

	public void setCommentIndex(int commentIndex) {
		this.commentIndex = commentIndex;
	}

	public ArrayList<Post> getPosts() {
		return posts;
	}

	public void setPosts(ArrayList<Post> posts) {
		this.posts = posts;
	}

	public String likeAction() {
				
				HttpSession session=ServletActionContext.getRequest().getSession(false);  
				if(session==null || session.getAttribute("login")==null){  
			
		    		return "login";  
		} 
		else{

		NewsFeedDao.insertPostLike(index, (Integer)session.getAttribute("profileId"));
		return "success";
		}
	}

	public String unlikeAction() {
		 
				
				HttpSession session=ServletActionContext.getRequest().getSession(false);  
				if(session==null || session.getAttribute("login")==null){  
			
		    		return "login";  
		} 
		else{
		
		NewsFeedDao.deletePostLike(index, (Integer)session.getAttribute("profileId"));
		return "success";
		}
	}

	public String likeCommentAction() {
		
		HttpSession session=ServletActionContext.getRequest().getSession(false);  
		if(session==null || session.getAttribute("login")==null){  
	
    		return "login";  
} 
else{

		System.out.println(commentIndex);
		NewsFeedDao.insertCommentLike(commentIndex, (Integer)session.getAttribute("profileId"));
		return "success";
}
	}

	public String unlikeCommentAction() {

		HttpSession session=ServletActionContext.getRequest().getSession(false);  
    		if(session==null || session.getAttribute("login")==null){  
    	
        		return "login";  
    } 
    else{
    	
    	
		NewsFeedDao.deleteCommentLike(commentIndex, (Integer)session.getAttribute("profileId"));
		return "success";
    }
	}

	public String showLikesAction() {

		peopleLiked = NewsFeedDao.showPostLikes(index);
		return "success";
	}

	public String showCommentLikesAction() {
		

		peopleLiked = NewsFeedDao.showCommentLikes(commentIndex);
		return "success";
	}

	public String getPost() {


			HttpSession session=ServletActionContext.getRequest().getSession(false);  
        		if(session==null || session.getAttribute("login")==null){  
        	
            		return "login";  
        } 
        else{
        	
        	
		posts = NewsFeedDao.getPosts((Integer)session.getAttribute("profileId"));
		
		  System.out.println(posts.get(0).getType());
		 System.out.println(posts.get(0).getUserStatus());
		 
		 System.out.println(posts.get(1).getUserStatus());
		 

		return "success";
		}
	}

	public String submitComment() {

		
			HttpSession session=ServletActionContext.getRequest().getSession(false);  
        		if(session==null || session.getAttribute("login")==null){  
        	
            		return "login";  
        } 
        else{
        	
        	
		

		int cnt = 0;
		for (String des : description) {
			if (!des.equals("")) {
				System.out.println("In submit comment " + des + " "
						+ (description.size() - cnt) + "");
				
				NewsFeedDao.insertComment((Integer)session.getAttribute("profileId"), des, Integer.parseInt(postId1.get(cnt).trim()));
				
			}
			cnt++;
		}

		return "success";
	}
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub

	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public ArrayList<PostOwner> getPeopleLiked() {
		return peopleLiked;
	}

	public void setPeopleLiked(ArrayList<PostOwner> peopleLiked) {
		this.peopleLiked = peopleLiked;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

}
