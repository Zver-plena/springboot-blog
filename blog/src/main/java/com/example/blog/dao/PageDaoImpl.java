package com.example.blog.dao;

import com.example.blog.entity.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @ClassName PageDaoImpl
 * @Author mrl
 * @Date 2022/5/19 02:35
 * @Version 1.6
 * @Description TODO
 **/
public class PageDaoImpl implements PageDao  {
    @Autowired
    JdbcTemplate jt;

    /**
     * @param id
     * @Author : mrl
     * @Date: 2022/5/20 19:06
     * @Description : 根据id查询对应的文章
     */
    @Override
    public void addPageView(Integer id) {
        String sql ="update page set view=view+1 where id=?;";
        jt.update(sql,id);
    }

    @Override
    public Page queryPage(Integer id) {
        String sql ="select * from page where id =?;";
        List<Page> pages = jt.query(sql, new BeanPropertyRowMapper<Page>(Page.class),id);
        if(pages==null){
            return null;
        }
        return pages.get(0);
    }

    @Override
    public List<Page> queryPages() {
        String sql ="select * from page";
        List<Page> pages = jt.query(sql, new BeanPropertyRowMapper<Page>(Page.class));
        if(pages==null){
            return null;
        }
        return pages;
    }
    @Override
    public List<Page> queryPages(Integer userId) {
        String sql ="select * from page where userId=?";
        List<Page> pages = jt.query(sql, new BeanPropertyRowMapper<Page>(Page.class),userId);
        if(pages==null){
            return null;
        }
        return pages;
    }

    @Override
    public void delPage(Integer id) {
        String sql="delete from page where id =?;";
        jt.update(sql, id);
    }

    @Override
    public void updatePage(Integer id, String title, String content, Integer category,
                           String summary) {
        String sql="update page set title=?,content=?,category=?,summary=? where id=?;";
        jt.update(sql,title,content,category,summary,id);
    }

    @Override
    public void insertPage(Integer userId,String title, String content, Integer category,
                           String createTime,String summary ,Integer view) {
        String sql ="insert into page(userId,title,content,createTime,category,summary,view) " +
                "values(?,?,?,?,?,?,?)";
        jt.update(sql,userId,title,content,createTime,category,summary,view);
    }
}
