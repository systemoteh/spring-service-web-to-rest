package ru.systemoteh.web.students.dao;

import ru.systemoteh.web.students.domain.User;

public interface UserDao {

    User findByUsername(String username);
}
