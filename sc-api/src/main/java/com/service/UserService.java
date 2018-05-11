package com.service;

import com.entity.BaseVO;
import com.entity.Result;
import com.entity.UserVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by lenovo on 2018/5/2.
 * Title UserService
 * Package  com.service
 * Description
 *
 * @Version V1.0
 */
public interface UserService {
    @RequestMapping(value = "/sayHello" ,method = RequestMethod.GET)
    public String sayHello(String name);

    @RequestMapping(value = "/getUserInfo" ,method = RequestMethod.GET)
    public UserVO getUserInfo(UserVO user);

    @RequestMapping(value = "/findUsers" ,method = RequestMethod.GET)
    public List<BaseVO> findUsers();

    @RequestMapping(value = "/findUserByName" ,method = RequestMethod.GET)
    public Result findUserByName(String username ,int pageCount, int pageSize);

}
