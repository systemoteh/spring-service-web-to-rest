package ru.systemoteh.web.students.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;
import ru.systemoteh.web.students.bean.UserBean;

@Configuration
public class BeanConfig {

    @Bean
    @SessionScope
    public UserBean userBean() {
        return new UserBean();
    }

}
