package com.example.smsbackend.services;

import com.example.smsbackend.dtos.StudentDto;
import com.example.smsbackend.models.Student;
import com.example.smsbackend.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface StudentService {
    List<Student> getAllStudents();
    Student getOne(UUID id) throws Exception;
    Student createStudent(StudentDto dto);
    Student deleteStudent(UUID id);
}
