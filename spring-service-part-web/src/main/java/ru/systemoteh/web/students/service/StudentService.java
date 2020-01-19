package ru.systemoteh.web.students.service;

import ru.systemoteh.web.students.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> findAll();

    void save(Student student);

    List<Student> findByQuery(String query);

    void deleteById(Long id);

    Optional<Student> findById(Long id);
}
