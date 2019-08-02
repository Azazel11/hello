package com.example.springboot.hello.service;

import com.example.springboot.hello.entity.User;
import com.example.springboot.hello.web.response.Response;
import com.github.pagehelper.Page;


import java.util.List;

public interface UserService {
    //注册添加用户
    Response addUser(String name, String phone, String password);
    //登陆
    Response login(String name,String password);
    User queryByName(String name);
    //删除用户
    Response deleteUser(Integer id);
    //更新用户信息
    Response updateUser(User user);
    //详情查询，通过id查询用户全部信息
    User selectUser(Integer id);
    //分页查询
    Page pageList(Integer c, Integer n);
    List<User> selectTest(int c, int n);

    //跨域测试
    List<User> select();
}
