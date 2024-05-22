package com.example.kirracloud.service.impl;

import com.example.kirracloud.content.DataSourceContent;
import com.example.kirracloud.entity.BookInfo;
import com.example.kirracloud.entity.UserInfo;
import com.example.kirracloud.mapper.order.UserInfoMapper;
import com.example.kirracloud.mapper.ubt.BookInfoMapper;
import com.example.kirracloud.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper mapper;

    @Autowired
    private BookInfoMapper bookInfoMapper;

    @Override
    public UserInfo selectUser(String id) {
        return mapper.selectById(id);
    }

    @Override
//    @Transactional(value = DataSourceContent.TRANSACTION_UBT,rollbackFor = Exception.class)
    @DSTransactional
    public int save(UserInfo userInfo) {
        int save = mapper.save(userInfo);
        bookInfoMapper.save(BookInfo.builder().id("1").bookName("笑傲江湖").bookPage("100").build());
        return save;
    }
}
