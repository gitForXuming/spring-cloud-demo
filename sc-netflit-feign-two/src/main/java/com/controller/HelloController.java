package com.controller;

import com.apiImpl.UserServiceImplRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lenovo on 2018/5/2.
 * Title HelloController
 * Package  com.controller
 * Description
 *
 * @Version V1.0
 */
@RestController
public class HelloController {

    @Autowired
    private UserServiceImplRemote userServiceImplRemote;

    @RequestMapping(value = "/hello" ,method = RequestMethod.GET)
    public String  hello(String username){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String zuulSessionID = request.getHeader("sessionID");
        System.out.println("zuulSessionID： "+zuulSessionID);
        System.out.println("feign one session id"+ request.getSession().getId());
        return "feign one:" + userServiceImplRemote.sayHello("XUMING");
    }

}
