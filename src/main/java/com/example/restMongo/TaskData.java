package com.example.restMongo;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class TaskData {
    private TaskRepository repository;

    private List<Task> tasks;

    public TaskData() {
        tasks = new ArrayList<Task>();
    }

    // Return all tasks
    public List<Task> getTasks() {
        return repository.findAll();
    }

    // Return Task by id
    public Task getTaskbyId(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Create Task
    public Task createTask(Long id, String subject, String description, Date due, boolean important) {
        Task task = new Task(id, subject, description, due, important);
        repository.save(task);
        return task;
    }

    // Update Task
    public Task updateTask(Long id, String subject, String description, Date due, boolean important) {
        for(Task tu : tasks) {
            if(tu.getId().equals(id)) {
                tu.setSubject(subject);
                tu.setDescription(description);
                tu.setDue(due);
                tu.setImportant(important);
                tasks.set(tasks.indexOf(tu), tu);
                return tu;
            }
        }
        return null;
    }
}