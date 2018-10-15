package com.zml.spring_shiro_test.mapper;

import com.zml.spring_shiro_test.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface UserMapper {

    @Insert(value = "insert into `user`(name,username,password,salt) values(#{name},#{username},#{password},#{salt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void save(User user);


}
