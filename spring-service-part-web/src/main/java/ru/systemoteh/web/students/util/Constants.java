package ru.systemoteh.web.students.util;

public class Constants {
    public static final String USER_ROLE = "USER_ROLE";
    public static final String ADMIN_ROLE = "ADMIN_ROLE";
    public static final String[] USER_ADMIN_ROLE = {"USER_ROLE", "ADMIN_ROLE"};
    public static final String[] ANONYMOUS_ENDPOINTS = {"/login", "/auth/login"};
    public static final String[] USER_ADMIN_ENDPOINTS = {"/students", "/students/search", "/api/students", "/api/students/search"};
    public static final String[] ADMIN_ENDPOINTS = {"/students/**", "/api/students/**"};
}
