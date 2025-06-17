package com.dev.springsecurity.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dev.springsecurity.Entity.UserEntity;
import com.dev.springsecurity.UserRepository;



@Controller
public class RegistrationController {
@Autowired
private UserRepository userRepository;
@Autowired 
private PasswordEncoder passwordEncoder;

@GetMapping("/registration")
public String showRegistrationForm(Model model) {
    model.addAttribute("userEntity",new UserEntity());
    return "/registration";
}
@PostMapping("/register")
public String registerUser(@ModelAttribute UserEntity userEntity) {
    userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));

    // Optional fallback to default role
    if (userEntity.getRoleList() == null || userEntity.getRoleList().isEmpty()) {
        userEntity.setRoleList(List.of("ROLE_USER"));
    }

    userRepository.save(userEntity);
    return "redirect:/plain_login";
}



}
