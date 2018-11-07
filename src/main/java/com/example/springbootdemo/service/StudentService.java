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

    /**
     * 更新或插入Student
     *
     * @param student
     * @return
     */
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(String id) {
        Student student = studentRepository.findStuById(id);
        return student;
    }

    public List<Student> getAllStudent() {
        List<Student> stuList = studentRepository.findAll();
        return stuList;
    }

    public void deleteStudentById(String id) {
        studentRepository.deleteById(id);
    }

    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }

    public void deleteAllStudent() {
        studentRepository.deleteAll();
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

}
