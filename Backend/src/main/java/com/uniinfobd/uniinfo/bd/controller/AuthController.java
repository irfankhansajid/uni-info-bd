package com.uniinfobd.uniinfo.bd.controller;

import com.uniinfobd.uniinfo.bd.dto.AuthResponseDTO;
import com.uniinfobd.uniinfo.bd.dto.LoginRequestDTO;
import com.uniinfobd.uniinfo.bd.dto.RegisterRequestDTO;
import com.uniinfobd.uniinfo.bd.dto.UserResponseDTO;
import com.uniinfobd.uniinfo.bd.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Authentication", description = "Authentication management APIs")
public class AuthController {


    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Operation(summary = "Register a new user", description = "Create a new user account with STUDENT role")
    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> register(@Valid @RequestBody RegisterRequestDTO registerDTO) {
        return ResponseEntity.ok(authService.register(registerDTO));
    }


    @Operation(summary = "Login user", description = "Authenticate user and return JWT token")
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@Valid @RequestBody LoginRequestDTO loginDTO) {
        return ResponseEntity.ok(authService.login(loginDTO));
    }

    @Operation(summary = "Get current user", description = "Return information about the current authenticated user")
    @GetMapping("/me")
    public ResponseEntity<UserResponseDTO> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return ResponseEntity.ok(authService.getCurrentUser(userDetails.getUsername()));
    }
}