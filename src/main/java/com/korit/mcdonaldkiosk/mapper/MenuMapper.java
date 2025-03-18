package com.korit.mcdonaldkiosk.mapper;

import com.korit.mcdonaldkiosk.entity.Menu;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface MenuMapper {
    List<Menu> selectAllMenus();
    int insertMenu(Menu menu);
}