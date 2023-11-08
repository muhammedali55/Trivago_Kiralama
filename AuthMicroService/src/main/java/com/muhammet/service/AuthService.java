package com.muhammet.service;

import com.muhammet.dto.request.LoginRequestDto;
import com.muhammet.dto.request.RegisterRequestDto;
import com.muhammet.exception.AuthException;
import com.muhammet.exception.ErrorType;
import com.muhammet.mapper.AuthMapper;
import com.muhammet.repository.AuthRepository;
import com.muhammet.repository.entity.Auth;
import com.muhammet.utility.enums.State;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository repository;

    public void register(RegisterRequestDto dto){
        Auth auth = AuthMapper.INSTANCE.fromDto(dto);
        auth.setCreateAt(System.currentTimeMillis());
        auth.setUpdateAt(System.currentTimeMillis());
        auth.setState(State.AKTIF);
        repository.save(auth);
    }

    public boolean login(LoginRequestDto dto){
        Optional<Auth> auth = repository.findOptionalByUserNameAndPassword(dto.getUserName(),dto.getPassword());
        if(auth.isEmpty()) throw new AuthException(ErrorType.USERNAME_PASSWORD_ERROR);
        return true;
    }

}
