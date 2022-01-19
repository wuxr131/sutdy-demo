package cn.wuxr.h2db.controller;

import cn.wuxr.h2db.entity.Student;
import cn.wuxr.h2db.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> test(){
        return studentService.findAll();
    }
}
