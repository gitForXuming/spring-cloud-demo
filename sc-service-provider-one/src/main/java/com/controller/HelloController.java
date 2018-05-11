package com.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/hello" ,method = RequestMethod.GET)
    public String sayHello(){
        return "say form provider one: hello world";
    }
}
