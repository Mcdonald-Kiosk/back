package com.korit.mcdonaldkiosk.mapper;

import com.korit.mcdonaldkiosk.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    Admin selectByAdminName(String adminName);


    int insertAdmin(Admin admin);

}
