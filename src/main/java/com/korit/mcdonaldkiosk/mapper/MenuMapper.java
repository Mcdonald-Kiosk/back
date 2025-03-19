package com.korit.mcdonaldkiosk.mapper;

import com.korit.mcdonaldkiosk.entity.Menu;
import com.korit.mcdonaldkiosk.entity.MenuPrice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

@Mapper
public interface MenuMapper {
    List<Menu> selectAllMenus();
    List<MenuPrice> getMenuPrices(int menuId);
    int insertMenu(Menu menu);
    int insertMenuPrices(@Param("menuId") int menuId, @Param("menuPrices") List<MenuPrice> menuPrices);
    int deleteMenuPrices(int menuId);
    int deleteMenu(int menuId);
}