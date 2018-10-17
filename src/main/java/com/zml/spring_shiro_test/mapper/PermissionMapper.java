package com.zml.spring_shiro_test.mapper;

import com.zml.spring_shiro_test.model.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

@Mapper
public interface PermissionMapper {

    @Select(value = "select p.* " +
            "from permission p left join role_permission rp on rp.permissionId = p.id left join role r on r.id = rp.roleId " +
            "where r.id = #{roleId}")
    Set<Permission> getPermissionsByRoleId(Long roleId);


}
