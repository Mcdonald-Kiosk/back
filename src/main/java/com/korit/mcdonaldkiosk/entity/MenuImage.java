package com.korit.mcdonaldkiosk.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuImage {
    private int menuImgUrlId;
    private int menuId;
    private String menuName;
    private String singleImg;
    private String setImg;
}
