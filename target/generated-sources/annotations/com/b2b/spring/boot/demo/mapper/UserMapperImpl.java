package com.b2b.spring.boot.demo.mapper;

import com.b2b.spring.boot.demo.dto.IndirizzoRecord;
import com.b2b.spring.boot.demo.dto.UserRequest;
import com.b2b.spring.boot.demo.dto.UserResponse;
import com.b2b.spring.boot.demo.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-20T18:25:05+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserRequest dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setDettaglio( setDettaglioFromIndirizzoRecord( dto.dettaglio() ) );
        user.setName( dto.name() );
        user.setEmail( dto.email() );

        return user;
    }

    @Override
    public UserResponse toDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        IndirizzoRecord dettaglio = null;
        Long id = null;
        String name = null;
        String email = null;

        dettaglio = setIndirizzoRecordoFromDettaglio( entity.getDettaglio() );
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();

        UserResponse userResponse = new UserResponse( id, name, email, dettaglio );

        return userResponse;
    }

    @Override
    public User partialUpdate(User entity, UserRequest dto) {
        if ( dto == null ) {
            return entity;
        }

        if ( dto.id() != null ) {
            entity.setId( dto.id() );
        }
        if ( dto.name() != null ) {
            entity.setName( dto.name() );
        }
        if ( dto.email() != null ) {
            entity.setEmail( dto.email() );
        }

        return entity;
    }
}
