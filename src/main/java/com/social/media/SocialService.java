package com.social.media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialService {

    @Autowired
    private SocialUserRepository socialUserRepository;


    public List<User> getAllUsers(){
        return socialUserRepository.findAll();
    }

    public User saveUser(User user){
        return socialUserRepository.save(user);
    }
}
