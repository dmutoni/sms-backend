package com.example.smsbackend.serviceImpl;

import com.example.smsbackend.dtos.StudentDto;
import com.example.smsbackend.models.Student;
import com.example.smsbackend.repositories.StudentRepository;
import com.example.smsbackend.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {
    public final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getOne(UUID id) throws Exception {
        return studentRepository.findById(id).orElseThrow(() -> new Exception("User not found"));
    }

    @Override
    public Student createStudent(StudentDto dto) {
        Student student = new Student();
        student.setAge(dto.getAge());
        student.setGender(dto.getGender());
        student.setName(dto.getName());
        Student saved = studentRepository.save(student);
        return saved;
    }

    @Override
    public Student deleteStudent(UUID id) {
        return null;
    }
}
