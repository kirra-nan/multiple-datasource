package com.example.kirracloud.service.impl;

import com.example.kirracloud.entity.UserInfo;
import com.example.kirracloud.mapper.order.UserInfoMapper;
import com.example.kirracloud.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper mapper;


    @Override
    public UserInfo selectUser(String id) {
        return mapper.selectUser(id);
    }

    @Override
    @Transactional(value = "orderTransactionManager",rollbackFor = Exception.class)
    public int save(UserInfo userInfo) {
        return mapper.save(userInfo);
    }
}
