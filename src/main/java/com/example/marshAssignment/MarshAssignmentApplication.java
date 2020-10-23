package com.example.marshAssignment;

import com.example.marshAssignment.entity.UserDetail;
import com.example.marshAssignment.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class MarshAssignmentApplication {

    @Autowired
    UserDetailRepository userDetailRepository;

    public static void main(String[] args) {
        SpringApplication.run(MarshAssignmentApplication.class, args);
    }

    @PostConstruct
    public void addUsers() {
        UserDetail userDetail = UserDetail.builder()
                .username("test")
                .password("test").build();
        userDetailRepository.save(userDetail);

        UserDetail userDetail2 = UserDetail.builder()
                .username("test1")
                .password("test1").build();
        userDetailRepository.save(userDetail2);

        UserDetail userDetail3 = UserDetail.builder()
                .username("test3")
                .password("test3").build();
        userDetailRepository.save(userDetail3);
    }

}
