package com.example.blog.service;

import com.example.blog.dao.CategoryDao;
import com.example.blog.dao.PageDao;
import com.example.blog.dao.UserDao;
import com.example.blog.entity.Category;
import com.example.blog.entity.Page;
import com.example.blog.entity.User;
import com.example.blog.util.MarkDownUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ClassName PageServiceImpl
 * @Author mrl
 * @Date 2022/5/19 02:28
 * @Version 1.6
 * @Description TODO
 **/
public class PageServiceImpl implements PageService {
    @Autowired
    PageDao pageDao;
    @Autowired
    CategoryDao categoryDao;
    @Autowired
    UserDao userDao;

    @Override
    public void addView(Integer pageId) {
        pageDao.addPageView(pageId);
    }

    @Override
    public List<Page> getPages() {
        List<Page> pages = pageDao.queryPages();
        if (pages == null) {
            return null;
        }
        for (int i = 0; i < pages.size(); i++) {
            pages.set(i, setUserNameAndCategoryName(pages.get(i)));
        }
        return pages;
    }

    @Override
    public List<Page> getPages(Integer userId) {
        List<Page> pages = pageDao.queryPages(userId);
        if (pages == null) {
            return null;
        }
        for (int i = 0; i < pages.size(); i++) {
            pages.set(i, setUserNameAndCategoryName(pages.get(i)));
        }
        return pages;
    }

    @Override
    public Page getAndConvert(Integer pageId) {
        Page page = pageDao.queryPage(pageId);
        if (page == null) {
            return null;
        }
        Page p=new Page();
        BeanUtils.copyProperties(page, p);
        String content = p.getContent();
        content = MarkDownUtil.markDownToHtml(content);
        p.setContent(content);
        return p;
    }

    @Override
    public Page getPage(Integer pageId) {
        Page page = pageDao.queryPage(pageId);
        page = setUserNameAndCategoryName(page);
        return page;
    }

    @Override
    public void delete(Integer Id) {
        pageDao.delPage(Id);
    }

    @Override
    public void edit(Integer pageId, String title, String content,
                     Integer categoryId) {
        String summary = getSummary(content);
        pageDao.updatePage(pageId, title, content, categoryId,summary);
    }


    @Override
    public void publish(Integer userId, String title, String content, Integer categoryId) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime = sdf.format(new Date());
        String summary=getSummary(content);
        pageDao.insertPage(userId, title, content, categoryId, createTime,summary,0);
    }

    @Override
    public Page setUserNameAndCategoryName(Page page) {
        Category category = categoryDao.queryCategory(page.getCategory());
        User user = userDao.queryUser(page.getUserId());
        page.setCategoryName(category.getName());
        page.setUserName(user.getName());
        return page;
    }

    @Override
    public String getSummary(String content) {
        String summary="没有总结";
        summary=content.substring(0,Math.min(100,content.length()));
        return summary;
    }
}
