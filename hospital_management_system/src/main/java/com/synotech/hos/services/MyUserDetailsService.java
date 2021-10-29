package com.synotech.hos.services;

import com.synotech.hos.dao.UserRepo;
import com.synotech.hos.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.nio.file.attribute.UserPrincipal;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepo userRepository;


    @Autowired
    public MyUserDetailsService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.finByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(user);
    }


}

