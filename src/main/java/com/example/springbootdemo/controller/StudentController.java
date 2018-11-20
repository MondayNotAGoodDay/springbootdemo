package com.example.springbootdemo.controller;

import com.example.springbootdemo.entity.Student;
import com.example.springbootdemo.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log
@RestController
@RequestMapping("/student")
@Api(value = "StudentController|学生控制器", description = "对学生进行增删改查", tags = "1.1")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ApiOperation(value = "根据id查询学生", notes = "该id数据库里为自增长")
    @GetMapping(value = "/get/{id}")
    public Student getStudent(@PathVariable("id") Long id, Model model) {
        //调用service根据id获取student
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        //System.out.println("--------" + student + "-------");
        return student;
    }

    @ApiOperation(value="获取全部学生")
    @GetMapping(value = "/get")
    public List<Student> getStudents(){
        return studentService.getAllStudent();
    }

    @ApiOperation(value = "根据id删除单个学生")
    @GetMapping(value = "/delete/{id}")
    public void deleteStudent(@PathVariable("id") @ModelAttribute("id") Long id) {
        studentService.deleteStudentById(id);
    }

    @ApiOperation(value = "增加或更新学生")
    @PostMapping(value = {"/add","/update"})
    public Student addAndUpdateStudent(@RequestBody Student student, Model model) {
        return studentService.saveOrUpdateStudent(student);
    }

}


