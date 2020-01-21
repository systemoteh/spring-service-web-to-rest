package ru.systemoteh.web.students.bean;

import lombok.Data;

import static ru.systemoteh.web.students.util.Constants.EMPTY_STRING;

@Data
public class SessionToken {
    private String token = EMPTY_STRING;
}
