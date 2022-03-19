package com.example.testApp.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query("SELECT s FROM Student s WHERE s.email=?1")
    Optional<Student> studentEmailChecker(String email);

    @Query("SELECT s FROM Student s WHERE s.id=?1")
    Optional<Student> getStudentBYID(Long studentID);

    @Query("SELECT s.email FROM Student s WHERE s.id=?1")
    Optional<String> getStudentEmail(Long studentID);


}

