package com.coffeehouse.payload;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Request {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
