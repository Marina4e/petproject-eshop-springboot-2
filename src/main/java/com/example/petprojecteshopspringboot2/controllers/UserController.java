package com.example.petprojecteshopspringboot2.controllers;


import com.example.petprojecteshopspringboot2.domain.User;
import com.example.petprojecteshopspringboot2.dto.UserDTO;
import com.example.petprojecteshopspringboot2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Objects;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String userList(Model model) {
        model.addAttribute("users", userService.getAll());
        return "userList";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/new")
    public String newUser(Model model) {
    System.out.println("called method newUser");
        model.addAttribute("user", new UserDTO());
        return "user";
    }

    @PostAuthorize("isAuthenticated() and #username == authentication.principal.username")
    @GetMapping("/{name}/roles")
    @ResponseBody
    public String getRoles(@PathVariable("name") String username) {
        System.out.println("called method getRoles");
        User byName = userService.findByName(username);
        return byName.getRole().name();
    }

    @PostMapping("/new")
    public String saveUser(UserDTO dto, Model model) {
        if(userService.save(dto)) {
            return "redirect:/users";
        } else {
            model.addAttribute("user",dto);
            return "user";
        }
    }

    @GetMapping("/profile")
    public String profileUser(Model model, Principal principal) {
       if(principal == null) {
           throw new RuntimeException("You are not logged in");
       }
       User user = userService.findByName(principal.getName());

       UserDTO dto = UserDTO.builder()
               .username(user.getName())
               .email(user.getEmail())
               .build();
       model.addAttribute("user", dto);
       return "profile";
    }

    @PostMapping("/profile")
    public String updateProfileUser(UserDTO dto, Model model, Principal principal) {
        if(principal == null || !Objects.equals(principal.getName(), dto.getUsername())) {
            throw new RuntimeException("You are not logged in");
        }
        if(dto.getPassword() != null
        && !dto.getPassword().isEmpty()
        && !Objects.equals(dto.getPassword(),dto.getMatchingPassword())){
            model.addAttribute("user", dto);
            return "profile";
        }
        userService.updateProfile(dto);
        return "redirect:/users/profile";
    }

    @GetMapping("/activate/{code}")
    public String activateUser(Model model, @PathVariable("code") String activateCode) {
        boolean activated = userService.activateUser(activateCode);
        model.addAttribute("activated", activated);
        return "activate-user";
    }

}
