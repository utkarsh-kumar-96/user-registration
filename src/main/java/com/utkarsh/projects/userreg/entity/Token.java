package com.utkarsh.projects.userreg.entity;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private LocalDateTime createdOn;

    @Column(nullable = false)
    private LocalDateTime expiredOn;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private Boolean confirmed;

    @Column(nullable = false)
    private LocalDateTime confirmedOn;

    @ManyToOne
    @JoinColumn(name = "app_user_id")
    private AppUser appUser;
}
