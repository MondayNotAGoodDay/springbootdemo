package com.example.springbootdemo.service;

import com.example.springbootdemo.entity.Student;
import com.example.springbootdemo.repository.StudentRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Log
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    /**
     * 更新或插入Student
     *
     * @param student
     * @return
     */
    public Student saveOrUpdateStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

    /**
     * 根据 id 获取 Student 对象
     * @param id Student's id
     * @return
     */
    public Student getStudentById(Long id) {
        Student student = studentRepository.findStuById(id);
        return student;
    }

    /**
     * 获取全部Student
     * @return student list
     */
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    /**
     * 根据 id 删除 Student 对象
     * @param id
     */
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

}
