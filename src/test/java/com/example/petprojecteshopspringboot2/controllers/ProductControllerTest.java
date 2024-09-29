package com.example.petprojecteshopspringboot2.controllers;

import com.example.petprojecteshopspringboot2.dto.ProductDTO;
import com.example.petprojecteshopspringboot2.service.ProductService;
import com.example.petprojecteshopspringboot2.service.SessionObjectHolder;
import com.example.petprojecteshopspringboot2.service.UserService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = ProductController.class)
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ProductService productService;
    @MockBean
    private UserService userService;
    @MockBean
    private SessionObjectHolder sessionObjectHolder;


    private ProductDTO dto1 = new ProductDTO(998L, "TestProduct998",
            new BigDecimal("888.88"));
    private ProductDTO dto2 = new ProductDTO(999L, "TestProduct999",
            new BigDecimal("999.99"));

    @BeforeEach
    void setUp() {
        given(productService.getAll()).willReturn(Arrays.asList(dto1, dto2));
    }

    @WithMockUser(username = "testuser", roles = {"USER"})
    @Test
    void checkList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products")
                        .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers
                        .containsString("<td>" + dto1.getTitle() + "</td>")))
                .andExpect(MockMvcResultMatchers.content().string(Matchers
                        .containsString("<td>" + dto2.getTitle() + "</td>")));
    }
}
