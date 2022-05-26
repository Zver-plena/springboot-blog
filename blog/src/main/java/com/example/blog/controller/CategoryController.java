package com.example.blog.controller;

import com.example.blog.entity.Category;
import com.example.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ClassName CategoryController
 * @Author mrl
 * @Date 2022/5/20 15:46
 * @Version 1.6
 * @Description TODO
 **/
@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    /**
    * @Author : mrl
    * @Date: 2022/5/20 18:43
    * @return:  String
    * @Description : 实现分类页面的渲染
    */
    @GetMapping("/category.html")
    public String categoryHtml(Model model){
        List<Category> categories = categoryService.getCategories();
        model.addAttribute("categories",categories);
        return "view/category";
    }

    /**
     * @Author : mrl
     * @Date: 2022/5/20 18:43
     * @return: String
     * @Description : 实现分类的添加操作
     */
    @PostMapping("/category/add")
    public String add(@RequestParam("name") String name) {
        categoryService.addCategory(name);
        return "redirect:/category.html";
    }
    /**
    * @Author : mrl
    * @Date: 2022/5/20 18:43
    * @return: String
    * @Description : 实现分类的删除操作
    */

    @GetMapping("/category/delete")
    public String delete(@RequestParam("id")Integer id){
        categoryService.delCategory(id);
        return "redirect:/category.html";
    }


}
