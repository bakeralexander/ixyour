package com.ib.oa.filter;

import com.ib.oa.model.OaUser;
import com.ib.oa.service.user.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/4/10.
 * Apache Shiro是一个强大易用的Java安全框架，提供了认证、授权、加密和会话管理等功能：
 */
public class SystemConfigFilter extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("=================doGetAuthorizationInfo[授权认证]=====================");
        OaUser shiroUser = (OaUser) principalCollection.getPrimaryPrincipal();

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRole("admin");
        info.addStringPermission("user:create");
        return info;
    }

    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("=================doGetAuthenticationInfo[登录认证]=====================");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        System.out.println("当前认证用户：" + token.getUsername());
        OaUser user=userService.findByUserName(token.getUsername());
        if (user == null) {
            // 抛出 帐号找不到异常
            throw new UnknownAccountException();
        }
        // 判断帐号是否锁定
        if ("Locked".equals(user.getStatus())) {
            // 抛出 帐号锁定异常
            throw new LockedAccountException();
        }

        // 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUsername(),
                //user.getUsername(), // 用户名
                user.getPassword(), // 密码
                //以创建时间作为盐
//                ByteSource.Util.bytes(user.getCredentialsSalt()),// salt=username+salt
                getName() // realm name
        );
        return authenticationInfo;
    }
}
