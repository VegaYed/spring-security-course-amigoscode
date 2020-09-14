package com.example.springsecurityboostrap.student;

import lombok.Data;

@Data
public class Student {

    private final Integer id;
    private final String name;

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }


}
