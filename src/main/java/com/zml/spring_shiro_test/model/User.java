package com.zml.spring_shiro_test.model;


import lombok.Data;

@Data
public class User {

    private Long id;
    private String name;
    private String username;
    private String password;
    private String salt;

}
