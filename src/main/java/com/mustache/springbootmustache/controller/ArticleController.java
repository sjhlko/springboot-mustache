package com.mustache.springbootmustache.controller;

import com.mustache.springbootmustache.domain.dto.ArticleDto;
import com.mustache.springbootmustache.domain.entity.Article;
import com.mustache.springbootmustache.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/articles")
@Slf4j
public class ArticleController {
    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping(value = "/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/posts")
    public String createArticle(ArticleDto articleDto){
        log.info(articleDto.toString());
        Article article = articleDto.toEntity();
        articleRepository.save(article);
        return "";
    }
}