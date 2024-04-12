package com.t1.bookDrop.entity;

import com.t1.bookDrop.security.PrincipalUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Admin {
    private int adminId;
    private String username;
    private String password;

    public PrincipalUser toPrincipalAdmin() {
        return PrincipalUser.builder()
                .userId(adminId)
                .username(username)
                .build();
    }
}
