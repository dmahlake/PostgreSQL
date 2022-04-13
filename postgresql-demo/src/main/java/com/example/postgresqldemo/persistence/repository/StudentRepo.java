package com.example.postgresqldemo.persistence.repository;

import com.example.postgresqldemo.persistence.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {

}
