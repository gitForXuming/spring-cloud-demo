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

    public String sayHello(String name);


    public UserVO getUserInfo(UserVO user);


    public List<BaseVO> findUsers();


    public Result findUserByName(String username, int pageCount, int pageSize);

}
