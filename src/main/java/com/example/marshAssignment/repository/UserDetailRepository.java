package com.example.marshAssignment.repository;

import com.example.marshAssignment.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {

    UserDetail findByUsername(String userName);
}
