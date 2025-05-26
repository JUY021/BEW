package com.dongyang.wooyeong01.service;

import com.dongyang.wooyeong01.dto.ArticleForm;
import com.dongyang.wooyeong01.entity.Article;
import com.dongyang.wooyeong01.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public Article delete(Long id){
        Article target = articleRepository.findById(id).orElse(null);
        if(target == null){
            return null;
        }
        articleRepository.delete(target);
        return target;
    }

    public Article update(Long id,  ArticleForm dto){
        Article article = dto.toEntity();
        Article target = articleRepository.findById(id).orElse(null);
        if(target == null || !id.equals(article.getId())){
            return null;
        }
        target.patch(article);
        Article updated = articleRepository.save(target);
        return updated;
    }

    @Transactional
    public List<Article> createArticles(List<ArticleForm> dtos){
        /*List<Article> articleList= new ArrayList<>();
        for (int i = 0; i < dtos.size(); i++){
            ArticleForm dto = dtos.get(i);
            Article entity = dto.toEntity();
            articleList.add(entity);
        }*/
        List<Article> articleList = dtos.stream()
                                    .map(ArticleForm::toEntity)
                                    .collect(Collectors.toList());

        /*for (int i = 0; i < articleList.size(); i++){
            Article article = articleList.get(i);
            articleRepository.save(article);
        }*/
        articleList.forEach(articleRepository::save);

        /*try {
            articleRepository.findById(-1L).orElseThrow();
        } catch (Exception e) {
            throw new IllegalArgumentException("실패");
        }*/

        return articleList;
    }
}
