package com.uniinfobd.uniinfo.bd.dto;

import com.uniinfobd.uniinfo.bd.entity.Role;
import lombok.Data;

@Data
public class UserResponseDTO {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private Role role;
    private boolean active;
}
