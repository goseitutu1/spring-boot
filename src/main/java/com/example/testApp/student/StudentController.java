package com.example.testApp.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public String getStudentEmail(@PathVariable("studentID") Long studentID){
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

    @PostMapping(path = "date/{startDate}/{endDate}")
    public void getDates(@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate){
        studentService.getDates(startDate,endDate);
    }

    @PutMapping(path = "{studentID}")
    public void updateStudent(
            @PathVariable("studentID") Long studentID,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ){
        studentService.updateStudent(studentID,name,email);
    }
}
