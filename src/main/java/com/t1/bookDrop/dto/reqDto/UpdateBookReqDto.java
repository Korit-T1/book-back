package com.t1.bookDrop.dto.reqDto;


import com.t1.bookDrop.entity.Book;
import lombok.Data;

//import java.util.Base64;

@Data
public class UpdateBookReqDto {
    private int bookId;
    private String isbn;
    private int categoryId;
    private String bookName;
    private String authorName;
    private String publisherName;
    private String coverImgUrl;
    private int bookTypeId; // 확인하기, 전체 순서도.

    public Book toEntity() {
        return Book.builder()
                .bookId(bookId)
                .isbn(isbn)
                .categoryId(categoryId)
                .bookName(bookName)
                .authorName(authorName)
                .publisherName(publisherName)
                .coverImgUrl(coverImgUrl)

                .build();
    }
}