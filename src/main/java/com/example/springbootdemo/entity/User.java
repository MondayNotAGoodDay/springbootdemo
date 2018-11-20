package com.example.springbootdemo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_for_jwt")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    long id;

    @Column(nullable = false, length = 20, unique = true)
    String username;

    @Column(nullable = false, length = 18)
    String password;
}
