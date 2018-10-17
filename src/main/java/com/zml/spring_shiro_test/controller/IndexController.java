package com.zml.spring_shiro_test.controller;

import com.zml.spring_shiro_test.mapper.PermissionMapper;
import com.zml.spring_shiro_test.mapper.RoleMapper;
import com.zml.spring_shiro_test.mapper.UserMapper;
import com.zml.spring_shiro_test.model.Permission;
import com.zml.spring_shiro_test.model.Role;
import com.zml.spring_shiro_test.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Set;

//@Lazy
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;
    @PostConstruct
    public void postConstruct(){
        System.out.println("-----postConstruct-------");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("-----preDestroy-------");
    }

    @RequestMapping("/index")
    public String indexPage(){
        return "index";
    }

    @RequestMapping("/")
    @ResponseBody
    public Object index(){
        User zml = userMapper.selectUserByUsername("zml");
        System.out.println(zml);

        if(zml!=null){

            Set<Role> roleByUserId = roleMapper.getRoleByUserId(zml.getId());
            System.out.println(roleByUserId);

            roleByUserId.forEach(role -> {
                Set<Permission> permissionsByRoleId = permissionMapper.getPermissionsByRoleId(role.getId());
                System.out.println(permissionsByRoleId);
            });
        }

        return "hello world";
    }
}
