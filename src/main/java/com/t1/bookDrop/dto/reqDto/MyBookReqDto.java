package com.t1.bookDrop.dto.reqDto;

import lombok.Data;

@Data
public class MyBookReqDto {
    private int userid;
    private int page;
    private int filter;
}
