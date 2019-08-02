package com.example.springboot.hello.mapper;

import com.example.springboot.hello.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    //删除用户
    int deleteByPrimaryKey(Integer id);
    int insertSelective(User record);
    //注册添加用户
    int insert(String name,String phone,String password);
    List<User> queryByPhone(String phone);
    //登陆验证用户
    User queryByName(String name);
    //详情查询
    User selectByPrimaryKey(Integer id);
    //修改
    int updateByPrimaryKey(User record);
    //分页查询
    List<User> select();
    List<User> selectTest(int c, int n);

}