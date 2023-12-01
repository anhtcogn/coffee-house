package com.coffeehouse.service.impl;

import com.coffeehouse.entity.UserEntity;
import com.coffeehouse.entity.UserRole;
import com.coffeehouse.jwt.JwtTokenProvider;
import com.coffeehouse.payload.Request;
import com.coffeehouse.payload.Response;
import com.coffeehouse.repository.UserRepository;
import com.coffeehouse.service.ImageService;
import com.coffeehouse.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

import static com.coffeehouse.constant.constants.AZURE_CONTAINER;
import static com.coffeehouse.constant.constants.DEFAULT_IMAGE;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private ImageService imageService;

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public Response register(String username, String password) {
        Response response = new Response();
        if (userRepository.existsByUsername(username)) {
            response.setMessage("Username is already in use");
        } else {
            UserEntity userEntity = new UserEntity();
            userEntity.setUsername(username);
            userEntity.setPassword(passwordEncoder.encode(password));
            userEntity.setRole(Collections.singletonList(UserRole.CLIENT));
            userEntity.setImage(DEFAULT_IMAGE);
            userRepository.save(userEntity);

            response.setSuccess(true);
            response.setMessage("Register successfully");
        }
        return response;
    }

    @Override
    public Response login(String username, String password) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));
        UserEntity user = userRepository.findByUsername(username);

        userRepository.save(user);
        return new Response(true, "", user.getId());
    }

    @Override
    public UserEntity update(String name, String phoneNum, String email, MultipartFile image, Long id) {
        UserEntity userEntity = userRepository.getById(id);
        userEntity.setName(name);
        userEntity.setPhoneNum(phoneNum);
        userEntity.setEmail(email);

        if (image != null && !image.isEmpty()) {
            String existImage = userEntity.getImage();
            if (existImage != null && !existImage.equals(DEFAULT_IMAGE)) {
                imageService.deleteImage(existImage, AZURE_CONTAINER);
                System.out.println("delete success");
            }
            userEntity.setImage(imageService.uploadImage(image, AZURE_CONTAINER));
        } else {
            userEntity.setImage(userEntity.getImage());
        }

        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity getMyProfile(Long id) {
        return userRepository.findUserEntityById(id);
    }

    @Override
    public Response delete(Long id) {
        if (id == 1) {
            return new Response(true, "can't delete", null);
        }
        userRepository.deleteById(id);
        return new Response(true, "delete success", null);
    }
}
