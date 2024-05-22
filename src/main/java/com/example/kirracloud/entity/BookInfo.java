package com.example.kirracloud.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class BookInfo {
    private String id;
    private String bookName;
    private String bookPage;
}
