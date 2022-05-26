package com.example.blog.service;

import com.example.blog.dao.CategoryDao;
import com.example.blog.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName CategoryServiceImpl
 * @Author mrl
 * @Date 2022/5/20 12:42
 * @Version 1.6
 * @Description TODO
 **/
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDao categoryDao;

    @Override
    public List<Category> getExistsCategories() {
        return categoryDao.queryExistsCategories();
    }

    @Override
    public void updateCount(Integer categoryId,Integer Count) {
        categoryDao.updateCategory(categoryId,Count);
    }

    @Override
    public List<Category> getCategories() {
        return categoryDao.queryCategories();
    }

    @Override
    public void addCategory(String name) {
        categoryDao.insertCategory(name,0);
    }

    @Override
    public void delCategory(Integer categoryId) {
        categoryDao.deleteCategory(categoryId);
    }
}
