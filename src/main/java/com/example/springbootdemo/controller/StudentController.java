package com.example.springbootdemo.controller;

import com.example.springbootdemo.entity.Student;
import com.example.springbootdemo.service.StudentService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log
@Controller
@RequestMapping("/stu")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping(value = "/get/{id}")
    public String getStudent(@PathVariable("id") int id, Model model){
        //调用service根据id获取student
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "add";
    }

    @GetMapping(value = "/getAll")
    public String getStudents(Model model) {
        List<Student> students = studentService.getAllStudent();
        //有数据才把students传给页面
        if(students.size()>0) {
            model.addAttribute("students", students);
        }
        return "index";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudentById(id);
        return "redirect:/stu/getAll";
    }

    @PostMapping(value = "/add")
    public String addStudent(Student student,Model model){
        studentService.saveStudent(student);
        //把学生列表传给index作显示
        model.addAttribute("students", studentService.getAllStudent());
        return "redirect:/stu/getAll";
    }

    @GetMapping(value = "/add")
    public String addStudent(Model model){
        model.addAttribute("student", new Student());
        model.addAttribute("action", "add");
        return "student/studentForm";
    }

    @GetMapping(value = "/update/{id}")
    public String updateStudentForm(@PathVariable("id") int id, Model model){
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        model.addAttribute("action", "update");
        return "student/studentForm";
    }

    @PostMapping(value = "/update")
    public String updateStudent(@ModelAttribute Student student, Model model){
        studentService.updateStudent(student);


        return "redirect:/stu/getAll";
    }

}


