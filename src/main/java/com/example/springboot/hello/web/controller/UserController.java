package com.example.springboot.hello.web.controller;

import com.example.springboot.hello.entity.User;
import com.example.springboot.hello.service.UserService;
import com.example.springboot.hello.web.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping(value = "addUser")
    public Response addUser(@RequestBody Map<String,String> person){
        String name = person.get("name");
        String phone = person.get("phone");
        String password = person.get("password");
        //String pwd = DigestUtils.Md5(name,password);
        Response response = userService.addUser(name,phone,password);
        return response;
    }
    @PostMapping(value = "login")
    public Response login(@RequestBody Map<String,String> person){
        String name = person.get("name");
        String password = person.get("password");
        Response response = userService.login(name,password);
        return response;
    }
    @PostMapping(value = "deleteUser")
    public Response deleteUser(@RequestBody User user) {
        Response response = userService.deleteUser(user.getId());
        return response;
    }
    @PostMapping(value = "updateUser")
    public Response updateUser(@RequestBody User user){
        Response response = userService.updateUser(user);
        return response;
    }
    @PostMapping(value = "selectUser")
    public Response selectUser(@RequestBody User user){
        Response response = new Response();
        response.setResponse("查询成功",1,userService.selectUser(user.getId()));
        return response;
    }
    @PostMapping(value = "selectPage1")
    public Response selectAll(@RequestParam(value = "C") Integer c,@RequestParam(value = "N") Integer n){
        Response response = new Response();
        List<User> userAllList = userService.pageList(c,n);
        response.setResponse("查询成功",1,userAllList);
        return response;
    }
    @PostMapping(value = "selectPage2")
    public Response func(@RequestParam(value = "c") int c, @RequestParam(value = "n") int n) {
        Response response = new Response();
        List<User> users = userService.selectTest((c-1)*n,n);
        response.setResponse("查询成功",1,users);
        return response;
    }
    //跨域测试
    @CrossOrigin
    @RequestMapping(value = "test",method = RequestMethod.GET)
    @ResponseBody
    public Response select(){
       Response response = new Response();
       List<User> u = userService.select();
       response.setResponse("查询成功",1,u);
       return response;
    }
}
