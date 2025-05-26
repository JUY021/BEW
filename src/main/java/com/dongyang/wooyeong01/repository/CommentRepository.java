package com.dongyang.wooyeong01.repository;

import com.dongyang.wooyeong01.entity.Article;
import com.dongyang.wooyeong01.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
