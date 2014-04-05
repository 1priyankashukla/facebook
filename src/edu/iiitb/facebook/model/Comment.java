package edu.iiitb.facebook.model;

import java.util.ArrayList;

public class Comment {
	private String description;
	private PostOwner commentOwner;
	private String time;
	private String date;
	private boolean youLiked;
	private int likeCount;
	private ArrayList<String> peopleLiked;
	private int commentId;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public PostOwner getCommentOwner() {
		return commentOwner;
	}
	public void setCommentOwner(PostOwner commentOwner) {
		this.commentOwner = commentOwner;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public boolean isYouLiked() {
		return youLiked;
	}
	public void setYouLiked(boolean youLiked) {
		this.youLiked = youLiked;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public ArrayList<String> getPeopleLiked() {
		return peopleLiked;
	}
	public void setPeopleLiked(ArrayList<String> peopleLiked) {
		this.peopleLiked = peopleLiked;
	}

}
