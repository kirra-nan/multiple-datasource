package com.example.kirracloud.service.impl;

import com.baomidou.dynamic.datasource.annotation.DSTransactional;
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
    // DSTransactional注解在高版本有，用于控制不同数据源事务
    @DSTransactional
    public int save(UserInfo userInfo) {
        int save = mapper.save(userInfo);
        bookInfoMapper.save(BookInfo.builder().id("1").bookName("笑傲江湖").bookPage("100").build());
        return save;
    }

    @Override
    //@Transactional会导致使用默认数据源的事务，也因此会去默认数据源找book_info表，导致找不到表
    @Transactional
    public int save1() {
        mapper.save(UserInfo.builder().id("3").userName("小龙女").userAge("17").build());
        bookInfoMapper.save(BookInfo.builder().id("2").bookName("神雕侠侣").bookPage("100").build());
        int i = 2/0;
        return 0;
    }

    @Override
    public int save2() {
        return 0;
    }
}
