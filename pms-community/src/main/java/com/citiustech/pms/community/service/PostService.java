package com.citiustech.pms.community.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.pms.community.entity.Comment;
import com.citiustech.pms.community.entity.Post;
import com.citiustech.pms.community.model.Comments;
import com.citiustech.pms.community.model.Posts;
import com.citiustech.pms.community.repository.CommentRepository;
import com.citiustech.pms.community.repository.PostRepository;


@Service
public class PostService implements IPostService{
	
	@Autowired 
	private PostRepository postRepo;
	
	@Autowired
	private CommentRepository commentRepo;

	
	@Override
	public Object getAllPosts() {
		List<Post> postList = postRepo.findAllUndeleted();
		return postList;
	}

	@Override
	public Object saveInputPost(Posts post) {
		Post newPost = new Post();
		newPost.setPost(post.getPost());
		newPost.setPostCategory(post.getPostCategory());
		newPost.setPostedBy(post.getPostedBy());
		newPost.setDeleted(false);
		newPost.setPostedAt(LocalDateTime.now());
		newPost.setReported(false);
		return postRepo.save(newPost);
	}

	@Override
	public Object saveInputComment(Post post) {
		Optional<Post> fetchPost = postRepo.findById(post.getPostId());
		List<Comment> commentList = fetchPost.get().getComment();
		Comment newComment = new Comment();
		newComment.setComment(post.getComment().get(0).getComment());
		newComment.setCommentedAt(LocalDateTime.now());
		newComment.setCommentedBy(post.getComment().get(0).getCommentedBy());
		newComment.setDeleted(false);
		newComment.setReported(false);
		commentList.add(newComment);
		fetchPost.get().setComment(commentList);
		return postRepo.save(fetchPost.get());
	}
	
	@Override
	public Object reportPost(Post post) {
		Optional<Post> fetchPost = postRepo.findById(post.getPostId());
		fetchPost.get().setReported(true);
		return postRepo.save(fetchPost.get());
	}
	
	@Override
	public Object deletePost(Post post) {
		Optional<Post> fetchPost = postRepo.findById(post.getPostId());
		fetchPost.get().setDeleted(true);
		return postRepo.save(fetchPost.get());
	}

	@Override
	public Object getAllReportedPosts() {
		List<Post> reportedPostList = postRepo.findAllReported();
		return reportedPostList;
	}
}
