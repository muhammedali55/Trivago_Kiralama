package com.muhammet.controller;

import com.muhammet.dto.request.UserProfileRequestDto;
import com.muhammet.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/elastic-user-profile")
@RequiredArgsConstructor
public class UserProfileController {
    private final UserProfileService userProfileService;

    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody UserProfileRequestDto dto){
        userProfileService.save(dto);
        return ResponseEntity.ok().build();
    }


    @PostMapping("/update")
    public ResponseEntity<Void> update(@RequestBody UserProfileRequestDto dto){
        userProfileService.update(dto);
        return ResponseEntity.ok().build();
    }
}
