package com.b2b.spring.boot.demo.client;

import com.b2b.spring.boot.demo.entity.TodoRecord;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Set;

@FeignClient(url = "https://jsonplaceholder.typicode.com", name = "todos")
public interface TodosClient {

    @GetMapping("/todos")
    List<TodoRecord> getAll();
}
