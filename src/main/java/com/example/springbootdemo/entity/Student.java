package com.example.springbootdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;


@ApiModel(value = "student", description = "这是一个学生实体类ssss")
@Data
@Table(name = "stu")
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Sno")
    private String id;

    @ApiModelProperty(value = "姓名", required = true)
    @Column(name = "Sname" ,length = 40)
    private String name;

    @ApiModelProperty(value = "年龄")
    @Column(name = "Sage" ,length = 3)
    private int age;

    @ApiModelProperty(value = "性别")
    @Column(name = "Ssex" ,length = 4)
    private String sex;


    //@ApiModelProperty(value = "学生所选课程")
    //@OneToOne(optional = false)
    //@JoinColumn(name = "Cno")
    //Course course;

    @ApiModelProperty(value = "学生所选课程")
    @ManyToOne(optional = false)
    @JoinColumn(name = "Cno")
    Course course;
}
