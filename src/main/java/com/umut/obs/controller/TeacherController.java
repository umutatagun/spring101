package com.umut.obs.controller;

import com.umut.obs.model.Teacher;
import com.umut.obs.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<Teacher> getTeachers(){
        return teacherService.getTeachers();
    }

    @PostMapping("/add")
    public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher t1){
        return teacherService.addTeacher(t1);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTeacher(Long id){
        return teacherService.deleteTeacher(id);
    }
}
