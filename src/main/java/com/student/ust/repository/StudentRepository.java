package com.student.ust.repository;

import com.student.ust.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends
        JpaRepository<Student,Integer> {
    List<Student> findByName(String name);

    List<Student> findByAge(int age);

    List<Student > findByNameStartingWith(String prefix);
    List<Student > findByNameEndingWith(String suffix);
}
