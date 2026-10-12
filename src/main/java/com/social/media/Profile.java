package com.social.media;

import jakarta.persistence.*;

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "profile") //to define the owner, who owns the relationship when it is bidirectional
    private User user;

}
