package com.example.restMongo;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class TaskController {
    private TaskData taskData = new TaskData();
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/task")
    public List<Task> getAll() {
        return taskData.getTasks();
    }

    @GetMapping("/task/{id}")
    public Task getTask(@PathVariable String id){
        long taskId = Long.parseLong(id);
        return taskData.getTaskbyId(taskId);
    }

    @PostMapping("/task")
    public Task create(@RequestBody Map<String, String> body) {
        long id = counter.incrementAndGet();
        String subject = body.get("subject");
        String description = body.get("description");
        Date due;
        try {
            due = new SimpleDateFormat("dd/MM/yyyy").parse(body.get("dueDate"));
        } catch (ParseException e) {
            due = null;
        }
        Boolean important = Boolean.parseBoolean(body.get("important"));
        return taskData.createTask(id, subject, description, due, important);
    }
}