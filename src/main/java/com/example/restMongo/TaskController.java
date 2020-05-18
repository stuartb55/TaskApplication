package com.example.restMongo;

import java.util.List;
import java.util.Map;
import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@CrossOrigin()
@RestController
public class TaskController {
    @Autowired
    private TaskRepository repository;

    @DeleteMapping("/task")
    public void deleteAll() {
        System.out.println("Inside deleteAll");
        repository.deleteAll();
    }

    @GetMapping("/task")
    public List<Task> getAll() {
        System.out.println("Inside getAll");
        return repository.findAll();
    }

    @PostMapping("/task")
    public Task create(@RequestBody Map<String, String> body) {
        System.out.println("Inside create");
        String subject = body.get("subject");
        String description = body.get("description");
        LocalDateTime due = LocalDateTime.parse(body.get("dueDateTime"));
        Boolean important = Boolean.parseBoolean(body.get("important"));
        return repository.save(new Task(subject, description, due, important));
    }

    @PutMapping("/task")
    public Task update(@RequestBody Map<String, String> body) {
        System.out.println("Inside update");
        String id = body.get("id");
        String subject = body.get("subject");
        String description = body.get("description");
        LocalDateTime due = LocalDateTime.parse(body.get("dueDateTime"));
        Boolean important = Boolean.parseBoolean(body.get("important"));
        return repository.save(new Task(id, subject, description, due, important));
    }
}