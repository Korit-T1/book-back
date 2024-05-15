package com.t1.bookDrop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminBook {
    private int bookId;
    private String isbn;
    private int categoryId;
    private String bookName;
    private String authorName;
    private String publisherName;
    private String coverImgUrl;

    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private LocalDate publishDate;

    private Category category;

}
