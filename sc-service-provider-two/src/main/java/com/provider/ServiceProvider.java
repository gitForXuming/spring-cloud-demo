package com.provider;

import com.base.Constant;
import com.distributedLock.DistributedLockHandler;
import com.distributedLock.Lock;
import com.entity.BaseVO;
import com.entity.Result;
import com.entity.UserVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mapper.UserMapper;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by lenovo on 2018/4/28.
 * Title ServiceProvider
 * Package  com.provider
 * Description
 *
 * @Version V1.0
 */
@RestController
public class ServiceProvider implements UserService{
    /**
     * 此锁无意义 只是模拟验证一下分布式锁 具体以业务为准
     */
    private final Lock readUserlock = new Lock("readUserlock","readUserlock");
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DistributedLockHandler distributedLockHandler;

    @RequestMapping(value = "/sayHello" ,method = RequestMethod.GET)
    public String sayHello(@RequestParam String name){

        return  "result from service-provider-one , say: hello " + name +"!";
    }

    @RequestMapping(value = "/getUserInfo" ,method = RequestMethod.GET)
    public UserVO getUserInfo(UserVO user) {
        UserVO userInfo = new UserVO();
        userInfo.setUsername(user.getUsername());
        userInfo.setPassword("123456");
        return userInfo;
    }

    @RequestMapping(value = "/findUsers" ,method = RequestMethod.GET)
    public List<BaseVO> findUsers() {

        List<BaseVO> list = new ArrayList<BaseVO>();
        UserVO userInfo = new UserVO();
        userInfo.setUsername("xuming");
        userInfo.setPassword("123456");

        UserVO userInfo1 = new UserVO();
        userInfo1.setUsername("xuming");
        userInfo1.setPassword("123456");

        list.add(userInfo1);
        list.add(userInfo);
        return list;
    }

    @RequestMapping(value = "/findUserByName" ,method = RequestMethod.GET)
    public Result findUserByName(String username, int pageCount, int pageSize) {
       /* Result result = new Result();
        List<BaseVO> list = new ArrayList<BaseVO>();
        UserVO userInfo = new UserVO();
        userInfo.setUsername("xuming");
        userInfo.setPassword("123456");

        UserVO userInfo1 = new UserVO();
        userInfo1.setUsername("xuming");
        userInfo1.setPassword("123456");

        list.add(userInfo1);
        list.add(userInfo);

        result.setContent(list);
        result.setTotalCount(2);
        result.setTotalPage(1);
        return result;*/
        Result result = new Result();


        if(distributedLockHandler.tryLock(readUserlock)){
            try{
                Page<?> page = PageHelper.startPage(pageSize,pageCount);//PageHelper集成有问题 不生效 需要研究 暂时改成low方式
                List<UserVO> users =  userMapper.findByName(username,(pageSize-1)*pageCount,pageSize*pageCount);
                int total = userMapper.findByNameCount(username);
                result.setTotalCount(total);
                result.setTotalPage(total % Constant.PAGE_COUNT==0 ? total %Constant.PAGE_COUNT
                        :total / Constant.PAGE_COUNT +1);
                result.setContent(users);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                //finally释放锁
                distributedLockHandler.releaseLock(readUserlock);
            }
        }




        return result;
    }
}
