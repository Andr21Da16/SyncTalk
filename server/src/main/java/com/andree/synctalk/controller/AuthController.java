package com.andree.synctalk.controller;

import com.andree.synctalk.dto.Response;
import com.andree.synctalk.dto.request.auth.RegisterRequest;
import com.andree.synctalk.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<Response<Void>> signUp(@RequestBody RegisterRequest register) {
        Response<Void> response = authService.registerUser(register);
        return ResponseEntity.ok(response);
    }

}
