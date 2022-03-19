package com.example.testApp.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping(path = "/email/{studentID}")
    public Optional<String> getStudentEmail(@PathVariable("studentID") Long studentID){
        return studentService.getStudentEmail(studentID);
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    public void registerStudent(@RequestBody Student student){
        studentService.storeStudent(student);
    }

    @GetMapping(path = "{studentID}")
    public Optional<Student> getStudentByID(@PathVariable("studentID") Long studentID){
        return studentService.getStudent(studentID);
    }

    @DeleteMapping(path = "{studentID}")
    public void deleteStudent(@PathVariable("studentID") Long studentID){
        studentService.deleteStudent(studentID);
    }
}
