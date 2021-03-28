package com.sdqi2021.AQMS.security;

import com.sdqi2021.AQMS.model.User;
import com.sdqi2021.AQMS.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);

        if(user == null) {
            throw new UsernameNotFoundException("User Not found 404");
        }

        return new UserDetailsImpl(user);
    }
}
