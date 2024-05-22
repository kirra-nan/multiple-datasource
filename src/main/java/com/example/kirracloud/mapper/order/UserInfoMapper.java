package com.example.kirracloud.mapper.order;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.kirracloud.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper//指定这是一个操作数据库的mapper
//@Repository
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    public int save(@Param("userInfo") UserInfo userInfo);

    public UserInfo selectUser(@Param("id") String id);
}
