package com.citiustech.pms.community.model;

public class Posts {
	
	private String post;
	private String postCategory;
	private String postedBy;
	@Override
	public String toString() {
		return "Posts [post=" + post + ", postCategory=" + postCategory + ", postedBy=" + postedBy + "]";
	}
	public Posts(String post, String postCategory, String postedBy) {
		super();
		this.post = post;
		this.postCategory = postCategory;
		this.postedBy = postedBy;
	}
	public Posts() {
		
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getPostCategory() {
		return postCategory;
	}
	public void setPostCategory(String postCategory) {
		this.postCategory = postCategory;
	}
	public String getPostedBy() {
		return postedBy;
	}
	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}
	
	

}
