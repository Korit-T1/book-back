package com.t1.bookDrop.entity;

import com.t1.bookDrop.dto.reqDto.MostLoanedRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MostLoanedBook {
    private int count;
    private String categoryName;
    private String bookName;
    private String authorName;
    private String publisherName;
    private String url;
}
