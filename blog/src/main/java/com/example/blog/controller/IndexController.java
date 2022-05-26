package com.example.blog.controller;
import com.example.blog.entity.Category;
import com.example.blog.entity.Page;
import com.example.blog.service.CategoryService;
import com.example.blog.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName IndexController
 * @Author mrl
 * @Date 2022/5/18 23:08
 * @Version 1.6
 * @Description TODO
 **/
@Controller
public class IndexController {
    @Autowired
    PageService pageService;
    @Autowired
    CategoryService categoryService;
    /**
    * @Author : mrl
    * @Date: 2022/5/20 18:44
    * @return: String
    * @Description : 渲染首页
    */

    @GetMapping(value={"/index.html"})
    public String index(HttpServletRequest request,
                        Model model)
    {
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        List<Page> pages = pageService.getPages();
        List<Category> categories = categoryService.getExistsCategories();
        model.addAttribute("categories",categories);
        model.addAttribute("pages",pages);
        return "view/index";
    }
}
