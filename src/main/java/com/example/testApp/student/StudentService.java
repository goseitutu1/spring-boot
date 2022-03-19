package com.example.testApp.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void storeStudent(Student student) {
        Optional<Student> foundStudentEmail = studentRepository.studentEmailChecker(student.getEmail());
        if (foundStudentEmail.isPresent()){
            throw new IllegalStateException("student email \""+ student.getEmail() +"\"  already exits");
        }
        else {
            studentRepository.save(student);
        }
    }

    public Optional<Student> getStudent(Long studentID){
        Optional<Student> student = studentRepository.getStudentBYID(studentID);
        if (student.isPresent())
            return student;
        else
            throw new IllegalStateException("No record found");
    }

    public void deleteStudent(Long studentID){
        boolean studentExits = studentRepository.existsById(studentID);
        if (studentExits)
            studentRepository.deleteById(studentID);
        else
            throw new IllegalStateException("Student with ID " + studentID + " does not exits");
    }

    public Optional<String> getStudentEmail(Long studentID) {

        boolean studentExits = studentRepository.existsById(studentID);
        if (studentExits){
            return studentRepository.getStudentEmail(studentID);
        }
        else
            throw new IllegalStateException("Student with ID " + studentID + " does not exits");
    }
}

