package com.dongyang.wooyeong01.controller;

import com.dongyang.wooyeong01.dto.ArticleForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {
    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "boards/new";
    }

    @PostMapping("/articles/new")
    public String newArticleForm(ArticleForm articleForm) {
        System.out.println("dto result: " + articleForm.toString());
        return "";
    }
}