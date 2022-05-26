package com.example.blog.dao;

import com.example.blog.entity.User;

/**
 * @ClassName UserDao
 * @Author mrl
 * @Date 2022/5/18 23:46
 * @Version 1.6
 * @Description TODO
 **/
public interface UserDao {
    /**
    * @Author : mrl
    * @Date: 2022/5/20 19:13
    * @Description : 登录检查
    */
    User queryUser(String name, String password);
    /**
    * @Author : mrl
    * @Date: 2022/5/20 19:14
    * @return:
    * @Description : 用于用户修改密码，检验用户存在
    */
    User queryUser(String name, String password,String email);
    /**
    * @Author : mrl
    * @Date: 2022/5/20 19:16
    * @Description :根据name和email查找对应的user，用于找回密码时候检验用户的存在
    */
    User queryUserForEmail(String name,String email);
    /**
    * @Author : mrl
    * @Date: 2022/5/20 19:16
    * @Description :根据name，email找到对应user，用于找回密码
    */
    void updateUserForPassword(String name,String email,String password);
    /**
    * @Author : mrl
    * @Date: 2022/5/20 19:17
    * @Description : 根据id获取对应user信息
    */
    User queryUser(Integer id);
    /**
    * @Author : mrl
    * @Date: 2022/5/20 19:17
    * @Description : 插入用户
    */
    void insertUser(String name,String password,String email);
    /**
    * @Author : mrl
    * @Date: 2022/5/20 19:17
    * @Description : 修改修改密码
    */
    void updateUserPassword(String name,String email,String oldPassword,String newPassword);
}
