package com.example.kirracloud.mapper.ubt;

import com.example.kirracloud.entity.BookInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper//指定这是一个操作数据库的mapper
@Repository
public interface BookInfoMapper {
    public int save(@Param("bookInfo") BookInfo bookInfo);

    public BookInfo selectBook(String id);
}
