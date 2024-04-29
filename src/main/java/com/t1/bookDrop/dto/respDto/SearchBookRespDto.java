package com.t1.bookDrop.dto.respDto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

//import java.time.LocalDateTime;

@Data
@Builder
public class SearchBookRespDto {
    private int bookId;
    private String isbn;
    private int categoryId;
    private String categoryName;
    private String bookName;
    private String authorName;
    private String publisherName;
    private String coverImgUrl; 
    private LocalDateTime publishDate;

}
