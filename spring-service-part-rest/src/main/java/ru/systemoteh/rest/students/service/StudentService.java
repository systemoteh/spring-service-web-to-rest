package ru.systemoteh.rest.students.service;

import ru.systemoteh.rest.students.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> findAll();

    void deleteById(Long id);

    void save(Student student);

    List<Student> findByQuery(String query);

    Optional<Student> findById(Long id);
}
