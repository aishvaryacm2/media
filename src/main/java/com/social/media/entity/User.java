package com.social.media.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "SocialUser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER) //this is managed by another table whether the ids will be mapped
    @JoinTable(
            name = "user_group",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private Set<SocialGroup> groups = new HashSet<>();

    //manual setting is needed to maintain the bidirectional relationship
    public void setProfile(Profile profile) {
        if(profile.getUser()!=this){
            profile.setUser(this);
        }
        this.profile = profile;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
