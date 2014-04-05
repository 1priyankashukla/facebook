package edu.iiitb.facebook.model;

import java.util.ArrayList;

public class Post {
	private int postId;
	private int likeCount;
	private int commentCount;
	private PostOwner postOwner;
	private String userStatus;
	private String type;
	private String updatedTime;
	private ArrayList<String> peopleLiked;
	private boolean youLiked;
	private ArrayList<Comment> comment;
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}
	public PostOwner getPostOwner() {
		return postOwner;
	}
	public void setPostOwner(PostOwner postOwner) {
		this.postOwner = postOwner;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public ArrayList<String> getPeopleLiked() {
		return peopleLiked;
	}
	public void setPeopleLiked(ArrayList<String> peopleLiked) {
		this.peopleLiked = peopleLiked;
	}
	public boolean isYouLiked() {
		return youLiked;
	}
	public void setYouLiked(boolean youLiked) {
		this.youLiked = youLiked;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public ArrayList<Comment> getComment() {
		return comment;
	}
	public void setComment(ArrayList<Comment> comment) {
		this.comment = comment;
	}
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	
}
