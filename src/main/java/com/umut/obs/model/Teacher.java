package com.umut.obs.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Teacher {
    @Id
    @Column(unique = true)
    @SequenceGenerator(name = "teacherIdSeq",sequenceName = "teacherIdSeq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "teacherIdSeq")
    private Long teacherId;

    @Column(length = 255 , nullable = false)
    private String teacherName;

    @Column(nullable = false)
    private String teacherSurname;

    @Column
    private Integer age;

    public Teacher(String teacherName, String teacherSurname, Integer age) {
        this.teacherName = teacherName;
        this.teacherSurname = teacherSurname;
        this.age = age;
    }
}
