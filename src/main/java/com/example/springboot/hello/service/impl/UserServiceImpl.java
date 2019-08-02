package com.example.springboot.hello.service.impl;

import com.example.springboot.hello.entity.User;
import com.example.springboot.hello.entity.VO.LoginVo;
import com.example.springboot.hello.mapper.UserMapper;
import com.example.springboot.hello.service.UserService;
import com.example.springboot.hello.web.response.Response;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private UserMapper userMapper;
    public Response addUser(String name, String phone, String password){
        if (name!=null&&phone!=null&&password!=null){
            //String pwd = DigestUtils.Md5(name,password);
            List<User> phone1 = userMapper.queryByPhone(phone);
            //判断手机号是否重复
            if (phone1!=null&&phone1.size()>0){
                Response response = new Response("注册失败，手机号重复",-1);
                return response;
            }else{
                try {
                    int user = userMapper.insert(name,phone,password);
                    if (user>0) {
                        Response response = new Response("注册成功", 1);
                        return response;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    logger.error("注册失败，异常",e);
                }
            }
        }
        Response response = new Response("注册失败，请检查是否填全信息",-1);
        return response;
    }
    public Response login(String name,String password){
        //判断用户名，密码是否为空
        if (name!=null&&password!=null){
            User user = userMapper.queryByName(name);
            LoginVo loginVo = new LoginVo();
            loginVo.setId(user.getId());
            loginVo.setName(user.getName());
            loginVo.setSex(user.getSex());
            loginVo.setAge(user.getAge());
            loginVo.setHeight(user.getHeight());
            loginVo.setWeight(user.getWeight());
            loginVo.setPhone(user.getPhone());
            //判断用户是否存在
            if (user!=null){
                //判断密码是否正确
                if (user.getPassword()==password){
                    Response response = new Response();
                    response.setResponse("登陆成功",1,loginVo);
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
    @Override
    public Response deleteUser(Integer id){
        User user = userMapper.selectByPrimaryKey(id);
        if (user!=null){
            try {
                userMapper.deleteByPrimaryKey(id);
            }catch (Exception e){
                e.printStackTrace();
                logger.error("删除失败，异常",e);
            }
            Response response = new Response("删除成功",1);
            return response;
        }else {
            return new Response("删除失败",-1);
        }
    }
    public Response updateUser(User user){
        User user1 = userMapper.selectByPrimaryKey(user.getId());
        if (user1 != null){
            try {
                //String pwd = DigestUtils.Md5(user.getName(),user.getPassword());
                //user.setPassword(pwd);
                userMapper.updateByPrimaryKey(user);
            }catch (Exception e){
                e.printStackTrace();
                logger.error("更新失败，异常",e);
            }
            Response response = new Response("更新成功",1);
            return response;
        }else {
            Response response = new Response("更新失败",-1);
            return response;
        }
    }
    @Override
    public User selectUser(Integer id){
        User userList = userMapper.selectByPrimaryKey(id);
        return userList;
    }
    @Override
    public Page<User> pageList(Integer c, Integer n){
        return PageHelper.startPage(c,n).doSelectPage(()->userMapper.select());
    }
    public List<User> selectTest(int c,int n){
        return userMapper.selectTest(c, n);
    }
    public User queryByName(String name){
        return userMapper.queryByName(name);
    }
    //跨域测试
    public List<User> select(){
        return userMapper.select();
    }


}
