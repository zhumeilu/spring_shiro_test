package com.zml.spring_shiro_test;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
@Lazy
@Controller
public class IndexController {

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
        return "hello world";
    }
}
