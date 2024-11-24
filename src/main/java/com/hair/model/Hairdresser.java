package com.hair.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "hairdresser")
public class Hairdresser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

//    @Column(name = "login")
//    private String login;
//
//    @Column(name = "password")
//    private String password;


}
