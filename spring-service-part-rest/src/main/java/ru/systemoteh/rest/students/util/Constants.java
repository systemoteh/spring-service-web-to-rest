package ru.systemoteh.rest.students.util;

public class Constants {
    public static final String USER_ROLE = "USER_ROLE";
    public static final String ADMIN_ROLE = "ADMIN_ROLE";
    public static final String[] USER_ADMIN_ROLE = {"USER_ROLE", "ADMIN_ROLE"};
    public static final String[] ANONYMOUS_ENDPOINTS = {"/auth/login"};
    public static final String[] USER_ADMIN_ENDPOINTS = {"/api/students", "/api/students/search"};
    public static final String[] ADMIN_ENDPOINTS = {"/api/students/**"};
}
