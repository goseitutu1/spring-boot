package com.example.testApp.student;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
//@Table
public class Student {
    @javax.persistence.Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private int age;
    private LocalDate dob;
    private String email;

    public Student() {
    }

    public Student(String stuName, int stuAge, LocalDate stuDOB, String stuEmail, Long stuID){
        name = stuName;
        age = stuAge;
        dob = stuDOB;
        email = stuEmail;
        id = stuID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return "{name: "+ this.name + ", age: "+ this.age + ", email: " + this.email + ", dob: " + this.dob + "}";
    }
}
