package com.t1.bookDrop.dto.respDto;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class GetBookStocksRespDto {
    private int bookStockId;
    private int loanStatus;
    private LocalDateTime dueDate;
}
