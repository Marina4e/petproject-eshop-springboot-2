package com.example.petprojecteshopspringboot2.controllers;

import com.example.petprojecteshopspringboot2.domain.Role;
import com.example.petprojecteshopspringboot2.domain.User;
import com.example.petprojecteshopspringboot2.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UserController.class)
class UserControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private UserService userService;

    private User clientUser = User.builder()
            .name("testuser").id(1L).role(Role.CLIENT).build();

    @BeforeEach
    void setUp() {
        Mockito.when(userService.findByName(Mockito.eq(clientUser.getName())))
                .thenReturn(clientUser);
    }

    @Test
    void getRolesNotAuthorized() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/users/testuser/roles")
                        .contentType(MediaType.TEXT_HTML))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError()
        );
    }

    @WithMockUser("testuser")
    @Test
    void getRoles() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/users/testuser/roles")
                .contentType(MediaType.TEXT_HTML))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("CLIENT")
        );
    }

    @WithMockUser("otheruser")
    @Test
    void getRolesWrongUser() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/users/testuser/roles")
                .contentType(MediaType.TEXT_HTML))
                .andExpect(MockMvcResultMatchers.status().isOk()
        );
    }

    @Test
    void newUserNotAuthorized() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/users/new")
                .contentType(MediaType.TEXT_HTML))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError()
        );
    }
    @WithMockUser(username = "testuser",authorities = {"CLIENT"})
    @Test
    void newUserNotAdmin() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/users/new")
                .contentType(MediaType.TEXT_HTML))
                .andExpect(MockMvcResultMatchers.status().isOk()
        );
    }

    @WithMockUser(username = "admin",authorities = {"ADMIN"})
    @Test
    void newUser() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/users/new")
                .contentType(MediaType.TEXT_HTML))
                        .andExpect(MockMvcResultMatchers.status().isOk()
        );
    }
}
