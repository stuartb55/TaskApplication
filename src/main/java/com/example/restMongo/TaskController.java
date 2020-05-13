package com.example.restMongo;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

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

    @GetMapping("/task/{id}")
    public Task getTask(@PathVariable String id) {
        System.out.println("Inside getTask");
        ObjectId taskId = new ObjectId(id);
        return repository.findById(taskId).orElse(null);
    }

    @PostMapping("/task")
    public Task create(@RequestBody Map<String, String> body) {
        System.out.println("Inside create");
        String subject = body.get("subject");
        String description = body.get("description");
        Date due;
        try {
            due = new SimpleDateFormat("dd/MM/yyyy").parse(body.get("dueDate"));
        } catch (ParseException e) {
            due = null;
        }
        Boolean important = Boolean.parseBoolean(body.get("important"));
        return repository.save(new Task(subject, description, due, important));
    }

    @PutMapping("/task")
    public Task update(@RequestBody Map<String, String> body) {
        System.out.println("Inside update");
        ObjectId id = new ObjectId(body.get("id").toString());
        String subject = body.get("subject");
        String description = body.get("description");
        Date due;
        try {
            due = new SimpleDateFormat("dd/MM/yyyy").parse(body.get("dueDate"));
        } catch (ParseException e) {
            due = null;
        }
        Boolean important = Boolean.parseBoolean(body.get("important"));
        return repository.save(new Task(id, subject, description, due, important));
    }
}