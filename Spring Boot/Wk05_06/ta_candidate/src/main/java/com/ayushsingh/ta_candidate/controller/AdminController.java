package com.ayushsingh.ta_candidate.controller;

import com.ayushsingh.ta_candidate.config.security.util.JwtUtil;
import com.ayushsingh.ta_candidate.constants.AppConstants;
import com.ayushsingh.ta_candidate.model.dto.authDtos.LoginResponseDto;
import com.ayushsingh.ta_candidate.util.exceptionUtil.ApiException;
import com.ayushsingh.ta_candidate.util.responseUtil.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponseDto>> login() {
        if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
            String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String accessToken = JwtUtil.generateToken(username, AppConstants.ENTITY_TYPE_ADMIN);
            LoginResponseDto loginResponseDto = new LoginResponseDto();
            loginResponseDto.setAccessToken(accessToken);
            loginResponseDto.setUsername(username);
            return new ResponseEntity<>(new ApiResponse<>(loginResponseDto), HttpStatus.OK);

        }
        throw new ApiException("User authentication failed!");
    }

}
