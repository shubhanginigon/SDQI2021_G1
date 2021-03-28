package com.sdqi2021.AQMS.service;

import com.sdqi2021.AQMS.model.User;

public interface UserService {
    User findByUsername(String username);
}
