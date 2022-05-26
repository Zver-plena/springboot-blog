package com.example.blog.dao;

import com.example.blog.entity.Page;

import java.util.List;

public interface PageDao {
    /**
    * @Author : mrl
    * @Date: 2022/5/20 19:06
    * @Description : 根据id查询对应的文章
    */
    void addPageView(Integer id);
    Page queryPage(Integer id);
    /**
    * @Author : mrl
    * @Date: 2022/5/20 19:06
    * @Description : 根据id删除对应的文章
    */
    void delPage(Integer id );
    /**
    * @Author : mrl
    * @Date: 2022/5/20 19:06
    * @Description : 根据id更新对应的文章内容
    */
    void updatePage(Integer id,String title,String content,Integer category, String summary);
    /**
    * @Author : mrl
    * @Date: 2022/5/20 19:07
    * @Description : 插入文章
    */
    void insertPage(Integer userId,String title,String content,Integer category,
                    String createTime,String summary,Integer view);
    /**
    * @Author : mrl
    * @Date: 2022/5/20 19:07
    * @Description :查询所有的文章
    */
    List<Page> queryPages();
    /**
    * @Author : mrl
    * @Date: 2022/5/20 19:13
    * @Description : 查询指定user的所有文章
    */

    List<Page> queryPages(Integer userId);
}
