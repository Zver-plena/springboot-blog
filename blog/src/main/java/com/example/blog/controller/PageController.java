package com.example.blog.controller;

import com.example.blog.entity.Category;
import com.example.blog.entity.Page;
import com.example.blog.service.CategoryService;
import com.example.blog.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName PageController
 * @Author mrl
 * @Date 2022/5/19 02:42
 * @Version 1.6
 * @Description TODO
 **/
@Controller

public class PageController {

    @Autowired
    PageService pageService;
    @Autowired
    CategoryService categoryService;

    /**
     * @Author : mrl
     * @Date: 2022/5/20 18:47
     * @return: String
     * @Description : 根据pageId删除对应的page
     */
    @GetMapping("/page/delete")
    public String delete(@RequestParam("pageId") Integer pageId) {
        Page page = pageService.getPage(pageId);
        categoryService.updateCount(page.getCategory(),-1);
        pageService.delete(pageId);
        return "redirect:/blog.html";
    }

    /**
     * @Author : mrl
     * @Date: 2022/5/20 18:48
     * @return: String
     * @Description : 渲染edit页面
     */
    @GetMapping("/edit.html")
    public String editHtml(@RequestParam("pageId") Integer pageId,
                           Model model) {
        Page page = pageService.getPage(pageId);
        List<Category> categories = categoryService.getCategories();
        model.addAttribute("page", page);
        model.addAttribute("categories", categories);
        return "view/admin/edit";
    }

    /**
     * @Author : mrl
     * @Date: 2022/5/20 18:48
     * @return: String
     * @Description : 实现page的内容的编辑更新
     */
    @PostMapping("/page/edit")
    public String edit(@RequestParam("pageId") Integer pageId,
                       @RequestParam("title") String title,
                       @RequestParam("content") String content,
                       @RequestParam(value = "categoryId", required = false) Integer categoryId,
                       HttpServletRequest request) {

        Page page = pageService.getPage(pageId);
        categoryService.updateCount(page.getCategory(),-1);
        categoryService.updateCount(categoryId,1);
        pageService.edit(pageId, title, content, categoryId);
        return "redirect:/blog.html";
    }

    /**
     * @Author : mrl
     * @Date: 2022/5/20 18:49
     * @Description :  实现page的发布
     */
    @PostMapping("/page/publish")
    public String publish(@RequestParam("title") String title,
                          @RequestParam("content") String content,
                          @RequestParam("categoryId") Integer categoryId,
                          HttpServletRequest request) {
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        pageService.publish(userId, title, content, categoryId);
        categoryService.updateCount(categoryId, 1);
        return "redirect:/blog.html";
    }

    /**
     * @Author : mrl
     * @Date: 2022/5/20 18:54
     * @return: String
     * @Description : 实现渲染编辑文章页面
     */

    @GetMapping("/article.html")
    public String articleHtml(Model model) {
        List<Category> categories = categoryService.getCategories();
        model.addAttribute("categories", categories);
        return "view/admin/article";
    }

    /**
     * @Author : mrl
     * @Date: 2022/5/20 18:54
     * @return: String
     * @Description : 实现渲染文章详情页面
     */

    @GetMapping("/detail.html")
    public String detail(@RequestParam("pageId") Integer pageId,
                         Model model) {
        //markdown转成html
        Page page = pageService.getAndConvert(pageId);
        pageService.addView(pageId);
        model.addAttribute("page", page);
        return "view/detail";
    }
}
