package com.t1.bookDrop.entity;

import com.t1.bookDrop.dto.respDto.AdminLoanRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminLoan {
    private int loanId;
    private int userId;
    private int bookStockId;
    private LocalDateTime loanDate;
    private LocalDateTime dueDate;
    private LocalDateTime returnDate;
    private int returnOrNot;

    private Book book;
    private User user;

    public AdminLoanRespDto toAdminLoanRespDto(){
        return AdminLoanRespDto.builder()
                .loanId(loanId)
                .bookStockId(bookStockId)
                .bookName(book.getBookName())
                .userName(user.getUsername())
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .address(user.getAddress())
                .coverImgUrl(book.getCoverImgUrl())
                .loanDate(loanDate)
                .dueDate(dueDate)
                .returnDate(returnDate)
                .returnOrNot(returnOrNot)
                .build();
    }
}
