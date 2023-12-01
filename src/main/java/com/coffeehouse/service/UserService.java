package com.coffeehouse.service;

import com.coffeehouse.entity.UserEntity;
import com.coffeehouse.payload.Request;
import com.coffeehouse.payload.Request;
import com.coffeehouse.payload.Response;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface UserService {

    Response register(String username, String password);

    Response login(String username, String password);

    UserEntity update(String name, String phoneNum, String email, MultipartFile image, Long id);

    UserEntity getMyProfile(Long id);

    Response delete(Long id);
}
