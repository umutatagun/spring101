package com.umut.obs.service;

import com.umut.obs.model.Student;
import com.umut.obs.repository.StudentRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo){
        this.studentRepo = studentRepo;
    }

    public List<Student> getStudents(){
        return studentRepo.findAll();
    }

    public ResponseEntity<Student> addStudent(Student s1){
        studentRepo.save(s1);
        return ResponseEntity.ok(s1);

    }

    public String deleteStudent(Long id){
        if(!studentRepo.findById(id).isEmpty()){
            studentRepo.deleteById(id);
            return id+" Id'li kayit basariyla silindi";
        }
        else{
            return id+" Id'li kayit bulunamadi";
        }
    }

}
