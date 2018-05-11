package com.mapper;

import com.entity.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lenovo on 2018/4/23.
 * Title UserMapper
 * Package  com.mapper
 * Description
 *
 * @Version V1.0
 */
@Mapper
public interface UserMapper {
    public List<UserVO> findByName(@Param(value = "name") String name, @Param(value = "begin") int begin, @Param(value = "end") int end);

    public int findByNameCount(@Param(value = "name") String name);
}
