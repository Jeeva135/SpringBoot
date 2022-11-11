package com.student.ust.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data
@Table(name="book_ust_details_mappedbytest")
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int bookId;
    private String bookName;
    private String authorName;
    private long isbn;
    private LocalDateTime dateBirth;
    private LocalDateTime modifiedDate;

    @ManyToOne
    @JoinColumn(name="student_id")
    Student student;
}
