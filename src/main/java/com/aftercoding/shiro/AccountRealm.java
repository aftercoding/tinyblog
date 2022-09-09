package com.aftercoding.shiro;

import cn.hutool.core.bean.BeanUtil;
import com.aftercoding.entity.User;
import com.aftercoding.service.UserService;
import com.aftercoding.util.JwtUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountRealm extends AuthorizingRealm {
//    解析jwt的工具
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    UserService userService;
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        JwtToken jwtToken = (JwtToken)token;
        //获取userID
        String userId = jwtUtils.getClaimByToken((String) jwtToken.getPrincipal()).getSubject();
        User user = userService.getById(Long.valueOf(userId));
        if(user == null){
            throw new UnknownAccountException("account doesn't exist");
        }
        if(user.getStatus() == -1){
            throw new LockedAccountException("account has been locked");
        }
        AccountProfile profile = new AccountProfile();
        BeanUtil.copyProperties(user, profile);
        System.out.println("----------------------");
        return new SimpleAuthenticationInfo(profile, jwtToken.getCredentials(), getName());
    }
}
