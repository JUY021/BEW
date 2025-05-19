package com.dongyang.wooyeong01.repository;

import com.dongyang.wooyeong01.entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleRepository extends CrudRepository<Article, Long> {

    List<Article> id(Long id);
}
