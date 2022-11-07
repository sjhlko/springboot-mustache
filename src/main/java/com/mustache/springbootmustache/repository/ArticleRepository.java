package com.mustache.springbootmustache.repository;

import com.mustache.springbootmustache.domain.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
}
