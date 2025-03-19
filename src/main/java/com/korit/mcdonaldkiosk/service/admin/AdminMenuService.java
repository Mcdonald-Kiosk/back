package com.korit.mcdonaldkiosk.service.admin;

import com.korit.mcdonaldkiosk.dto.request.ReqMenuListDto;
import com.korit.mcdonaldkiosk.entity.Menu;
import com.korit.mcdonaldkiosk.repository.admin.AdminMenuRepository;
import com.korit.mcdonaldkiosk.repository.user.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminMenuService {

    @Autowired
    private AdminMenuRepository adminMenuRepository;

    // 모든 카테고리를 조회하는 메서드
    public List<Menu> getAllCategories() {
        return adminMenuRepository.findAllCategories();
    }
//    public List<String> getAllCategories() {
//        List<Menu> allCategories = adminMenuRepository.findAllCategories();
//        //객체에서 카테고리 값만 빼온다.
//        List<String> categories = allCategories.stream()
//                .map(Menu::getMenuCategory)
//                .collect(Collectors.toList());
//        return categories;
//    }

    // 모든 메뉴를 조회하는 메서드
    public List<Menu> getAllAdminMenuList() {
        return adminMenuRepository.findAllAdminMenus();
    }

    // 메뉴 갯수를 페이지에 할당하는 메서드
    public int getMenuListCountByCategory(String searchCategory) {
        return adminMenuRepository.findMenuCountAllBySearchCategory(searchCategory);
    }

    public List<Menu> getMenuListSearchByCategory(ReqMenuListDto reqMenuListDto) {
      int startIndex = (reqMenuListDto.getPage() - 1) * reqMenuListDto.getLimitCount();
      return adminMenuRepository.findMenuListByCategory(
              startIndex,
              reqMenuListDto.getLimitCount(),
              reqMenuListDto.getCategory()
      );
    }

}
