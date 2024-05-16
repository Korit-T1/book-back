package com.t1.bookDrop.dto.reqDto;

import lombok.Data;

@Data
public class MostLoanedRespDto {
    private int count;
    private String categoryName;
    private String bookName;
    private String authorName;
    private String publisherName;
    private String url;
}
