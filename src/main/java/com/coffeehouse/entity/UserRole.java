package com.coffeehouse.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "user_role")
public enum UserRole implements GrantedAuthority {
    ADMIN, CLIENT;

    @Override
    public String getAuthority() {
        return name();
    }
}
