package ru.systemoteh.web.students.domain;

import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "roles")
@EqualsAndHashCode(exclude = "roles")
public class User {
    private String username;
    private String password;
    private String token;
    private Set<String> roles;

    public User(String username) {
        this.username = username;
    }
}
