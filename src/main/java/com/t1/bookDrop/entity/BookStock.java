package com.t1.bookDrop.entity;

import com.t1.bookDrop.dto.respDto.GetBookStocksRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookStock {
    private int bookStockId;
    private int bookId;
    private Loan loan;
    private int loanStatus;
    private LocalDateTime dueDate;

    public GetBookStocksRespDto toDto() {
        return GetBookStocksRespDto.builder()
                .bookStockId(bookStockId)
                .loanStatus(loanStatus)
                .dueDate(dueDate)
                .build();
    }
}
