package com.dongyang.wooyeong01.api;

import com.dongyang.wooyeong01.dto.ArticleForm;
import com.dongyang.wooyeong01.entity.Article;
import com.dongyang.wooyeong01.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleApiController {
    @Autowired
    private ArticleService articleService;

    @PostMapping("/api/articles")
    public Article Create(@RequestBody ArticleForm dto){
        return articleService.Create(dto);
    }

    @GetMapping("/api/articles")
    public List<Article> index(){
        return articleService.index();
    }

    @GetMapping("/api/articles/{id}")
    public Article show(@PathVariable Long id){
        return articleService.show(id);
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id){
        Article deleted = articleService.delete(id);
        return (deleted != null) ?
            ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

   @PatchMapping("/api/articles/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm dto){
       Article updated = articleService.update(id, dto);
        return (updated != null) ?
               ResponseEntity.status(HttpStatus.OK).build() :
               ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
   }

   @PostMapping("/api/transaction-test")
    public ResponseEntity<List<Article>> testTransaction(@RequestBody List<ArticleForm> dtos){
        List<Article> createdList = articleService.createArticles(dtos);
        return (createdList != null) ?
                ResponseEntity.status(HttpStatus.OK).body(createdList) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
   }
}
