package cn.edu.hdu.ssd.core.shiro;

import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import cn.edu.hdu.ssd.model.ShiroToken;





public class UserRealm extends AuthorizingRealm 
{

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0)
    {
       // Long userId = TokenManager.getUserId();
        SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
        //根据用户ID查询角色（role），放入到Authorization里。
//        Set<String> roles = roleService.findRoleByUserId(userId);
//        info.setRoles(roles);
//        //根据用户ID查询权限（permission），放入到Authorization里。
//        Set<String> permissions = permissionService.findPermissionByUserId(userId);
//        info.setStringPermissions(permissions);
        return info;  
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0)
        throws AuthenticationException
    {
        ShiroToken token = (ShiroToken) arg0;
        return new SimpleAuthenticationInfo(arg0,"test", "admin");
    }

}
