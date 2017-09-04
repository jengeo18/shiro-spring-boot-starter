package top.jengeo.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jajeo on 01/09/2017.
 */
public class MyRealm extends AuthorizingRealm {


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //模拟数据
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Set<String> roles = new HashSet<>();
        roles.add("addmin");
        authorizationInfo.setRoles(roles);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //模拟数据
        UsernamePasswordToken t = (UsernamePasswordToken) token;
        String username = t.getUsername();
        String password = new String(t.getPassword());
        if ("zhang".equalsIgnoreCase(username) && "123".equalsIgnoreCase(password)) {
            return new SimpleAuthenticationInfo(username, password, getName());
        }
        throw new UnknownAccountException();
    }
}
