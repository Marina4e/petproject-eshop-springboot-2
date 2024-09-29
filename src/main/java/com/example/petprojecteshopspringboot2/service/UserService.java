package com.example.petprojecteshopspringboot2.service;

import com.example.petprojecteshopspringboot2.domain.User;
import com.example.petprojecteshopspringboot2.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    boolean save(UserDTO userDTO);

    void save(User user);

    List<UserDTO> getAll();

    User findByName(String name);

    void updateProfile(UserDTO userDTO);

    boolean activateUser(String activateCode);
}
