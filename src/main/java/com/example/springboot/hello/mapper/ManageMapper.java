package com.example.springboot.hello.mapper;

import com.example.springboot.hello.entity.Manage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ManageMapper {
     //登陆验证用户
     Manage selectById(String id);
}
