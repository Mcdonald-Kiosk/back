package com.korit.mcdonaldkiosk.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OAuth2 {
    private int oAuth2Id;
    private int adminId;
    private String oAuth2Name;
    private String providerName;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
