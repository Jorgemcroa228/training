package com.football.training.dto.response;

import com.football.training.enums.UserRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserResponseDTO {
    
    private Long id_user;
    private String name;
    private String email;
    private String password;
    private UserRole role;
}
