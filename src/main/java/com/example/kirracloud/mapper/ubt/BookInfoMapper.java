package com.example.kirracloud.mapper.ubt;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.kirracloud.entity.BookInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper//指定这是一个操作数据库的mapper
//@Repository
@DS("ubt")
public interface BookInfoMapper extends BaseMapper<BookInfo> {
    public int save(@Param("bookInfo") BookInfo bookInfo);

    public BookInfo selectBook(String id);
}