package com.example.blog.config;

import com.example.blog.dao.*;
import com.example.blog.entity.Category;
import com.example.blog.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName beans
 * @Author mrl
 * @Date 2022/5/18 23:07
 * @Version 1.6
 * @Description TODO
 **/
@Configuration
public class Beans {

    @Bean
    public UserService userService(){
        return new UserServiceImpl();
    }
    @Bean
    public UserDao userDao(){
        return new UserDaoImpl();
    }
    @Bean
    public PageService pageService(){
        return new PageServiceImpl();
    }
    @Bean
    public PageDao pageDao(){
        return new PageDaoImpl();
    }
    @Bean
    public CategoryDao categoryDao(){
        return new CategoryDaoImpl();
    }
    @Bean
    public CategoryService categoryService(){
        return new CategoryServiceImpl();
    }
}
