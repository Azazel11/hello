package com.example.springboot.hello.service.impl;

import com.example.springboot.hello.entity.Manage;
import com.example.springboot.hello.mapper.ManageMapper;
import com.example.springboot.hello.service.ManageService;
import com.example.springboot.hello.web.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ManageServiceImpl implements ManageService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private ManageMapper manageMapper;
    public Response manageLogin(String id, String pwd){
        if (id.length() > 0 && id.length() < 20 && pwd.length() > 0 && pwd.length() < 20){
            Manage manage = manageMapper.selectById(id);
            if (manage!=null){
                if (manage.getPwd().equals(pwd)){
                    Response response = new Response("登陆成功",1);
                    return response;
                }else {
                    Response response = new Response("登陆失败，密码错误",-1);
                    return response;
                }
            }
            Response response = new Response("登陆失败，用户不存在",-1);
            return response;
        }
        Response response = new Response("登陆失败，请检查用户名，密码是否为空",-1);
        return response;
    }

}
