package com.t1.bookDrop.dto.reqDto;


import com.t1.bookDrop.entity.Book;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegisterBookReqDto {
    private String isbn;
    private int categoryId;
    private String bookName;
    private String authorName;
    private String publisherName;
    private String coverImgUrl;


    public Book toEntity() {
        return Book.builder()
                .isbn(isbn)
                .categoryId(categoryId)
                .bookName(bookName)
                .authorName(authorName)
                .publisherName(publisherName)
                .coverImgUrl(coverImgUrl)
                .build();

    }



   /*
    private int bookId는 auto increment니까 따로 명시할 필요가 없는지?
    private String isbn;
    @Min(value = 1, message = "숫자만 입력 가능합니다.")

    private int categoryId;
    @Min(value = 1, message = "숫자만 입력 가능합니다.")

    private String bookName;
    @NotBlank(message = "책 이름은 빈 값일 수 없습니다.")

    private String authorName;
    @NotBlank(message = "저자는 빈 값일 수 없습니다.")

    private String publisherName;
    @NotBlank(message = "출판사는 빈 값일 수 없습니다.")

    private String coverImgUrl;
    @NotBlank(message = "이미지는 빈 값일 수 없습니다.")

    private LocalDateTime createDate;
    @NotBlank(message = "최초 등록 날짜를 기입해야 합니다.")

    private LocalDateTime updateDate;
    @NotBlank(message = "책에 대한 수정 날짜를 기입해야 합니다.")

    private LocalDateTime publishDate;
    @NotBlank(message = "책의 출판 날짜를 기입해야 합니다.")

    */


}