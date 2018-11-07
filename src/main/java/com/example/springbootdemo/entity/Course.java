package com.example.springbootdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.*;
import java.util.Set;

@Data
@ApiModel(value = "course" ,description = "课程信息")
@Entity
@Table(name = "cou")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Cno" , length = 4)
    private String id;

    @ApiModelProperty(value = "课程名字")
    @Column(name = "Cname" , length = 40)
    private String name;

    @ApiModelProperty(value = "课程学分")
    @Column(name = "Ccredit" )
    private int credit;

    //@OneToOne(mappedBy = "course")
    //@JsonIgnore
    //@Transient
    //private Student student;

    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private Set<Student> students;

}
