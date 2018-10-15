package com.zml.spring_shiro_test.model;

import lombok.Data;

@Data
public class RolePermission {

    private Long id;
    private Long roleId;
    private Long permissionId;
}
