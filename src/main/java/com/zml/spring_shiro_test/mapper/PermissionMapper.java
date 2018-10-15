package com.zml.spring_shiro_test.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

@Mapper
public interface PermissionMapper {

    @Select(value = "select p.url " +
            "from permission p left join role_permission rp on rp.permissionId = p.permissionId left join role r on r.roleId = rp.roleId " +
            "where roleId = #{roleId}")
    Set<String> getPermissionsByRoleId(Long roleId);


}
