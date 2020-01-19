package ru.systemoteh.web.students.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.systemoteh.web.students.domain.Student;
import ru.systemoteh.web.students.service.StudentService;

@Controller
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping(value = "")
    public String findAll(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "students";
    }

    @GetMapping(value = "/search")
    public String findByQuery(@RequestParam(value = "query", required = false) String query, Model model) {
        model.addAttribute("students", studentService.findByQuery(query));
        model.addAttribute("query", query);
        return "students";
    }

    @PostMapping(value = "/save")
    public String add(@ModelAttribute("student") Student student) {
        studentService.save(student);
        return "redirect:/students";
    }

    @PostMapping(value = "/edit")
    public String update(@ModelAttribute("student") Student student, Model model) {
        model.addAttribute("student", student);
        return "studentDetail";
    }

    @PostMapping(value = "/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
        return "redirect:/students";
    }
}
