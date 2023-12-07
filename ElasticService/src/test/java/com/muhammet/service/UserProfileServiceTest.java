package com.muhammet.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class UserProfileServiceTest {

    @Autowired
    UserProfileService userProfileService;
    @Test
    void findAll() {
        Assertions.assertTrue(userProfileService.findAll().iterator().hasNext());
    }
}