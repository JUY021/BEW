package com.dongyang.wooyeong01.controller;

import com.dongyang.wooyeong01.dto.ArticleForm;
import com.dongyang.wooyeong01.entity.Article;
import com.dongyang.wooyeong01.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    ArticleRepository articleRepository;

    @GetMapping("/articles/{i}")
    public String show(@PathVariable("i") Long id, Model mo) {
        Article articleEntity = articleRepository.findById(id).orElse(null);
        mo.addAttribute("article", articleEntity);
        return "boards/show";
    }

    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model mo) {
        Article articleEntity = articleRepository.findById(id).orElse(null);
        mo.addAttribute("article", articleEntity);
        return "boards/edit";
    }

    @PostMapping("/articles/update")
    public String update(ArticleForm articleForm) {
    Article article = articleForm.toEntity();
    Article saved = articleRepository.save(article);
    return  "redirect:/articles/" + saved.getId();
    }

    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable("id") Long id, RedirectAttributes rttr) {
        articleRepository.deleteById(id);
        rttr.addFlashAttribute("msg", "삭제되었습니다.");
        return "/boards/index";
    }

    @GetMapping("/articles")
    public String index(Model mo) {
        List<Article> articleEntityList = (List<Article>)articleRepository.findAll();
        mo.addAttribute("articleList", articleEntityList);
        return "boards/index";
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