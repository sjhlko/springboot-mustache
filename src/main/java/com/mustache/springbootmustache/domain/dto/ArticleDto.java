package com.mustache.springbootmustache.domain.dto;

import com.mustache.springbootmustache.domain.entity.Article;
import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ArticleDto {
    private Long id;
    private String title;
    private String content;


    public Article toEntity() {
        return new Article(this.id, this.title, this.content);
    }
}
