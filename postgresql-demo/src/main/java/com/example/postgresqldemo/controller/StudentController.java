package com.example.postgresqldemo.controller;

import com.example.postgresqldemo.persistence.entity.Student;
import com.example.postgresqldemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class StudentController {

    @Autowired
    StudentService service;

    @PostMapping("/add")
    public ResponseEntity<?>student(@RequestBody Student student)
    {
        return ResponseEntity.ok(service.saveStudent(student));
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<?>getStudent(@PathVariable Long id)
    {
        return ResponseEntity.ok(service.getStudentById(id));
    }

    @GetMapping("/student")
    public ResponseEntity<?> AllStudents()
    {
        return ResponseEntity.ok(service.getStudents());
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable Long id)
    {
        service.deleteStudent(id);
    }
}
