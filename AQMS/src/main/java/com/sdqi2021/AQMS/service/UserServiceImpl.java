package com.sdqi2021.AQMS.service;

import com.sdqi2021.AQMS.model.User;
import com.sdqi2021.AQMS.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}
