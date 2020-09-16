package com.example.springsecurityboostrap.student;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {

    private static final List<Student> STUDENT_LIST = Arrays.asList(
            new Student(1,"Osvaldo Leiva"),
            new Student(2,"Alonso Chaves"),
            new Student(3,"John Doe")
    );

    @GetMapping
    public List<Student> getAll(){
        return STUDENT_LIST;
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return student;
    }

    @DeleteMapping("{id}")
    public Integer deleteStudent(@PathVariable Integer id){
        return id;
    }

    @PutMapping("{id}")
    public Student updateStudent(@PathVariable Integer id, @RequestBody Student student){
        return student;
    }

    @GetMapping("{id}")
    public Student getStudent(@PathVariable Integer id){
        return STUDENT_LIST.stream()
                .filter(student -> id.equals(student.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Stundent " + id + " does not exists"));
    }

}
