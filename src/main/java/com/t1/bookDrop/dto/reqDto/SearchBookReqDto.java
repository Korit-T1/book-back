package com.t1.bookDrop.dto.reqDto;

import lombok.Data;

@Data
public class SearchBookReqDto {
    private int page;
    private int count;
    private int option;
    private String text;
}
