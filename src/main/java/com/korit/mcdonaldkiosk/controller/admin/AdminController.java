package com.korit.mcdonaldkiosk.controller.admin;

import com.korit.mcdonaldkiosk.entity.Menu;
import com.korit.mcdonaldkiosk.entity.MenuPrice;
import com.korit.mcdonaldkiosk.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

     // 모든 메뉴 조회
    @GetMapping("/menus")
    public ResponseEntity<?> getAllMenus() {
        return ResponseEntity.ok().body(adminService.getAllMenus());
    }


     // 특정 메뉴의 가격 정보 조회
     @GetMapping("/menus/{menuId}/prices")
    public ResponseEntity<?> getMenuPrices(@PathVariable int menuId) {
        return ResponseEntity.ok().body(adminService.getMenuPrices(menuId));
    }

    // 메뉴 추가 (가격 포함)
    @PostMapping("/menus")
    public void addMenu(@RequestBody Menu menu, @RequestParam List<MenuPrice> prices) {
        adminService.addMenu(menu, prices);
    }

    // 메뉴 삭제
    @DeleteMapping("/menus/{menuId}")
    public void deleteMenu(@PathVariable int menuId) {
        adminService.deleteMenu(menuId);
    }
}