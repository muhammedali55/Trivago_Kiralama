package com.muhammet.controller;

import com.muhammet.dto.request.UserProfileRequestDto;
import com.muhammet.repository.UserProfileRepository;
import com.muhammet.repository.entity.UserProfile;
import com.muhammet.utility.enums.State;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Profile("test")
class UserProfileElasticControllerTest {

    @Autowired
    private UserProfileElasticController controller;
    @Autowired
    private UserProfileRepository repository;
    @Test
    void saveSuccess() {
        controller.save(UserProfileRequestDto.builder()
                        .id(UUID.randomUUID().toString())
                        .photo("")
                        .state(State.AKTIF)
                        .phone("0 999 888 7774")
                        .name("Demet KUŞ")
                        .email("demet@gmail.com")
                        .authId(3243L)
                        .userName("demet.demet")
                .build());
        Optional<UserProfile> userProfile = repository.findOptionalByAuthId(3243L);
        Assertions.assertTrue(userProfile.isPresent());

    }

    @Test
    void saveError() {
        Exception ex = Assertions.assertThrows(RuntimeException.class,()->{
            controller.save(UserProfileRequestDto.builder()
                    .id(UUID.randomUUID().toString())
                    .photo("")
                    .state(State.AKTIF)
                    .phone("0 999 888 7774")
                    .name("Demet KUŞ")
                    .email("demet@gmail.com")
                    .authId(null)
                    .userName("demet.demet")
                    .build());

        });
        Assertions.assertEquals("Auth id null olamaz",ex.getMessage());
    }

}