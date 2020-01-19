package ru.systemoteh.web.students.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.systemoteh.web.students.dao.StudentDao;
import ru.systemoteh.web.students.domain.Student;
import ru.systemoteh.web.students.service.StudentService;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDao studentDao;

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public void save(Student student) {
        studentDao.save(student);
    }

    @Override
    public List<Student> findByQuery(String query) {
        return studentDao.findByQuery(query);
    }

    @Override
    public void deleteById(Long id) {
        studentDao.deleteById(id);
    }

    @Override
    @Deprecated
    public Optional<Student> findById(Long id) {
        return studentDao.findById(id);
    }
}
