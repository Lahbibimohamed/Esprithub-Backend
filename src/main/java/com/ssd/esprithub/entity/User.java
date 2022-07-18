package com.ssd.esprithub.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private Long phone;
    @Column(name = "aboutme")
    private String aboutMe;
    @Enumerated(EnumType.STRING)
    private  Role role;
    @Enumerated(EnumType.STRING)
    private  Niveau niveau;


}
