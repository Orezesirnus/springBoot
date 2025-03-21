package com.b2b.spring.boot.demo.dto;


public record UserResponse(
        Long id,
        String name,
        String email,
        IndirizzoRecord dettaglio
) {
//    public UserResponse(User user) {
//        this(user.getName(), user.getEmail(), user.getDettaglio());
//    }
}

