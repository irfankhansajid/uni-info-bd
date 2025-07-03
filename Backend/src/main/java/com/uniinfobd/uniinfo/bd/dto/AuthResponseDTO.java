package com.uniinfobd.uniinfo.bd.dto;

import com.uniinfobd.uniinfo.bd.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponseDTO {
    private String token;
    private String email;
    private String firstName;
    private String lastName;
    private Role role;
}
