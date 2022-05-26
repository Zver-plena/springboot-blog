package com.example.blog.service;

import com.example.blog.dao.UserDao;
import com.example.blog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.Assert;

/**
 * @ClassName UserServiceImpl
 * @Author mrl
 * @Date 2022/5/18 23:39
 * @Version 1.6
 * @Description TODO
 **/
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public String checkRegister(String name, String password, String email) {
        String nameExp = "^[^0-9][\\w_]{5,9}$";
        if (!name.matches(nameExp)) {
            return "用户名不是我想要的样子";
        }
        String pwdExp = "^[\\w_]{6,20}$";
        if (!password.matches(pwdExp)) {
            return "改改你的密码，我不喜欢";
        }
        String emailExp = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)" +
                "+[a-zA-Z]{2,}$";
        if (!email.matches(emailExp)) {
            return "邮箱打回！！！！";
        }
        return "注册成功";
    }

    @Override
    public String findUserPassword(String name, String password, String email) {

        User user = userDao.queryUserForEmail(name, email);
        if(user==null){
            return "用户名或者邮箱错误，请你查查好吧！！";
        }
        String pwdExp = "^[\\w_]{6,20}$";
        if (!password.matches(pwdExp)) {
            return "改改你的密码，我不喜欢";
        }
        userDao.updateUserForPassword(name,email,password);
        return "更改成功";
    }

    @Override
    public String changeUserPassword(String name, String oldPassword, String newPassword, String email) {

        User user = userDao.queryUser(name, oldPassword, email);
        if(user==null){
            return "信息存在错误，请你自觉重新输入";
        }
        String pwdExp = "^[\\w_]{6,20}$";
        if (!newPassword.matches(pwdExp)) {
            return "改改你的新密码，我不喜欢";
        }
        userDao.updateUserPassword(name,email,oldPassword,newPassword);
        return "更改成功";
    }

    @Override
    public String login(String name, String password) {
        User user = userDao.queryUser(name, password);
        if(user==null){
            return "你的用户名或者密码有错误，请你自觉重新输入";
        }
        return "登录成功";
    }

    @Override
    public User get(String name, String password) {
       return userDao.queryUser(name, password);
    }

    @Override
    public void add(String name, String password, String email) {
        userDao.insertUser(name,password,email);
    }
}
