package com.citiustech.pms.community.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.citiustech.pms.community.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, String>{
	
	@Query(value="Select * from community_post cp where cp.deleted=false", nativeQuery=true)
	List<Post> findAllUndeleted();

	@Query(value="Select * from community_post cp where cp.reported=true", nativeQuery=true)
	List<Post> findAllReported();

}
