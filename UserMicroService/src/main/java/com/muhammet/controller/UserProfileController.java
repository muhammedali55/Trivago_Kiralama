package com.muhammet.controller;

import com.muhammet.dto.request.GetProfileByTokenRequestDto;
import com.muhammet.dto.request.UpdateProfiliRequestDto;
import com.muhammet.dto.request.UserProfileSaveRequestDto;
import com.muhammet.dto.response.UserProfileResponseDto;
import com.muhammet.repository.entity.UserProfile;
import com.muhammet.service.UserProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-profile")
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileService userProfileService;

    @PostMapping("/save")
    public ResponseEntity<Boolean> save(@RequestBody @Valid UserProfileSaveRequestDto dto){
       UserProfile user =   userProfileService.save(dto);
       return ResponseEntity.ok(true);
    }

    @PostMapping("/get-profile")
    public ResponseEntity<UserProfileResponseDto> getProfileByToken(@RequestBody @Valid GetProfileByTokenRequestDto dto){
        return ResponseEntity.ok(userProfileService.getProfileByToken(dto));
    }

    @PostMapping("/update-profile")
    public ResponseEntity<Boolean> updateProfile(@RequestBody UpdateProfiliRequestDto dto){
        return ResponseEntity.ok(userProfileService.updateProfile(dto));
    }
}
