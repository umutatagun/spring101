package com.umut.obs.service;

import com.umut.obs.model.Teacher;
import com.umut.obs.repository.TeacherRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepo teacherRepo;

    public TeacherService(TeacherRepo teacherRepo){
        this.teacherRepo = teacherRepo;
    }

    public List<Teacher> getTeachers(){
        return teacherRepo.findAll();
    }

    public ResponseEntity<Teacher> addTeacher(Teacher t1){
        teacherRepo.save(t1);
        return ResponseEntity.ok(t1);
    }

    public String deleteTeacher(Long id){
        if(!teacherRepo.findById(id).isEmpty()){
            teacherRepo.deleteById(id);
            return id+" numarali kayit silindi";
        }else{
            return id+" numarali kayit bulunamadi";
        }
    }
}
