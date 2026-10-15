package com.social.media.service;

import com.social.media.entity.User;
import com.social.media.repository.SocialUserRepository;
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

    public void deleteUser(Long userId){
        User existingUser = socialUserRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("User not found"));
         socialUserRepository.deleteById(userId);
    }
}
