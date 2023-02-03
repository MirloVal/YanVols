package com.Jonet.YanVols.security;

import com.Jonet.YanVols.exceptions.YanVolsException;
import com.Jonet.YanVols.model.User;
import com.Jonet.YanVols.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public MyUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(()-> new YanVolsException("Username not found", HttpStatus.NOT_FOUND));
        return new MyUserDetails(user);
    }

}
