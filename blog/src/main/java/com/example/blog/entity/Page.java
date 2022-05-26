package com.example.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName Page
 * @Author mrl
 * @Date 2022/5/18 23:02
 * @Version 1.6
 * @Description TODO
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page {
    private Integer id ;
    private String title;
    private Integer userId;
    private String content;
    private Integer category;
    private String categoryName;
    private String createTime;
    private Integer view;
    //    private List<Tag> tags;
    private String userName;
    private String summary;
}
