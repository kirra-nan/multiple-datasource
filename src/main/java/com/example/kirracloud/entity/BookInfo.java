package com.example.kirracloud.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@Data
@TableName("book_info")
@Builder
public class BookInfo {
    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;
    private String bookName;
    private String bookPage;
}
