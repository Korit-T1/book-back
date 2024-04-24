package com.t1.bookDrop.dto.reqDto;

import lombok.Data;

@Data
public class UpdateProfileImageReqDto {
    private int userid;
    private String imageUrl;
}
