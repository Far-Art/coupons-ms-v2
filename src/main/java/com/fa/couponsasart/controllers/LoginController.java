package com.fa.couponsasart.controllers;

import com.fa.couponsasart.domain.beans.UserRole;
import com.fa.couponsasart.security.services.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.fa.couponsasart.configurations.ControllersConstants.BASE_APP_URL;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping(BASE_APP_URL)
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("signup/{email}")
    public ResponseEntity<HttpHeaders> signup(@PathVariable String email, @RequestHeader("password") String password, @RequestHeader(required = false, defaultValue = "CUSTOMER") UserRole role) {
        loginService.signup(email, password, role);
        return new ResponseEntity<>(NO_CONTENT);
    }

}
