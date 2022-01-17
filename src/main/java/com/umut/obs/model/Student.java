package com.umut.obs.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Student {
    @Id     // This is our table's primary key.
    @Column(unique = true)
    @SequenceGenerator(name = "studentIdSeq",sequenceName = "studentIdSeq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "studentIdSeq")
    private Long studentId;

    @Column(nullable = false ,length = 255) // We can use constraints like that.
    private String studentName;

    @Column(nullable = false , length = 255 , insertable = true , updatable = true)
    private String studentSurname;

    @Column(nullable = false)
    private Integer age;

    @Column
    private String advisor; // This gonna be teacher's name

    public Student(String studentName, String studentSurname, Integer age, String advisor) {
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.age = age;
        this.advisor = advisor;
    }
}
