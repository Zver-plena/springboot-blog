package com.example.blog.service;

import com.example.blog.entity.Page;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName PageService
 * @Author mrl
 * @Date 2022/5/19 02:27
 * @Version 1.6
 * @Description TODO
 **/
public interface  PageService {
    //更新view
    void addView(Integer pageId);
    //获取所有的page
    List<Page> getPages();
    //根据userId获取所有的page
    List<Page> getPages(Integer userId);
    //转换markdown语法
    Page getAndConvert(Integer pageId);
    //根据pageId获取page
    Page getPage(Integer pageId);
    //根据pageId删除
    void delete(Integer pageId);
    //根据对应的pageId,修改title,content,categoryId
    void  edit(Integer pageId, String title, String content,
                            Integer categoryId);
    //根据对应的userId,添加title,content,categoryId
    void publish(Integer userId,String title,String content,Integer categoryId);
    //设置userName和categoryName
    Page setUserNameAndCategoryName(Page page );
    //获取文章的summary
    String getSummary(String content);
}
