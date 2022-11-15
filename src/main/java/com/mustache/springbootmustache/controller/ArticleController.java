package com.mustache.springbootmustache.controller;

import com.mustache.springbootmustache.domain.dto.ArticleDto;
import com.mustache.springbootmustache.domain.entity.Article;
import com.mustache.springbootmustache.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping(value = "/list")
    public String list(Model model) {
        List<Article> articles = articleRepository.findAll();
        model.addAttribute("articles", articles);
        return "layouts/list";
    }

    @GetMapping(value = "")
    public String index() {
        return "redirect:/articles/list";
    }

    @GetMapping(value = "/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        Optional<Article> optionalArticle = articleRepository.findById(id);
        if (!optionalArticle.isEmpty()) {
            model.addAttribute("article", optionalArticle.get());
            return "layouts/edit";
        } else {
            return "layouts/error";
        }
    }
    @GetMapping(value = "/{id}")
    public String selectSingle(@PathVariable Long id, Model model) {
        Optional<Article> optArticle = articleRepository.findById(id);
        if (!optArticle.isEmpty()) {
            model.addAttribute("article", optArticle.get());
            return "layouts/show";
        } else {
            return "layouts/error";
        }
    }

    @PostMapping("/posts")
    public String createArticle(ArticleDto articleDto) {
        log.info(articleDto.getTitle());
        Article savedArticle = articleRepository.save(articleDto.toEntity());
        log.info("generatedId:{}", savedArticle.getId());
        return String.format("redirect:/articles/%d", savedArticle.getId());
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable Long id, ArticleDto articleDto, Model model){
        log.info("title:{} contents:{}", articleDto.getTitle(),articleDto.getContent());
        Article article = articleRepository.save(articleDto.toEntity());
        model.addAttribute("article",article);
        return String.format("redirect:/articles/%d",article.getId());
    }
}