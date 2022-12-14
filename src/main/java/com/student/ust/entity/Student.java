package com.student.ust.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@Table(name="student_ustbatch_mappedbytest")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studId;

    private int rollNo;
    private String name;
    private int age;
    private LocalDateTime dateBirth;
    private LocalDateTime modifiedDate;


    @OneToMany(cascade = CascadeType.ALL,fetch =FetchType.LAZY,mappedBy = "student")
    private Set<Book> bookSet;



}
