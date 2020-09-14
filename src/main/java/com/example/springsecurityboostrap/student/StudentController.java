package com.example.springsecurityboostrap.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {


    private static final List<Student> STUDENT_LIST = Arrays.asList(
            new Student(1,"Osvaldo Leiva"),
            new Student(2,"Alonso Chaves"),
            new Student(3,"John Doe")
    );

    @GetMapping("{id}")
    public Student getStudent(@PathVariable Integer id){
        return STUDENT_LIST.stream()
                .filter(student -> id.equals(student.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Stundent " + id + " does not exists"));
    }

}
