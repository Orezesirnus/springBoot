package com.b2b.spring.boot.demo.dto;

public record UserRequest(
        Long id,
        String name,
        String email,
        IndirizzoRecord dettaglio
) { }
