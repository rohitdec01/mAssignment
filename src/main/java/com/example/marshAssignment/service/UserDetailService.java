package com.example.marshAssignment.service;

import com.example.marshAssignment.entity.UserDetail;
import com.example.marshAssignment.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        UserDetail userDetail = userDetailRepository.findByUsername(userName);
        if (userDetail == null) {
            // throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.");
        }
        return new User(userDetail.getUsername(), userDetail.getPassword(), new ArrayList<>());
    }
}
