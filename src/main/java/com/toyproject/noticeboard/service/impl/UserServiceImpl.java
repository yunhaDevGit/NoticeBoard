package com.toyproject.noticeboard.service.impl;

import com.toyproject.noticeboard.model.User;
import com.toyproject.noticeboard.repository.UserRepository;
import com.toyproject.noticeboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User joinUser(User user) {
        return userRepository.save(user);
    }
}
