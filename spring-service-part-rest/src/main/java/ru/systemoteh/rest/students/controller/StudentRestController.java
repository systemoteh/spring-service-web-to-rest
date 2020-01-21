package ru.systemoteh.rest.students.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.systemoteh.rest.students.domain.Student;
import ru.systemoteh.rest.students.service.StudentService;

import java.util.List;
import java.util.Optional;

import static ru.systemoteh.rest.students.util.Constants.ADMIN_AUTHORITY;


@RestController
@RequestMapping("/api/students")
public class StudentRestController {

    @Autowired
    StudentService studentService;

    @GetMapping(value = "")
    public ResponseEntity<List<Student>> findAll() {
        List<Student> students = studentService.findAll();
        if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<List<Student>> findByQuery(@RequestParam(value = "query") String query) {
        if (query == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<Student> students = studentService.findByQuery(query);

        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping(value = "")
    @PreAuthorize(ADMIN_AUTHORITY)
    public ResponseEntity<Student> add(@RequestBody Student student) {
        HttpHeaders headers = new HttpHeaders();
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        studentService.save(student);
        return new ResponseEntity<>(student, headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "")
    @PreAuthorize(ADMIN_AUTHORITY)
    public ResponseEntity<Student> update(@RequestBody Student student) {
        HttpHeaders headers = new HttpHeaders();
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        studentService.save(student);
        return new ResponseEntity<>(student, headers, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}")
    @PreAuthorize(ADMIN_AUTHORITY)
    public ResponseEntity<Student> deleteCustomer(@PathVariable("id") Long id) {
        Optional<Student> student = studentService.findById(id);
        if (!student.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        studentService.deleteById(id);
        return new ResponseEntity<>(student.get(), HttpStatus.OK);
    }
}