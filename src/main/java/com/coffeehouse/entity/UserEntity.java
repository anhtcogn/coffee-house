package com.coffeehouse.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    private String name;
    @Column(name = "phone_num", unique = true)
    private String phoneNum;
    private String email;

    @Lob
    private String image;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "birthday")
    private Date birthOfDate;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<UserRole> role;

    private String token;
}

