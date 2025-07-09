package com.uniinfobd.uniinfo.bd.service;

import com.uniinfobd.uniinfo.bd.dto.AuthResponseDTO;
import com.uniinfobd.uniinfo.bd.dto.LoginRequestDTO;
import com.uniinfobd.uniinfo.bd.dto.RegisterRequestDTO;
import com.uniinfobd.uniinfo.bd.dto.UserResponseDTO;
import com.uniinfobd.uniinfo.bd.entity.Role;
import com.uniinfobd.uniinfo.bd.entity.User;
import com.uniinfobd.uniinfo.bd.exception.ResourceNotFoundException;
import com.uniinfobd.uniinfo.bd.repository.UserRepository;
import com.uniinfobd.uniinfo.bd.security.CustomUserDetails;
import com.uniinfobd.uniinfo.bd.security.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;


    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    public AuthResponseDTO register(RegisterRequestDTO registerDTO) {

        if (userRepository.existsByEmail(registerDTO.getEmail())){
            throw new IllegalArgumentException("Email is already taken");
        }
        if (registerDTO.getPassword() == null || registerDTO.getPassword().trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }

        User user = new User();
        user.setEmail(registerDTO.getEmail());

        String encodedPassword = passwordEncoder.encode(registerDTO.getPassword());
        if (encodedPassword == null || encodedPassword.trim().isEmpty()) {
            throw new RuntimeException("Failed to encode password");
        }
        user.setPassword(encodedPassword);

        user.setFirstName(registerDTO.getFirstName());
        user.setLastName(registerDTO.getLastName());
        user.setRole(Role.STUDENT); // default role
        user.setActive(true);

        User savedUser = userRepository.save(user);

        CustomUserDetails userDetails = new CustomUserDetails(savedUser);
        String token = jwtUtil.generateToken(userDetails);

        // return response with token and info

        return AuthResponseDTO.builder()
                .email(savedUser.getEmail())
                .firstName(savedUser.getFirstName())
                .lastName(savedUser.getLastName())
                .role(savedUser.getRole())
                .build();


    }

    public AuthResponseDTO login(LoginRequestDTO loginDTO) {
        // Authenticate with Spring Security
        try {


            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDTO.getEmail(),
                            loginDTO.getPassword()
                    )
            );

            // Set authentication in security context
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Get user details
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

            // Generate JWT token
            String token = jwtUtil.generateToken(userDetails);

            // Return response
            return AuthResponseDTO.builder()
                    .token(token)
                    .email(userDetails.getUsername())
                    .firstName(userDetails.getFirstName())
                    .lastName(userDetails.getLastName())
                    .role(userDetails.getRole())
                    .build();
        } catch (UsernameNotFoundException e) {
            throw new RuntimeException("User not found: " + e.getMessage());
        } catch (BadCredentialsException e) {
            throw new RuntimeException("Invalid password");
        } catch (Exception e) {
            throw new RuntimeException("Authentication failed: " + e.getMessage());
        }

    }


    public UserResponseDTO getCurrentUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User", "email", email));

        UserResponseDTO response = new UserResponseDTO();
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setRole(user.getRole());
        response.setActive(user.isActive());

        return response;
    }
}
