package com.example.petprojecteshopspringboot2.service;

import com.example.petprojecteshopspringboot2.domain.User;

public interface MailSenderService {
    void sendActivateCode(User user);
}
