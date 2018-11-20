package com.example.springbootdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;


@ApiModel(value = "student", description = "这是一个学生实体类ssss")
@Data
@Table(name = "stu_for_redis")
@Entity
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id" )
    @JsonIgnore
    private Long id;

    @ApiModelProperty(value = "姓名", required = true)
    @Column(name = "name" ,length = 40)
    private String name;

    @ApiModelProperty(value = "年龄")
    @Column(name = "age" ,length = 3)
    private int age;

    @ApiModelProperty(value = "性别")
    @Column(name = "sex" ,length = 4)
    private String sex;

}
