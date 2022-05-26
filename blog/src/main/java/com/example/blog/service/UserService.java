package com.example.blog.service;

import com.example.blog.entity.User;
import org.springframework.ui.Model;

/**
 * @ClassName UserService
 * @Author mrl
 * @Date 2022/5/18 23:38
 * @Version 1.6
 * @Description TODO
 **/

public interface  UserService {
    //成功返回：注册成功
    String checkRegister(String name,String password,String email);
    //成功返回：更改成功
    String findUserPassword(String name,String password,String email);
    //成功返回：更改成功
    String changeUserPassword(String name,String oldPassword,String newPassword,String email);
    //成功返回：登录成功
    String login(String name,String password);
    //用于登录检查
    User get(String name, String password);
    //用于注册
    void add(String name,String password,String email);
}
