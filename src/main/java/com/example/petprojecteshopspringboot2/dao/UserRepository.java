package com.example.petprojecteshopspringboot2.dao;

import com.example.petprojecteshopspringboot2.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstByName(String name);
    User findFirstByActiveCode(String activateCode);
}
