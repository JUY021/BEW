package com.dongyang.wooyeong01.service;

import com.dongyang.wooyeong01.dto.ArticleForm;
import com.dongyang.wooyeong01.entity.Article;
import com.dongyang.wooyeong01.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public Article Create(ArticleForm dto){
        return articleRepository.save(dto.toEntity());
    }

    public List<Article> index(){
        return (List<Article>) articleRepository.findAll();
    }
    public Article show(Long id){
        return articleRepository.findById(id).orElse(null);
    }

    public ResponseEntity<Article> delete(Long id){
        Article target = articleRepository.findById(id).orElse(null);
        if(target == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        articleRepository.delete(target);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public ResponseEntity<Article> update(Long id,  ArticleForm dto){
        Article article = dto.toEntity();
        Article target = articleRepository.findById(id).orElse(null);
        if(target == null || !id.equals(article.getId())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        target.patch(article);
        Article updated = articleRepository.save(target);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }
}
