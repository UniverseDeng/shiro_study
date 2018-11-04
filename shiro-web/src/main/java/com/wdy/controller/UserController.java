package com.wdy.controller;

import com.wdy.vo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by wudengyu8f@foxmail.com on 2018/10/31
 */
@Controller
public class UserController {

    @RequestMapping(value = "/subLogin", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String subLogin(User user) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try {
            token.setRememberMe(user.isRememberMe());
            subject.login(token);
        } catch (AuthenticationException e) {
            return e.getMessage();
        }

        //编程的方式授权
        if (subject.hasRole("admin")) {
            return "有admin权限";
        }

        return "无admin权限";
    }

    //当前主体必须获得admin角色才可以访问这个连接---测试使用  登录后使用get直接访问
//    @RequiresRoles("admin")
//    @RequestMapping(value = "/testRole", method = RequestMethod.GET)
//    @ResponseBody
//    public String testRole() {
//        return "testRole success";
//    }

    //当前主体必须相应的权限才可以访问的方法---测试使用  登录后使用get直接访问
//    @RequiresPermissions("admin1")
//    @RequestMapping(value = "/testRole1", method = RequestMethod.GET)
//    @ResponseBody
//    public String testRole1() {
//        return "testRole1 success";
//    }

    @RequestMapping(value = "/testRole", method = RequestMethod.GET)
    @ResponseBody
    public String testRole() {
        return "testRole success";
    }

    @RequestMapping(value = "/testRole1", method = RequestMethod.GET)
    @ResponseBody
    public String testRole1() {
        return "testRole1 success";
    }

    @RequestMapping(value = "/testPerms", method = RequestMethod.GET)
    @ResponseBody
    public String testPerms() {
        return "testPerms success";
    }


    @RequestMapping(value = "/testPerms1", method = RequestMethod.GET)
    @ResponseBody
    public String testPerms1() {
        return "testPerms1 success";
    }


}
