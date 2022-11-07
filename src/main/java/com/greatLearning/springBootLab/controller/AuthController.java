package com.greatLearning.springBootLab.controller;

import com.greatLearning.springBootLab.dto.UserDto;
import com.greatLearning.springBootLab.model.User;
import com.greatLearning.springBootLab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String home() {
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto
            , BindingResult bindingResult, Model model) {
        User existingUser = userService.findUserByUsername(userDto.getUsername());

        if (existingUser != null) {
            bindingResult.rejectValue("username", null,
                    "There is already an account registered with the same username");
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", userDto);
            return "/register";
        }
        userService.saveUser(userDto);
        return "redirect:/register?success";
    }

    @GetMapping("/users")
    public String users(Model model) {
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    // handler method to handle login request
    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
