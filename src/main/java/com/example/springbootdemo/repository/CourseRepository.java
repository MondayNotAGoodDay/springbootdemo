package com.example.springbootdemo.repository;

import com.example.springbootdemo.entity.Course;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,String> {
    Course findCouById(String id);

}
