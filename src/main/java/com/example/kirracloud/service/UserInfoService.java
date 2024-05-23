package com.example.kirracloud.service;

import com.example.kirracloud.entity.UserInfo;

public interface UserInfoService {
    public UserInfo selectUser(String id);

    public int save(UserInfo userInfo);

    public int save1();

    public int save2();
}
