package com.controller;

import com.entity.UserVO;
import com.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    private UserMapper userMapper;

    @RequestMapping(value = "/hello" ,method = RequestMethod.GET)
    public String sayHello(){
        int pageSize =10;
        int pageCount =1;
        List<UserVO> users =  userMapper.findByName("xuming",(pageSize-1)*pageCount,pageSize*pageCount);
        System.out.println("user:"+ users.get(0).getUsername()+","+users.get(0).getPassword());
        return "say form provider one: hello world"+"|||||user:"+ users.get(0).getUsername()+","+users.get(0).getPassword();
    }
}
