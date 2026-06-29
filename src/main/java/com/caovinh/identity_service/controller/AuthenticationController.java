package com.caovinh.identity_service.controller;

import com.caovinh.identity_service.dto.request.AuthenticationRequest;
import com.caovinh.identity_service.dto.response.ApiResponse;
import com.caovinh.identity_service.dto.response.AuthenticationResponse;
import com.caovinh.identity_service.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/auth")
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/login")
    ApiResponse<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        boolean authenticated = authenticationService.authenticate(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .data(AuthenticationResponse.builder().authenticated(authenticated).build())
                .build();
    }
}
