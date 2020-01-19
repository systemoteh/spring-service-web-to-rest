package ru.systemoteh.rest.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.systemoteh.rest.students.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
