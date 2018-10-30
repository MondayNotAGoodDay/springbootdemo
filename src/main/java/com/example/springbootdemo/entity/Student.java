package com.example.springbootdemo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;


@Setter
@Getter
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int age;
    private String sex;

    public Student() {
    }

    public Student(int id, String name, int age, String sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString(){
        return "Student" + "{id:" + id +
                           ",name:" + name +
                            ",age:" + age +
                            ",sex:" + sex + "}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, sex);
        //return 7 * name.hashCode()
        //        + 11 * Integer.valueOf(age).hashCode()
        //        + 13 * sex.hashCode()
        //        + 17 * Integer.valueOf(id).hashCode();
        //return Objects.hashCode(name) + Objects.hashCode(age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Student student = (Student) obj;
        return Objects.equals(this.name, student.name) &&
                this.age == student.age &&
                this.sex == student.sex;
    }
}
