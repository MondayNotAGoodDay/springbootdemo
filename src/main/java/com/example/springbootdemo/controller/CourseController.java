package com.example.springbootdemo.controller;


import com.example.springbootdemo.entity.Course;
import com.example.springbootdemo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/get/{id}")
    public Course getCourse(@PathVariable("id") String id){
        return courseService.findById(id);
    }
}
