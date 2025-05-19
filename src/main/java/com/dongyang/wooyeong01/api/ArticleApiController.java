package com.dongyang.wooyeong01.api;

import com.dongyang.wooyeong01.dto.ArticleForm;
import com.dongyang.wooyeong01.entity.Article;
import com.dongyang.wooyeong01.repository.ArticleRepository;
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
        return articleService.delete(id);
    }

   @PatchMapping("/api/articles/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm dto){
        return articleService.update(id, dto);
   }
}
