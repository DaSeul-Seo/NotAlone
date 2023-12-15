package com.webprojectv1.notalone;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String userId;

    @Column(nullable = false)
    private String userPw;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String userBirth;

    private String userPhoneNumber;
    
    private String userAddress;

    @Column(nullable = false)
    private char isGrant;
}
