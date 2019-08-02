package com.example.springboot.hello.web.controller;

import com.example.springboot.hello.TmallApplicationTests;
import com.example.springboot.hello.entity.User;
import com.example.springboot.hello.service.UserService;
import com.example.springboot.hello.web.response.Response;
import com.github.pagehelper.Page;
import javafx.application.Application;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

public class UserControllerTest extends TmallApplicationTests {

    @Autowired
    UserService userService;
       @Test
    public void addUser() {
        Response response = userService.addUser("admin","77777777777","admin");
        System.out.println(response.toString());
    }



    @Test
    public void deleteUser() {
        Response response = userService.deleteUser(4);
        System.out.println(response.toString());
    }

    @Test
    public void selectUser() {
        User userList = userService.selectUser(4);
        Assert.assertEquals(new Integer(18),userList.getAge());
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setId(3);
        user.setName("小红");
        user.setSex("女");
        user.setAge(19);
        user.setHeight(180);
        user.setWeight(60.00);
        user.setPhone("14712345678");
        user.setPassword("123456");
        Response response = userService.updateUser(user);
        System.out.println(response.toString());
        System.out.println(user.getPassword());
    }

    @Test
    public void selectAll() {
        Page<User> users = this.userService.pageList(1,2);
        Assert.assertNotNull(users);
        System.out.println(users.getResult());
    }

    @Test
    public void func() {
        List<User> users = userService.selectTest(2,3);
        for (User user:users){
            System.out.println(user.getName());
            System.out.println(user.getSex());
        }
    }
}