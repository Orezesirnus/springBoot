package com.b2b.spring.boot.demo.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
//@EnableMethodSecurity //abilitare restrizioni o autorizzaz
public class SecurityConfig {

  private final AuthorizationHeaderFilter authorizationHeaderFilter;
  private final AuthenticationProvider authenticationProvider;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
        .csrf(AbstractHttpConfigurer::disable)
        .cors(AbstractHttpConfigurer::disable)
        .authenticationProvider(authenticationProvider) //def modo di gestire authentication
        .addFilterBefore(authorizationHeaderFilter, UsernamePasswordAuthenticationFilter.class) //aggiungere controlli personalizzati su encoder
        .authorizeHttpRequests(
            authReq -> authReq
                .requestMatchers("/api/users/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/auth/login").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/auth/user").hasRole("USER")
                .requestMatchers(HttpMethod.GET, "/api/auth/admin").hasRole("ADMIN")
                .anyRequest().authenticated());
    return httpSecurity.build();
  }

}

//cors: controlla indirizzo di origine da cui viene la chiamata (url prensendi tra AllowedOrigins)

//doppio token (guest token): serve a evitare che i language model raccolgono dati con deamon
//in questo modo: richieste vengono autorizzate solo se arrivano da un browser