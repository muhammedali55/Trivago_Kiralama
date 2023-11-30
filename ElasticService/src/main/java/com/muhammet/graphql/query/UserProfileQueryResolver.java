package com.muhammet.graphql.query;

import com.muhammet.repository.entity.UserProfile;
import com.muhammet.service.UserProfileService;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class UserProfileQueryResolver {

    private final UserProfileService userProfileService;
    @QueryMapping
    public Iterable<UserProfile> findAll(){
        return userProfileService.findAll();
    }
    @QueryMapping
    public UserProfile findById(@Argument String id){
        return userProfileService.findById(id);
    }
}
