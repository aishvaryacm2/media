package com.social.media.controller;

import com.social.media.service.SocialService;
import com.social.media.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SocialController {
    @Autowired
    private SocialService socialService;

    @RequestMapping(path = "/social/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(socialService.getAllUsers(), HttpStatus.OK);
    }


    @RequestMapping(path = "/social/users", method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(socialService.saveUser(user), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/social/users/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        socialService.deleteUser(userId);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }
}
