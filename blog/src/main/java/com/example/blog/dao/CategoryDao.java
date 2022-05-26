package com.example.blog.dao;

import com.example.blog.entity.Category;
import com.example.blog.entity.Page;

import java.util.List;

/**
 * @author mrl
 */
public interface CategoryDao {
     /**
     * @Author : mrl
     * @Date: 2022/5/20 19:03
     * @Description : 根据Id，更新对应分类文章的数量
     */
     void updateCategory(Integer Id,Integer Count);
     /**
     * @Author : mrl
     * @Date: 2022/5/20 19:04
     * @Description : 根据id ，查询对应的分类
     */
     Category queryCategory(Integer Id);
     /**
     * @Author : mrl
     * @Date: 2022/5/20 19:04
     * @Description : 获取所有的分类
     */
     List<Category> queryCategories();
     /**
     * @Author : mrl
     * @Date: 2022/5/20 19:05
     * @Description : 添加分类
     */
     void insertCategory(String name,Integer count);
     /**
     * @Author : mrl
     * @Date: 2022/5/20 19:05
     * @Description : 根据id，删除对应的分类
     */

     void deleteCategory(Integer id);
     List<Category> queryExistsCategories();
}
