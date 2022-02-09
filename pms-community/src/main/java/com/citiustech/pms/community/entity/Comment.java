package com.citiustech.pms.community.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Community.Comment")
public class Comment implements Serializable {
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	private String commentId;
	private String comment;
	private String commentedBy;
	private LocalDateTime commentedAt;
	private boolean deleted;
	private boolean reported;
	
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
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
	public LocalDateTime getCommentedAt() {
		return commentedAt;
	}
	public void setCommentedAt(LocalDateTime commentedAt) {
		this.commentedAt = commentedAt;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public boolean isReported() {
		return reported;
	}
	public void setReported(boolean reported) {
		this.reported = reported;
	}
	
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", comment=" + comment + ", commentedBy=" + commentedBy
				+ ", commentedAt=" + commentedAt + ", deleted=" + deleted + ", reported=" + reported + "]";
	}
	
	public Comment(String commentId, String comment, String commentedBy, LocalDateTime commentedAt, boolean deleted,
			boolean reported) {
		super();
		this.commentId = commentId;
		this.comment = comment;
		this.commentedBy = commentedBy;
		this.commentedAt = commentedAt;
		this.deleted = deleted;
		this.reported = reported;
	}
	public Comment() {
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((commentId == null) ? 0 : commentId.hashCode());
		result = prime * result + ((commentedAt == null) ? 0 : commentedAt.hashCode());
		result = prime * result + ((commentedBy == null) ? 0 : commentedBy.hashCode());
		result = prime * result + (deleted ? 1231 : 1237);
		result = prime * result + (reported ? 1231 : 1237);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (commentId == null) {
			if (other.commentId != null)
				return false;
		} else if (!commentId.equals(other.commentId))
			return false;
		if (commentedAt == null) {
			if (other.commentedAt != null)
				return false;
		} else if (!commentedAt.equals(other.commentedAt))
			return false;
		if (commentedBy == null) {
			if (other.commentedBy != null)
				return false;
		} else if (!commentedBy.equals(other.commentedBy))
			return false;
		if (deleted != other.deleted)
			return false;
		if (reported != other.reported)
			return false;
		return true;
	}
	
}
