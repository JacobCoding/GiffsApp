package com.example.memy.articleDao;

import com.example.memy.model.Article;

import java.util.List;

public interface ArticleDao {

    List<Article> findAll();
}
