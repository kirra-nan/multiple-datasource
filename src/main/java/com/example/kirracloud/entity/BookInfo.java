package com.example.kirracloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookInfo {
    private String id;
    private String bookName;
    private String bookPage;
}
