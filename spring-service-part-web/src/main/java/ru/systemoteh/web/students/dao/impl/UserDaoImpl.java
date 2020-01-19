package ru.systemoteh.web.students.dao.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import ru.systemoteh.web.students.bean.UserBean;
import ru.systemoteh.web.students.dao.UserDao;
import ru.systemoteh.web.students.domain.User;

import javax.annotation.Resource;

@Repository
public class UserDaoImpl implements UserDao {

    @Value("${rest.host}")
    private String restHost;
    @Value("${rest.login}")
    private String restLogin;
    @Resource(name = "userBean")
    UserBean userBean;

    @Override
    public User findByUsername(String username) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<User> request = new HttpEntity<>(new User(username));
        ResponseEntity<User> response = restTemplate
                .exchange(restHost + restLogin, HttpMethod.POST, request, User.class);
        User user = response.getBody();
        userBean.setUser(user);
        return user;
    }
}
