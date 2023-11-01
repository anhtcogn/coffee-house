package com.coffeehouse.service.impl;

import com.coffeehouse.entity.UserEntity;
import com.coffeehouse.payload.LoginRequest;
import com.coffeehouse.payload.LoginResponse;
import com.coffeehouse.payload.Response;
import com.coffeehouse.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserEntity getUser(Long id) {
        return null;
    }

    @Override
    public Response register(UserEntity user) {
        return null;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        return null;
    }

    @Override
    public UserEntity updateInfo(Long id, String phoneNum, String address) {
        return null;
    }

    @Override
    public Response changePw(Long id, String oldPw, String newPw) {
        return null;
    }
}
