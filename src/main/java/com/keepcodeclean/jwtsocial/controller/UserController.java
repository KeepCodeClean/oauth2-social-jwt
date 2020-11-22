package com.keepcodeclean.jwtsocial.controller;

import com.keepcodeclean.jwtsocial.exception.ResourceNotFoundException;
import com.keepcodeclean.jwtsocial.model.User;
import com.keepcodeclean.jwtsocial.repository.UserRepository;
import com.keepcodeclean.jwtsocial.security.CurrentUser;
import com.keepcodeclean.jwtsocial.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}