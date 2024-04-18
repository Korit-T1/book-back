package com.t1.bookDrop.dto.reqDto;

import lombok.Data;

@Data
public class OAuth2MergeReqDto {
    private String username;
    private String password;
    private String oauth2Name;
    private String providerName;
}
