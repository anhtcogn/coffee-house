package com.coffeehouse.service;

import com.coffeehouse.entity.UserEntity;
import com.coffeehouse.payload.LoginRequest;
import com.coffeehouse.payload.LoginResponse;
import com.coffeehouse.payload.Response;

public interface UserService {
    UserEntity getUser(Long id);

    Response register(UserEntity user);

    LoginResponse login(LoginRequest loginRequest);

    UserEntity updateInfo(Long id,
                          String phoneNum,
                          String address);

    Response changePw(Long id,
                     String oldPw,
                     String newPw);
}
