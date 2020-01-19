package ru.systemoteh.rest.students.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "users")
@EqualsAndHashCode(exclude = "users")
@Table(name = "roles")
public class Role {
    @Id
    @SequenceGenerator(name = "ROLE_ID_GENERATOR", sequenceName = "ROLES_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLE_ID_GENERATOR")
    @Column(unique = true, nullable = false)
    private Long id;
    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}
