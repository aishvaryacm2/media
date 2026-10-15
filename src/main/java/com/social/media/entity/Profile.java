package com.social.media.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToOne(mappedBy = "profile") //to define the owner, who owns the relationship when it is bidirectional
    private User user;

    private String description;

    public void setUser(User user){
        this.user = user;
        if(user.getProfile()!=this){
            user.setProfile(this);
        }
    }

}
