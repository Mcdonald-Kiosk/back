package com.korit.mcdonaldkiosk.service.admin;

import com.korit.mcdonaldkiosk.entity.Menu;
import com.korit.mcdonaldkiosk.entity.MenuPrice;
import com.korit.mcdonaldkiosk.repository.admin.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    // ✅ 모든 메뉴 가져오기
    public List<Menu> getAllMenus() {
        return adminRepository.getAllMenus().orElse(List.of());  // 🔥 Optional 처리
    }

    // ✅ 특정 메뉴의 가격 정보 조회
    public List<MenuPrice> getMenuPrices(int menuId) {
        return adminRepository.getMenuPrices(menuId).orElse(List.of());  // 🔥 Optional 처리
    }

    // ✅ 메뉴 추가 (가격 정보 포함)
    @Transactional
    public boolean addMenu(Menu menu, List<MenuPrice> menuPrices) {
        return adminRepository.addMenu(menu, menuPrices).orElse(false);  // 🔥 Optional 처리
    }

    // ✅ 메뉴 삭제 (menu_tb & menu_price_tb)
    @Transactional
    public boolean deleteMenu(int menuId) {
        return adminRepository.deleteMenu(menuId).orElse(false);  // 🔥 Optional 처리
    }
}
