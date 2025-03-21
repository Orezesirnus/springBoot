package com.b2b.spring.boot.demo.controller.api;

import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/api/auth")
public interface AuthenticationAPI {

  /**
   * Authenticates a user based on the provided username and password.
   *
   * @param username the username of the user attempting to log in
   * @param password the password of the user attempting to log in
   * @return a string indicating the token in case of successful login
   */
  @GetMapping("/login")
  //@PreAuthorize("hasAnyRole()")
  String login(@RequestParam String username, @RequestParam String password);

  @GetMapping("/user")
  //@PreAuthorize("hasRole('USER')")
  String userAccess();

  @GetMapping("/admin")
  //@PreAuthorize("hasRole('ADMIN')")
  String adminAccess();
}
