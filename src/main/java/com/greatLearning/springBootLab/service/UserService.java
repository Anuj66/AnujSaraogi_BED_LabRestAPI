package com.greatLearning.springBootLab.service;

import com.greatLearning.springBootLab.dto.UserDto;
import com.greatLearning.springBootLab.model.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);
    User findUserByUsername(String username);
    List<UserDto> findAllUsers();
}
