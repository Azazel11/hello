package com.example.springboot.hello.entity.VO;

import com.example.springboot.hello.entity.User;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

public class LoginVo {
    private Integer id;

    private String name;

    private String sex;

    private Integer age;

    private Integer height;

    private Double weight;

    private String phone;

    private String rememberMe;

//    public static User getEntity(LoginVo vo){
//        if (Objects.isNull(vo)){
//            return null;
//        }
//        User user = new User();
//        BeanUtils.copyProperties(vo,user);
//        return user;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(String rememberMe) {
        this.rememberMe = rememberMe;
    }

    @Override
    public String toString() {
        return "LoginVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", phone='" + phone + '\'' +
                ", rememberMe='" + rememberMe + '\'' +
                '}';
    }
}
