package com.b2b.spring.boot.demo;

import com.b2b.spring.boot.demo.client.TodosClient;
import com.b2b.spring.boot.demo.entity.TodoRecord;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.List;
import java.util.Set;

@EnableFeignClients
@SpringBootApplication
public class Application {

//  public static final TodosClient todosClient = new TodosClient() {
//
//    @Override
//    public Set<TodoRecord> test() {
//      Set<TodoRecord> todos = todosClient.test();
//      todos.forEach(System.out::println);
//      return todos;
//    }
//  };

  @Autowired
  private TodosClient client;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

//  @PostConstruct
//  public void todos(){
//    List<TodoRecord> todos = client.getAll();
//    todos.forEach(System.out::println);
//  }


}
