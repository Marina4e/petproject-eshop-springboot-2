package com.example.petprojecteshopspringboot2.service;

import com.example.petprojecteshopspringboot2.dao.UserRepository;
import com.example.petprojecteshopspringboot2.domain.User;
import com.example.petprojecteshopspringboot2.dto.UserDTO;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

class UserServiceImplTest {

    private UserServiceImpl userService;
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private MailSenderService mailSenderService;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before All tests");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Before Each tests");
        passwordEncoder = Mockito.mock(PasswordEncoder.class);
        userRepository = Mockito.mock(UserRepository.class);
        mailSenderService = Mockito.mock(MailSenderService.class);

        userService = new UserServiceImpl(userRepository, passwordEncoder,
                mailSenderService);
    }

    @AfterEach
    void afterEach() {
        System.out.println("After Each tests");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After All tests");
    }

    @Test
    void checkFindByName() {
        //init
        String name = "Petr";
        User expectedUser = User.builder().id(1L).name(name).build();

        Mockito.when(userRepository.findFirstByName(Mockito.anyString()))
                .thenReturn(expectedUser);
        //execute
        User actualUser = userService.findByName(name);
        //check
        Assertions.assertNotNull(actualUser);
        Assertions.assertEquals(expectedUser, actualUser);
    }

    @Test
    void checkFindByNameExact() {
        //init
        String name = "Petr";
        User expectedUser = User.builder().id(1L).name(name).build();
        Mockito.when(userRepository.findFirstByName(Mockito.eq(name)))
                .thenReturn(expectedUser);
        //execute
        User actualUser = userService.findByName(name);
        User rndUser = userService.findByName(UUID.randomUUID().toString());
        //check
        Assertions.assertNotNull(actualUser);
        Assertions.assertEquals(expectedUser, actualUser);

        Assertions.assertNull(rndUser);
    }

    @Test
    void checkSaveIncorrectPassword() {
        //init
        UserDTO userDTO = UserDTO.builder()
                .password("password")
                .matchingPassword("another")
                .build();
        //execute
        Assertions.assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                userService.save(userDTO);
            }
        });
    }

    @Test
    void checkSave() {
        //init
        UserDTO userDTO = UserDTO.builder()
                .username("name")
                .email("email")
                .password("password")
                .matchingPassword("password")
                .build();
        Mockito.when(passwordEncoder.encode(Mockito.anyString()))
                .thenReturn("password");
        //execute
        boolean result = userService.save(userDTO);
        //check
        Assertions.assertTrue(result);
        Mockito.verify(passwordEncoder).encode(Mockito.anyString());
        Mockito.verify(userRepository).save(Mockito.any());
    }
}
