package com.example.restMongo;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class TaskData {
    private List<Task> tasks;

    public TaskData() {
        tasks = new ArrayList<Task>();
    }

    // Return all tasks
    public List<Task> getTasks() {
        return tasks;
    }

    // Return Task by id
    public Task getTaskbyId(Long id) {
        for(Task t : tasks) {
            if(t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }

    // Create Task
    public Task createTask(Long id, String subject, String description, Date due, boolean important) {
        Task task = new Task(id, subject, description, due, important);
        tasks.add(task);
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