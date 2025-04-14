package com.dongyang.wooyeong01.controller;

import com.dongyang.wooyeong01.dto.ArticleForm;
import com.dongyang.wooyeong01.entity.Article;
import com.dongyang.wooyeong01.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {
    @Autowired
    ArticleRepository articleRepository;

    @GetMapping("/articles/{i}")
    public String show(@PathVariable("i") Long id){
        System.out.println(id);
        return "";
    }
    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "boards/new";
    }

    @PostMapping("/articles/new")
    public String newArticleForm(ArticleForm articleForm) {
        Article article = articleForm.toEntity();
        Article saved = articleRepository.save(article);
        return "redirect:/articles/" + saved.getId();
    }
}