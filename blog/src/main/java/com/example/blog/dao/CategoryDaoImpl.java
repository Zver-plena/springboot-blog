package com.example.blog.dao;

import com.example.blog.entity.Category;
import com.example.blog.entity.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @ClassName CategoryDaoImpl
 * @Author mrl
 * @Date 2022/5/19 23:18
 * @Version 1.6
 * @Description TODO
 **/
public class CategoryDaoImpl  implements CategoryDao {

    @Autowired
    JdbcTemplate jt;

    @Override
    public void updateCategory(Integer id, Integer Count) {
        String sql ="update categories set count=count+(?) where id =?;";
        jt.update(sql,Count,id);
    }

    @Override
    public Category queryCategory(Integer Id) {
        String sql ="select  * from categories where id =?;";
        List<Category> query = jt.query(sql,
                new BeanPropertyRowMapper<Category>(Category.class), Id);
        if(query==null){
            return null;
        }
        return query.get(0);
    }

    @Override
    public List<Category> queryCategories() {
        String sql ="select * from categories;";
        List<Category> categories = jt.query(sql,
                new BeanPropertyRowMapper<Category>(Category.class));
        if(categories==null){
            return null;
        }
        return categories;
    }

    @Override
    public void insertCategory(String name, Integer count) {
        String sql ="insert into categories(name,count) values(?,?) ;";
        jt.update(sql,name,count);
    }

    @Override
    public void deleteCategory(Integer id) {
        String sql ="delete from categories where id =?;";
        jt.update(sql,id);
    }

    @Override
    public List<Category> queryExistsCategories() {
        String sql ="select * from categories where count!=0";
        List<Category> categories = jt.query(sql,
                new BeanPropertyRowMapper<Category>(Category.class));
        if(categories==null){
            return null;
        }
        return categories;
    }


}
