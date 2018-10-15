package com.zml.spring_shiro_test.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

@Mapper
public interface RoleMapper {

    @Select(value = "select r.name " +
            "from role r left join user_role ur on ur.roleId = r.roleId left join user u on u.userId = ur.userId " +
            "where userId = #{userId}")
    Set<String> getRoleByUserId(Long userId);

}
