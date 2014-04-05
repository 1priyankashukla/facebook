package edu.iiitb.facebook.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.facebook.model.NewsFeedDao;
import edu.iiitb.facebook.model.Post;
import edu.iiitb.facebook.model.PostOwner;

public class NewsFeedAction extends ActionSupport implements SessionAware {
	private ArrayList<Post> posts;
	private ArrayList<String>description;
	
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
	public String likeAction()
	{
		NewsFeedDao.insertPostLike(index,1);
		return "success";
	}
	public String unlikeAction()
	{
		NewsFeedDao.deletePostLike(index,1);
		return "success";
	}
	public String likeCommentAction()
	{
		System.out.println(commentIndex);
		NewsFeedDao.insertCommentLike(commentIndex, 1);
		return "success";
	}
	public String unlikeCommentAction()
	{
		NewsFeedDao.deleteCommentLike(commentIndex,1);
		return "success";
	}

	public String showLikesAction()
	{
		peopleLiked=NewsFeedDao.showPostLikes(index);
		return "success";
	}
	public String showCommentLikesAction()
	{
		peopleLiked=NewsFeedDao.showCommentLikes(commentIndex);
		return "success";
	}

	public String getPost()
	{
		posts=NewsFeedDao.getPosts(1);
/*		System.out.println(posts.get(0).getType());
		System.out.println(posts.get(0).getUserStatus());

		System.out.println(posts.get(1).getUserStatus());*/
		
		return "success";
	}

	public String submitComment()
	{
		int cnt=0;
		for (String des : description) {
			if(!des.equals(""))
			{
				System.out.println("In submit comment "+des+" "+(description.size()-cnt)+"");
				NewsFeedDao.insertComment(1, des,description.size()-cnt);
			}
			cnt++;
		}
		
		return "success";
		
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
