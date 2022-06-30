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
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(UUID id, StudentDto dto) throws Exception {
        Student existingStudent = this.getOne(id);
        existingStudent.setName(dto.getName());
        existingStudent.setAge(dto.getAge());
        existingStudent.setGender(dto.getGender());
        return studentRepository.save(existingStudent);
    }


    @Override
    public Student deleteStudent(UUID id) throws Exception {
        Student existingStudent = this.getOne(id);
        studentRepository.deleteById(id);
        return existingStudent;
    }
}
