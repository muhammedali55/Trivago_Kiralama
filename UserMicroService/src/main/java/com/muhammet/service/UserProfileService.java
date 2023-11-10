package com.muhammet.service;

import com.muhammet.dto.request.UserProfileSaveRequestDto;
import com.muhammet.mapper.UserProfileMapper;
import com.muhammet.repository.UserProfileRepository;
import com.muhammet.repository.entity.UserProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProfileService {
    private final UserProfileRepository repository;

    public UserProfile save(UserProfileSaveRequestDto dto){
        return repository.save(UserProfileMapper.INSTANCE.fromDto(dto));
//        return repository.save(UserProfile.builder()
//                        .userName(dto.getUserName())
//                        .authId(dto.getAuthId())
//                .build());
    }

}
