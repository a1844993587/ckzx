package com.xuecheng.test.freemarker.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author Alex Yu
 * @date 2019/9/12 20:35
 */
@Data
public class Student {

    private String name;
    private int age;
    private Date birthday;
    private Float money;
    private List<Student> friends;
    private Student bestFriend;

}
