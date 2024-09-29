package com.example.petprojecteshopspringboot2.dao;

import com.example.petprojecteshopspringboot2.domain.Role;
import com.example.petprojecteshopspringboot2.domain.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntityManager em;

    @BeforeEach
    void cleanDatabase() {
        Query query = em.createQuery("DELETE FROM User");
        query.executeUpdate();
        em.createNativeQuery("ALTER TABLE users ALTER COLUMN id RESTART WITH 1").executeUpdate();
    }

    @Test
    void checkFindByName() {
        User user = new User();
        user.setName("Test User Name");
        user.setPassword("password");
        user.setEmail("email@email.com");

        entityManager.persist(user);

        User actualUser = userRepository.findFirstByName("Test User Name");
        Assertions.assertNotNull(actualUser);
        Assertions.assertEquals(user.getName(), actualUser.getName());
        Assertions.assertEquals(user.getPassword(), actualUser.getPassword());
        Assertions.assertEquals(user.getEmail(), actualUser.getEmail());
    }

    @Test
    void checkFindByNameAfterInsert() {
        User user = new User();
        user.setName("admin2");
        user.setPassword("apass");
        user.setEmail("admin@mail.ua");
        user.setRole(Role.ADMIN);
        entityManager.persist(user);

        User actualUser = userRepository.findFirstByName("admin2");
        Assertions.assertNotNull(actualUser);
        Assertions.assertEquals("admin2", actualUser.getName());
        Assertions.assertEquals("apass", actualUser.getPassword());
        Assertions.assertEquals("admin@mail.ua", actualUser.getEmail());
        Assertions.assertEquals(Role.ADMIN, actualUser.getRole());
    }
}
