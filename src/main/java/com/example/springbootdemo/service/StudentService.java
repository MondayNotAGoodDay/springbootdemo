package com.example.springbootdemo.service;

import com.example.springbootdemo.entity.Student;
import com.example.springbootdemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentService {
    @Autowired
    StudentRepository studentRepository;


    public void saveStudent(Student student){
        studentRepository.save(student);
    }
    public Student getStudentById(int id){
        Student student = studentRepository.findById(id).get();
        return student;
    }

    public List<Student> getAllStudent(){
        List<Student> stuList = studentRepository.findAll();
        return stuList;
    }

    public void deleteStudentById(int id){
        studentRepository.deleteById(id);
    }

    public void deleteStudent(Student student){
        studentRepository.delete(student);
    }

    public void deleteAllStudent(){
        studentRepository.deleteAll();
    }

    public void updateStudent(Student student){
        studentRepository.save(student);
    }

}
