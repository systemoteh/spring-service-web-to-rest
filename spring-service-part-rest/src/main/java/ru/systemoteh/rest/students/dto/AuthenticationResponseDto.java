package ru.systemoteh.rest.students.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponseDto {
    private String username;
    private String password;
    private String token;
    private Set<String> roles;
}
