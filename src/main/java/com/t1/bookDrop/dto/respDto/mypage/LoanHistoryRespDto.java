package com.t1.bookDrop.dto.respDto.mypage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
public class LoanHistoryRespDto {
    private int loanId;
    private int bookStockId;
    private String bookName;
    private String authorName;
    private String publisherName;
    private String imageUrl;
    private LocalDateTime loanDate;
    private LocalDateTime dueDate;
    private LocalDateTime returnDate;
}
