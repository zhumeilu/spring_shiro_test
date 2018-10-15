package com.zml.spring_shiro_test.config;

import com.zml.spring_shiro_test.model.User;
import com.zml.spring_shiro_test.tools.CoreCodecUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyShiroRealm extends AuthorizingRealm {


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取用户名
        String username = (String) principalCollection.getPrimaryPrincipal();
        //根据用户名查询用户

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(null);
        simpleAuthorizationInfo.setRoles(null);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String username = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        //根据用户名查询用户信息
        User upmsUser = null;

        if (null == upmsUser) {
            throw new UnknownAccountException();
        }
        if (!upmsUser.getPassword().equalsIgnoreCase(CoreCodecUtils.encryptMD5((password + upmsUser.getSalt())))) {
            throw new IncorrectCredentialsException();
        }
//        if (upmsUser.getLocked() == 1) {
//            throw new LockedAccountException();
//        }
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
