package com.example.smsbackend.controllers;

import com.example.smsbackend.dtos.StudentDto;
import com.example.smsbackend.models.Student;
import com.example.smsbackend.serviceImpl.StudentServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/api/students")
public class StudentController {
    public final StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public List<Student> getAllStudent (){
        return studentService.getAllStudents();
    }
    @PostMapping("/create")
    public Student saveStudent(@RequestBody StudentDto dto) {
        return studentService.createStudent(dto);
    }
    @GetMapping("/:id")
    public Student getStudentById(@RequestParam UUID id) throws Exception {
        return studentService.getOne(id);
    }
    @PutMapping("/:id")
    public Student updateStudent(@RequestParam UUID id, @RequestBody StudentDto dto) throws Exception {
        return studentService.updateStudent(id, dto);
    }
    @DeleteMapping("/:id")
    public Student deleteStudent(@RequestParam UUID id) throws Exception {
        return studentService.deleteStudent(id);
    }
}
