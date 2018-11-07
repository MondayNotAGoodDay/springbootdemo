package com.example.springbootdemo.service;

import com.example.springbootdemo.entity.Course;
import com.example.springbootdemo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course findById(String id) {
        return courseRepository.findCouById(id);
    }
}
