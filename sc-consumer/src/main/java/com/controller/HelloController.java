package com.controller;

import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lenovo on 2018/4/28.
 * Title HelloController
 * Package  com.controller
 * Description
 *
 * @Version V1.0
 */
@RestController
public class HelloController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/hello" )

    public String hello(){
        return userService.sayHello("xuming");
    }
}
