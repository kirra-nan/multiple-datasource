package com.example.kirracloud.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@Builder
@TableName("user_info")
public class UserInfo {
    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;
    @TableField(value = "u_name")
    private String userName;
    @TableField(value = "u_age")
    private String userAge;
}
