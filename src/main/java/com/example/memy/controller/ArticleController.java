package com.example.memy.controller;

import com.example.memy.articleDao.ArticleDao;
import com.example.memy.articleDao.ArticleDaoImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticleController {

    private ArticleDao articleDao = new ArticleDaoImp();

    @GetMapping("/articles")
    public String article(ModelMap modelMap){
        modelMap.addAttribute("articles", articleDao.findAll());
        return "articles";
    }
}
