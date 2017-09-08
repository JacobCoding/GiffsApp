package com.example.memy.api;

import com.example.memy.articleDao.CategoryDaoImpl;
import com.example.memy.model.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoriesApiController {

    @GetMapping("/api/categories")
    public List<Category> listCategories(){
        CategoryDaoImpl categoryDao = new CategoryDaoImpl();
        return categoryDao.findAll();
    }
}