package com.example.kirracloud.entity;

import lombok.*;

@Data
@Builder
public class UserInfo {
    private String id;
    private String userName;
    private String userAge;
}
