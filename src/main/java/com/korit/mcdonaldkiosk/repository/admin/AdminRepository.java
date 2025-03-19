package com.korit.mcdonaldkiosk.repository.admin;

import com.korit.mcdonaldkiosk.entity.Admin;
import com.korit.mcdonaldkiosk.entity.Menu;
import com.korit.mcdonaldkiosk.entity.MenuPrice;
import com.korit.mcdonaldkiosk.entity.OAuth2;
import com.korit.mcdonaldkiosk.mapper.AdminMapper;
import com.korit.mcdonaldkiosk.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepository {


    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private MenuMapper menuMapper;

    public Optional<Admin> findAdminByAdminName(String adminName) {
        return Optional.ofNullable(adminMapper.selectByAdminName(adminName));
    }

    public Optional<Admin> save(Admin admin) {
        try {
            adminMapper.insertAdmin(admin);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
        return Optional.of(admin);
    }

    public Optional<Admin> findAdminById(int adminId) {
        return Optional.ofNullable(adminMapper.selectByAdminId(adminId));
    }

    public Optional<OAuth2> saveOAuth2(OAuth2 oAuth2) {
        try {
            adminMapper.saveOAuth2(oAuth2);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
        return Optional.of(oAuth2);
    }

    // 전체 메뉴 조회
    public Optional<List<Menu>> getAllMenus() {
        List<Menu> foundMenus = menuMapper.selectAllMenus();
        return foundMenus.isEmpty() ? Optional.empty() : Optional.of(foundMenus);
    }

    // 특정 메뉴 가격 조회
    public Optional<List<MenuPrice>> getMenuPrices(int menuId) {
        List<MenuPrice> foundMenuPrice = menuMapper.getMenuPrices(menuId);
        return foundMenuPrice.isEmpty() ? Optional.empty() : Optional.of(foundMenuPrice);
    }

    public Optional<Boolean> addMenu(Menu menu, List<MenuPrice> menuPrices) {
        try {
            // 1. 메뉴 데이터 추가 (menu_tb)
            menuMapper.insertMenu(menu);

            // 2. 가격 데이터 추가 (menu_price_tb)
            if (!menuPrices.isEmpty()) {
                menuMapper.insertMenuPrices(menu.getMenuId(), menuPrices);
            }

            return Optional.of(true);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.of(false);
        }
    }

    public Optional<Boolean> deleteMenu(int menuId) {
        try {
            // 1. 가격 정보 삭제 (menu_price_tb) - menu_id 외래키 참조로 인해 먼저 삭제 필요
            menuMapper.deleteMenuPrices(menuId);

            // 2. 메뉴 정보 삭제 (menu_tb)
            int deletedRows = menuMapper.deleteMenu(menuId);

            // 삭제된 행이 없으면 false 반환
            if (deletedRows == 0) {
                return Optional.of(false);
            }

            return Optional.of(true); // ✅ 성공 시 true 반환
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.of(false); // ❌ 실패 시 false 반환
        }
    }
}
