package com.citiustech.pms.community.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.pms.community.entity.Post;
import com.citiustech.pms.community.model.Comments;
import com.citiustech.pms.community.model.Posts;
import com.citiustech.pms.community.service.PostService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CommunityController {
	
	@Autowired
	private PostService postService;
	
	@RequestMapping(value="/community/getAllPosts", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getAllPosts(){
		return ResponseEntity.ok(postService.getAllPosts());
	}
	
	@RequestMapping(value="/community/getAllReportedPosts", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getAllReportedPosts(){
		return ResponseEntity.ok(postService.getAllReportedPosts());
	}
	
	@RequestMapping(value="/community/savePost", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> saveInputPost(@RequestBody Posts post){
		return ResponseEntity.ok(postService.saveInputPost(post));
	}
	
	@RequestMapping(value="/community/saveComment", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> saveInputComment(@RequestBody Post post){
		System.out.println(post);
		return ResponseEntity.ok(postService.saveInputComment(post));
	}
	
	@RequestMapping(value="/community/reportPost", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> reportPost(@RequestBody Post post){
		return ResponseEntity.ok(postService.reportPost(post));
	}
	
	@RequestMapping(value="/community/deletePost", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> deletePost(@RequestBody Post post){
		return ResponseEntity.ok(postService.deletePost(post));
	}
	
}
