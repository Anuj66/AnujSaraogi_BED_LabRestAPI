package com.greatLearning.springBootLab.repository;

import com.greatLearning.springBootLab.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    Boolean existsByUsername(String username);

}
