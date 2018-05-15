package com.controller;

import com.apiImpl.UserServiceImplRemote;
import com.base.Constant;
import com.entity.Result;
import com.entity.UserVO;
import com.service.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotNull;

/**
 * Created by lenovo on 2018/4/23.
 * Title UserController
 * Package  com.controller
 * Description
 *
 * @Version V1.0
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServiceImplRemote userServiceImplRemote;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/ajax/login" ,method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Result login(HttpServletRequest request, UserVO user){
        Result result = null;
        try{
            result = userServiceImplRemote.findUserByName(user.getUsername(),1,1);

            if (result.getContent().size()>0){
                String sessionID = request.getHeader("sessionID");
             }
        }catch(Exception e){
            result.setErrorCode("0000");
            result.setErrorMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/")
    public String index(Model model){
             return "user";
    }

    @RequestMapping(value = "/login")
    public String login(javax.servlet.http.HttpServletRequest request, String username, String password, Model model){
        Result result = null;
        try{
            result = userServiceImplRemote.findUserByName(username,1,1);

            if (result.getContent().size()>0){
                String sessionID = request.getHeader("sessionID");
                redisTemplate.opsForHash().put(Constant.SESSION_PREFIX+sessionID,Constant.SESSION_ATTRIBUTE_PREFIX+"logon","1");
            }
        }catch(Exception e){
            result.setErrorCode("0000");
            result.setErrorMessage(e.getMessage());
            return "longin";
        }

        model.addAttribute("contextPath",getContextPath());

        return "user";
    }

    @RequestMapping(value = "/ajax/find" )
    @ResponseBody
    public Result hello( @RequestParam(value ="username" ) String username
            , @RequestParam(value = "pageCount" ,required = false, defaultValue = "10")
            int pageCount, @RequestParam(value = "pageSize" ,required = false,defaultValue = "1") int pageSize) {
        LOGGER.info("pageCount:"+Integer.toString(pageCount));
        LOGGER.info("pageSize:"+Integer.toString(pageSize));

        Result result  = userServiceImplRemote.findUserByName(username,pageCount,pageSize);
        return result;
    }
}
