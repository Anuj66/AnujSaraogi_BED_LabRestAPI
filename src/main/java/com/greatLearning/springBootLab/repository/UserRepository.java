package com.greatLearning.springBootLab.repository;

import com.greatLearning.springBootLab.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    Boolean existsByUsername(String username);

}