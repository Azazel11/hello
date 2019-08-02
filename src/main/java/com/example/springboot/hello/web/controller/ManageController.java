package com.example.springboot.hello.web.controller;


import com.example.springboot.hello.entity.Manage;
import com.example.springboot.hello.service.ManageService;
import com.example.springboot.hello.web.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "manage")
public class ManageController {
    @Autowired
    private ManageService manageService;
    @RequestMapping("login")
    public Response login(@RequestBody Map<String,String> person){
        String id = person.get("id");
        String pwd = person.get("pwd");
        Response response = manageService.manageLogin(id,pwd);
        return response;
    }
}
