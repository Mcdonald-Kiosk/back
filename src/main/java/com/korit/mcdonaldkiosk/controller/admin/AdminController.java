package com.korit.mcdonaldkiosk.controller.admin;

import com.korit.mcdonaldkiosk.dto.request.ReqAdminSignInDto;
import com.korit.mcdonaldkiosk.dto.request.ReqAdminSignUpDto;
import com.korit.mcdonaldkiosk.dto.response.RespTokenDto;
import com.korit.mcdonaldkiosk.service.admin.AdminSignInService;
import com.korit.mcdonaldkiosk.service.admin.AdminSignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminSignUpService adminSignUpService;

    @PostMapping("/join")
    public ResponseEntity<?> joinIn(@RequestBody ReqAdminSignUpDto reqAdminSignUpDto) {
        return ResponseEntity.ok().body(adminSignUpService.signUp(reqAdminSignUpDto));

    }

    @Autowired
    private AdminSignInService adminSignInService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody ReqAdminSignInDto dto) {

        RespTokenDto respTokenDto = RespTokenDto.builder()
                .type("JWT")
                .name("AccessToken")
                .token(adminSignInService.signIn(dto))
                .build();
        return ResponseEntity.ok().body(respTokenDto);
    }

}
