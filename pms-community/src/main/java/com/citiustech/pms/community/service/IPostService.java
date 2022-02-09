package com.citiustech.pms.community.service;

import com.citiustech.pms.community.entity.Post;
import com.citiustech.pms.community.model.Comments;
import com.citiustech.pms.community.model.Posts;

public interface IPostService {

	Object getAllPosts();

	Object saveInputPost(Posts post);

	Object saveInputComment(Post post);

	Object reportPost(Post post);

	Object deletePost(Post post);

	Object getAllReportedPosts();

}
