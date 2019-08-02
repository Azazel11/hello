package com.example.springboot.hello.service;

import com.example.springboot.hello.entity.Manage;
import com.example.springboot.hello.web.response.Response;

public interface ManageService {
    Response manageLogin(String id, String pwd);
}
