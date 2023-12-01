package com.coffeehouse.controller;

import com.coffeehouse.entity.UserEntity;
import com.coffeehouse.payload.Request;
import com.coffeehouse.payload.Response;
import com.coffeehouse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(
            @RequestParam String username,
            @RequestParam String password) {
        Response response = userService.register(username, password);
        return Response.response(response.isSuccess(), response.getMessage(), "");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username,
                                   @RequestParam String password) {
        Response response = userService.login(username, password);
        return Response.response(response.isSuccess(), "", response.getData());
    }

    @GetMapping("/get/{id}")
    public UserEntity getUserById(@PathVariable("id") Long id) {
        return userService.getMyProfile(id);
    }

    @PutMapping("/update/{id}")
    public UserEntity update(
            @RequestParam String name,
            @RequestParam String phoneNum,
            @RequestParam String email,
            @RequestParam(required = false) MultipartFile image,
            @PathVariable("id") Long id
    ) {
        return userService.update(name, phoneNum, email, image, id);
    }

    @DeleteMapping("/delete/{id}")
    @Secured({"ADMIN"})
    public Response delete(@PathVariable("id") Long id) {
        return userService.delete(id);
    }
}
