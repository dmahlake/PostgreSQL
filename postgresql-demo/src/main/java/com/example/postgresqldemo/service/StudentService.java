package com.example.postgresqldemo.service;


import com.example.postgresqldemo.persistence.entity.Student;
import com.example.postgresqldemo.persistence.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo repo;

    public Student saveStudent(Student request)
    {
        Student student = new Student();
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setAge(request.getAge());
        student.setMark(request.getMark());

        return repo.save(student);
    }

    public List<Student> getStudents()
    {
        return repo.findAll();
    }

    public void deleteStudent(Long id)
    {
        repo.deleteById(id);
    }

    public Student getStudentById(Long id)
    {
        return repo.findById(id).orElseThrow(()->
                new RuntimeException("Student not found for id " + id));
    }
}
