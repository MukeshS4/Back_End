package com.citiustech.pms.community.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citiustech.pms.community.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, String>{

}
