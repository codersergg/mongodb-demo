package com.codersergg.demo_mongoDB.service;

import com.codersergg.demo_mongoDB.model.Student;
import com.codersergg.demo_mongoDB.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentService {

    private final StudentRepository repository;

    public List<Student> getAllStudents() {
        return repository.findAll();

    }

    public void getStudentById() {
    }
}
