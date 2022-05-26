package com.example.blog.service;

import com.example.blog.entity.Category;

import java.util.List;

public interface CategoryService {
    /**
    * @Author : mrl
    * @Date: 2022/5/20 19:53
    * @Description : 获取count不为0的分类，在首页渲染
    */
    List<Category> getExistsCategories();
    /**
    * @Author : mrl
    * @Date: 2022/5/20 19:53
    * @Description : 更新分类的count
    */
    void updateCount(Integer categoryId,Integer Count);
    /**
    * @Author : mrl
    * @Date: 2022/5/20 19:54
    * @Description : 获取所有的分类，在分类页面渲染
    */

    List<Category> getCategories();
    /**
    * @Author : mrl
    * @Date: 2022/5/20 19:54
    * @Description : 添加分类
    */
    void addCategory(String name);
    /**
    * @Author : mrl
    * @Date: 2022/5/20 19:55
    * @Description : 删除对应的分类
    */
    void delCategory(Integer categoryId);
}
