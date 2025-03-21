package com.b2b.spring.boot.demo.dto;

public record IndirizzoRecord(
       String nazione,
       String regione,
       String provincia,
       String citta,
       String indirizzo
) { }
