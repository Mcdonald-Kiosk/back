package com.korit.mcdonaldkiosk.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Menu {
    private int menuId;
    private String menuName;
    private String categoryId;
    private String categoryName;
    private String categoryNameKor;
    private String menuCount;
    private int menuPrice;
    private int menuCal;
    private String menuImg;
}
