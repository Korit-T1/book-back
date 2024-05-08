package com.t1.bookDrop.dto.respDto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class AdminLoanRespDto {
    private int loanId;
    private int bookStockId;
    private String bookName;
    private String userName;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String coverImgUrl;
    private LocalDateTime loanDate;
    private LocalDateTime dueDate;
    private LocalDateTime returnDate;
    private int returnOrNot;
}
