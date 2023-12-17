package com.rbs.cwe209.service;

import com.rbs.cwe209.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}