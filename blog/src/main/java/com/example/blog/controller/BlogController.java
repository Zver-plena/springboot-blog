package com.example.blog.controller;

import com.example.blog.entity.Page;
import com.example.blog.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName BlogController
 * @Author mrl
 * @Date 2022/5/19 02:26
 * @Version 1.6
 * @Description TODO
 **/
@Controller
public class BlogController {
    @Autowired
    PageService pageService;

    /**
    * @Author : mrl
    * @Date: 2022/5/20 18:41
    * @return: String
    * @Description : 实现管理面板页面的渲染
    */
    @GetMapping(value = {"/blog.html"})
    public String blog(HttpServletRequest request,
                       Model model) {
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        List<Page> pages = pageService.getPages(userId);
        model.addAttribute("pages", pages);
        return "view/admin/blog";
    }
}
