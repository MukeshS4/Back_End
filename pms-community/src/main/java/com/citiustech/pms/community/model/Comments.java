package com.citiustech.pms.community.model;

import com.citiustech.pms.community.entity.Post;

public class Comments {

	private String comment;
	private String commentedBy;
	private Post post;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCommentedBy() {
		return commentedBy;
	}

	public void setCommentedBy(String commentedBy) {
		this.commentedBy = commentedBy;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "Comments [comment=" + comment + ", commentedBy=" + commentedBy + ", post=" + post + "]";
	}

	public Comments(String comment, String commentedBy, Post post) {
		super();
		this.comment = comment;
		this.commentedBy = commentedBy;
		this.post = post;
	}

	public Comments() {
		// TODO Auto-generated constructor stub
	}

}
