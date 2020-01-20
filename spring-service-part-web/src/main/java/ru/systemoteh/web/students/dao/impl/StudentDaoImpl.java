package ru.systemoteh.web.students.dao.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import ru.systemoteh.web.students.bean.UserBean;
import ru.systemoteh.web.students.dao.StudentDao;
import ru.systemoteh.web.students.domain.Student;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Value("${rest.host}")
    private String restHost;
    @Value("${rest.students}")
    private String restStudents;
    @Value("${rest.search}")
    private String restSearch;
    @Resource(name = "userBean")
    UserBean userBean;
    private static final String HEADER_AUTH = "Authorization";
    private static final String TOKEN_PREFIX = "Bearer ";

    @Override
    public List<Student> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set(HEADER_AUTH, getToken());
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<Student[]> response = restTemplate
                .exchange(restHost + restStudents, HttpMethod.GET, request, Student[].class);

        return Arrays.asList(response.getBody());
    }

    @Override
    public void save(Student student) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set(HEADER_AUTH, getToken());
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Student> request = new HttpEntity<>(student, headers);
        ResponseEntity<Student> response = restTemplate
                .exchange(restHost + restStudents, HttpMethod.POST, request, Student.class);

        boolean isSuccessful = response.getStatusCode().is2xxSuccessful();
        if (!isSuccessful) {
            // todo: throw Exception and catch it on error page
        }
    }

    @Override
    public List<Student> findByQuery(String query) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set(HEADER_AUTH, getToken());
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("query", query);
        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<Student[]> response = restTemplate
                .exchange(restHost + restStudents + restSearch + query,
                        HttpMethod.GET, request, Student[].class);

        return Arrays.asList(response.getBody());
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    @Deprecated
    public Optional<Student> findById(Long id) {
        return Optional.empty();
    }

    private String getToken() {
        return TOKEN_PREFIX + userBean.getUser().getToken();
    }
}
