package com.dongyang.wooyeong01.dto;

import com.dongyang.wooyeong01.entity.Article;

public class ArticleForm {
    private Long id;
    private String title;
    private String content;

    public Long getId() { return id; }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setId(Long id) { this.id = id; }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Article toEntity() {
        return new Article(id, title, content);
    }

    @Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
