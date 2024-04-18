package com.t1.bookDrop.dto.reqDto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class SearchBookReqDto {
    private int page;
    private int option;
    private String text;
}
