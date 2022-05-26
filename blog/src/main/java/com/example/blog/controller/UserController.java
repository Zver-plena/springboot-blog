package com.example.blog.controller;

import com.example.blog.entity.User;
import com.example.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @ClassName UserController
 * @Author mrl
 * @Date 2022/5/18 23:23
 * @Version 1.6
 * @Description TODO
 **/

@Controller
public class UserController {

    @Autowired
    UserService userService;
    /**
    * @Author : mrl
    * @Date: 2022/5/20 18:56
    * @return: String
    * @Description : 实现用户的登录检查
    */

    @PostMapping("/user/login")
    public String login(@RequestParam("name") String name,
                        @RequestParam("password") String password,
                        RedirectAttributes attributes,
                        HttpSession session){

        String msg= userService.login(name, password);
        User user = userService.get(name, password);
        if("登录成功".equals(msg)){
            session.setAttribute("userName",name);
            session.setAttribute("userId",user.getId());
            return "redirect:/blog.html";
        }
        attributes.addAttribute("msg",msg);
        return "redirect:/login.html";
    }
    @GetMapping(value={"/","/login.html",})
    /**
    * @Author : mrl
    * @Date: 2022/5/20 18:56
    * @return: String
    * @Description : 渲染登录页面
    */

    public String loginHtml(@RequestParam(value="msg",required = false) String msg,
                            Model model){
        model.addAttribute("msg",msg);
        return "view/admin/login";
    }
    /**
    * @Author : mrl
    * @Date: 2022/5/20 18:56
    * @return: String
    * @Description : 实现用户的退出操作
    */
    @GetMapping("/user/logout")
    public String logout(HttpSession session){
        session.removeAttribute("userName");
        session.removeAttribute("userId");
        return "redirect:/login.html";
    }
    /**
    * @Author : mrl
    * @Date: 2022/5/20 18:56
    * @return: String
    * @Description : 实现渲染修改密码页面
    */
    @GetMapping("/find.html")
    public String findHtml(@RequestParam(value = "msg",required = false)String msg,
                             Model model){

        model.addAttribute("msg",msg);
        return "view/admin/find";
    }
    /**
    * @Author : mrl
    * @Date: 2022/5/20 18:56
    * @return: String
    * @Description :  实现修改密码操作的检查和实现
    */

    @PostMapping("/user/find")
    public String find(@RequestParam("name") String name,
                           @RequestParam("password") String password,
                           @RequestParam("email") String email,
                           RedirectAttributes attributes){
        String msg = userService.findUserPassword(name, password, email);
        if("更改成功".equals(msg)){
            return "redirect:/login.html";
        }
        attributes.addAttribute("msg",msg);
        return "redirect:/find.html";
    }
    /**
    * @Author : mrl
    * @Date: 2022/5/20 18:57
    * @return: String
    * @Description : 实现修改密码页面的渲染
    */

    @GetMapping("/change.html")
    public String changeHtml(@RequestParam(value = "msg",required = false)String msg,
                           Model model){
        model.addAttribute("msg",msg);
        return "view/admin/change";
    }
    /**
    * @Author : mrl
    * @Date: 2022/5/20 18:57
    * @return: String
    * @Description : 实现修改密码的检查和实现
    */

    @PostMapping("/user/change")
    public String change(@RequestParam("name") String name,
                       @RequestParam("oldPassword") String oldPassword,
                       @RequestParam("newPassword") String newPassword,
                       @RequestParam("email") String email,
                       RedirectAttributes attributes){
        String msg = userService.changeUserPassword(name,oldPassword ,newPassword, email);
        if("更改成功".equals(msg)){
            return "redirect:/login.html";
        }
        attributes.addAttribute("msg",msg);
        return "redirect:/change.html";
    }
    /**
    * @Author : mrl
    * @Date: 2022/5/20 18:57
    * @return: String
    * @Description : 实现用户的注册功能的检查和实现
    */

    @PostMapping("/user/register")
    public String register(@RequestParam("name") String name,
                           @RequestParam("password") String password,
                           @RequestParam("email") String email,
                           RedirectAttributes attributes){
        String msg = userService.checkRegister(name, password, email);
        if("注册成功".equals(msg)){
            userService.add(name,password,email);
            return "redirect:/login.html";
        }
        attributes.addAttribute("msg",msg);
        return "redirect:/register.html";
    }
    /**
    * @Author : mrl
    * @Date: 2022/5/20 18:58
    * @return: String
    * @Description : 渲染注册页面
    */

    @GetMapping("/register.html")
    public String registerHtml(@RequestParam(value="msg",required = false) String msg,
                               Model model){
        model.addAttribute("msg",msg);
        return "view/admin/register";
    }
}
