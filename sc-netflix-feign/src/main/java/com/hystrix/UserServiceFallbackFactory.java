package com.hystrix;

import com.apiImpl.UserServiceImplRemote;
import com.entity.BaseVO;
import com.entity.Result;
import com.entity.UserVO;
import com.service.UserService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lenovo on 2018/5/2.
 * Title UserServiceFallbackFactory
 * Package  com.hystrix
 * Description
 *
 * @Version V1.0
 */
@Component
public class UserServiceFallbackFactory implements FallbackFactory<UserServiceImplRemote>{

    @Override
    public UserServiceImplRemote create(final Throwable throwable) {
        return new UserServiceImplRemote(){
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
            public Result findUserByName(String username, int pageCount, int pageSzie) {
                throwable.printStackTrace();
                System.out.println(throwable.getLocalizedMessage());
                System.out.println(throwable.getMessage());
                Result result = new Result();
                result.setResultType(String.class);
                result.setErrorCode("8888");
                result.setErrorMessage("remote invoken method findUserByName failed");
                return result;
            }
        };
    }
}
