package com.zml.spring_shiro_test.controller;

import com.zml.spring_shiro_test.mapper.UserMapper;
import com.zml.spring_shiro_test.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
//@Lazy
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;
    @PostConstruct
    public void postConstruct(){
        System.out.println("-----postConstruct-------");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("-----preDestroy-------");
    }

    @RequestMapping("/")
    @ResponseBody
    public Object index(){
        User user = new User();
        user.setName("zml");
        user.setPassword("123456");
        user.setUsername("zml");
        user.setSalt("zml");
        userMapper.save(user);
        System.out.println(userMapper);
        return "hello world";
    }
}
