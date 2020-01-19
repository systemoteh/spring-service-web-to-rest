package ru.systemoteh.web.students.domain;

import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "users")
@EqualsAndHashCode(exclude = "users")
public class Role {
    private Long id;
    private String name;
    private Set<User> users;
}
