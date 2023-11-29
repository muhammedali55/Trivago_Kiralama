package com.muhammet.service;

import com.muhammet.dto.request.UserProfileRequestDto;
import com.muhammet.mapper.UserProfileMapper;
import com.muhammet.repository.UserProfileRepository;
import com.muhammet.repository.entity.UserProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProfileService {
    private final UserProfileRepository userProfileRepository;

    public UserProfileService(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    public void save(UserProfileRequestDto dto){
        userProfileRepository.save(UserProfileMapper.INSTANCE.fromDto(dto));
    }

    public void update(UserProfileRequestDto dto){
        Optional<UserProfile> userProfile =  userProfileRepository.findOptionalByUserId(dto.getId());
        if(userProfile.isEmpty()){
            userProfileRepository.save(UserProfileMapper.INSTANCE.fromDto(dto));
        }else{
            UserProfile profile = userProfile.get();
            profile.setPhone(dto.getPhone());
            profile.setName(dto.getName());
            profile.setPhoto(dto.getPhoto());
            profile.setEmail(dto.getEmail());
            profile.setState(dto.getState());
            userProfileRepository.save(profile);
        }
    }

}
