package com.example.blog.dao;

import com.example.blog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @ClassName UserDaoImpl
 * @Author mrl
 * @Date 2022/5/18 23:47
 * @Version 1.6
 * @Description TODO
 **/
public class UserDaoImpl implements UserDao {
    @Autowired
    JdbcTemplate jt;
    @Override
    public User queryUser(String name, String password) {
        String sql ="select * from user where name=? and password=?;";
        List<User> users=null;
        users=jt.query(sql,new BeanPropertyRowMapper<User>(User.class),name,password);
        if(users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }

    @Override
    public User queryUser(String name, String password, String email) {
        String sql="select * from user where name=? and password=? and email=?;";
        List<User> users=null;
        users=jt.query(sql,new BeanPropertyRowMapper<User>(User.class),name,password,email);
        if(users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }

    @Override
    public User queryUserForEmail(String name, String email) {
        String sql ="select * from user where name=? and password=?;";
        List<User> users=null;
        users=jt.query(sql,new BeanPropertyRowMapper<User>(User.class),name,email);
        if(users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }

    @Override
    public void updateUserForPassword(String name, String email, String password) {
        String sql ="update user set password=? where name=? and email=?";
        jt.update(sql,password,name,email);
    }



    @Override
    public User queryUser(Integer id) {
        String sql ="select * from user where id=?";
        List<User> users=null;
        users=jt.query(sql,new BeanPropertyRowMapper<User>(User.class),id);
        if(users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }

    @Override
    public void insertUser(String name, String password, String email) {
        String sql="insert into user(name,password,email) values(?,?,?);";
        jt.update(sql,name,password,email);
    }

    @Override
    public void updateUserPassword(String name, String email, String oldPassword, String newPassword) {
        String sql ="update user set password=? where name=? and email=? and password=?";
        jt.update(sql,newPassword,name,email,oldPassword);
    }
}
