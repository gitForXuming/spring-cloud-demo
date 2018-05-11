package com.hystrix;

import com.entity.BaseVO;
import com.entity.Result;
import com.entity.UserVO;
import com.service.UserService;
import feign.hystrix.FallbackFactory;

import java.util.List;

/**
 * Created by lenovo on 2018/5/2.
 * Title UserServiceFallbackFactory
 * Package  com.hystrix
 * Description
 *
 * @Version V1.0
 */
public class UserServiceFallbackFactory implements FallbackFactory<UserService>{
    @Override
    public UserService create(Throwable throwable) {
        return new UserService(){
            @Override
            public String sayHello(String name) {
                /*
                后期改造成返回类型统一为 result  通过resutlType 解析结果
                 */
                Result result = new Result();
                result.setResultType(String.class);
                result.setErrorCode("8888");
                result.setErrorMessage("remote invoken method sayHello failed");
                return "remote invoken method sayHello failed";
            }

            @Override
            public UserVO getUserInfo(UserVO user) {
                return null;
            }

            @Override
            public List<BaseVO> findUsers() {
                return null;
            }

            @Override
            public Result findUserByName(String username, int pageCount, int pageSzie) {
                return null;
            }
        };
    }
}
