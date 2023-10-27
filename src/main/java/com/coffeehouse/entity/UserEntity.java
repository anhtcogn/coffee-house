package com.coffeehouse.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import javax.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String name;
    private String telephone;
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Lob
    @Column(name = "profile_picture")
    private String profilePicture;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "birthday")
    private Date birthOfDate;

    @Column(name = "created_at")
    private LocalDate createdAt;
    @Column(name = "modified_at")
    private LocalDate modifiedAt;

    enum Gender {
        MALE,
        FEMALE
    }
}

