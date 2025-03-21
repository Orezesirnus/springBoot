package com.b2b.spring.boot.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TodoRecord {

    private Long userId;
    private Long id;
    private String title;
    boolean completed;

}
