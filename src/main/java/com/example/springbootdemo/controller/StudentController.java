package com.example.springbootdemo.controller;

import com.example.springbootdemo.entity.Student;
import com.example.springbootdemo.service.StudentService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Log
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping(value = "/get/{id}")
    public Student getStudent(@PathVariable("id") int id, Model model){
        //调用service根据id获取student
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return student;
    }

    @GetMapping(value = "/delete/{id}")
    public void deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudentById(id);
    }

    @PostMapping(value = "/add")
    public String addAndUpdateStudent(@ModelAttribute("student") Student student,Model model){
        studentService.saveStudent(student);
        return "index";
    }

    @PostMapping(value = "/update")
    public void updateStudent(@RequestBody(required = false) Student student){
        studentService.updateStudent(student);
    }
}


