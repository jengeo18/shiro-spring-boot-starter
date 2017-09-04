package top.jengeo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jajeo on 01/09/2017.
 */

@Controller
public class TestController {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String indexUI() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginUI() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*String error = null;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(true);
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            error = "用户名/密码错误";
        } catch (IncorrectCredentialsException e) {
            error = "用户名/密码错误";
        } catch (AuthenticationException e) {
            //其他错误，比如锁定，如果想单独处理请单独catch处理
            error = "其他错误：" + e.getMessage();
        }

        if(error != null) {
            return "login";
        } else {
            return "index";
        }*/


        //shiro自带filter authc测试
        String errorClassName = (String) request.getAttribute("shiroLoginFailure");
        if (StringUtils.hasText(errorClassName)) {
            if (UnknownAccountException.class.getName().equals(errorClassName)) {
                request.setAttribute("error", "用户名/密码错误");
            } else if (IncorrectCredentialsException.class.getName().equals(errorClassName)) {
                request.setAttribute("error", "用户名/密码错误");
            } else {
                request.setAttribute("error", "未知错误：" + errorClassName);
            }
            return "login";
        } else {
            return "index";
        }
    }

    @RequestMapping(value = "/unauthorized", method = RequestMethod.GET)
    public String unauthorizedUI() {
        return "unauthorized";
    }

    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public String role() {
        return "role";
    }

    @RequestMapping(value = "/authenticated", method = RequestMethod.GET)
    public String authenticatedUI() {
        return "authenticated";
    }
}
