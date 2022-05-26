package com.example.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Category
 * @Author mrl
 * @Date 2022/5/19 23:19
 * @Version 1.6
 * @Description TODO
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    Integer id;
    String name ;
    Integer count;

}
