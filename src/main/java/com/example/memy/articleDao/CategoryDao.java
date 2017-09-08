package com.example.memy.articleDao;

import com.example.memy.model.Category;
import com.example.memy.model.Gif;

import java.util.List;

/**
 * Created by slickender on 02.08.2017.
 */
public interface CategoryDao {

    List<Category> findAll();

    Category getCategory(Long id);

    List<Gif> findByName(String name);
}
