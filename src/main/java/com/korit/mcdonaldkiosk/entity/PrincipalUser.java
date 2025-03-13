package com.korit.mcdonaldkiosk.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PrincipalUser {
    private int userId;
    private String username;
    private String tradeName;
    private String email;
    private String imgUrl;
}
