package com.example.securityappkinansaad.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Eren
 **/
@Service
abstract class UserDetailsService implements UserDetailsService {

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Map<String, String> users = new HashMap<>();
        users.put("xproce", passwordEncoder.encode("12345"));
        if (users.containsKey(username))
            return new User(username, users.get(username), new ArrayList<>());
        throw new UsernameNotFoundException(username);
    }
}
