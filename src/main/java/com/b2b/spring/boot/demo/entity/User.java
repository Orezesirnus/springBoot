package com.b2b.spring.boot.demo.entity;

import com.b2b.spring.boot.demo.dto.UserRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "Utente")
@Data
@RequiredArgsConstructor
public class User {

    @Id
    //@SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //GenerationType.AUTO
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "dettaglio")
    private String dettaglio;


//    public User(UserRequest userRequest) {
//        this.iduser = userRequest.id();
//        this.name = userRequest.name();
//        this.email = userRequest.email();
//        this.dettaglio = userRequest.dettaglio();
//    }
}
