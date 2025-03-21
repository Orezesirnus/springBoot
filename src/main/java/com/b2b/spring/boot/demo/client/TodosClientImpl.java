package com.b2b.spring.boot.demo.client;

import com.b2b.spring.boot.demo.entity.TodoRecord;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

public class TodosClientImpl implements TodosClient{


    @Override
    public List<TodoRecord> getAll() {
        return List.of();
    }
}
