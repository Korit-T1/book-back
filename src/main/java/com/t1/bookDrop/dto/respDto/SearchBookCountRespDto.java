package com.t1.bookDrop.dto.respDto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SearchBookCountRespDto {
    private int totalCount;
}
