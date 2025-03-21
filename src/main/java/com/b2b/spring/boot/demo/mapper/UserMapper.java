package com.b2b.spring.boot.demo.mapper;

import com.b2b.spring.boot.demo.dto.IndirizzoRecord;
import com.b2b.spring.boot.demo.dto.UserRequest;
import com.b2b.spring.boot.demo.dto.UserResponse;
import com.b2b.spring.boot.demo.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mapstruct.*;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dettaglio", source = "dettaglio", qualifiedByName = "setDettaglioFromIndirizzoRecord")
    User toEntity(UserRequest dto);

    @Mapping(target = "dettaglio", source = "dettaglio", qualifiedByName = "setIndirizzoRecordoFromDettaglio")
    UserResponse toDto(User entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "dettaglio", ignore = true, qualifiedByName = "setDettaglioFromIndirizzoRecord")
    User partialUpdate(@MappingTarget User entity, UserRequest dto);


    @Named("setDettaglioFromIndirizzoRecord")
    default String setDettaglioFromIndirizzoRecord(IndirizzoRecord indirizzoRecord) {
        try {
            return OBJECT_MAPPER.writeValueAsString(indirizzoRecord);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Named("setIndirizzoRecordoFromDettaglio")
    default IndirizzoRecord setIndirizzoRecordoFromDettaglio(String dettaglio) {

        try {
            return OBJECT_MAPPER.readValue(dettaglio, IndirizzoRecord.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }



}
