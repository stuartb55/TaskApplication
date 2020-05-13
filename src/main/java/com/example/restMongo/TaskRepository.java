package com.example.restMongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, Long> {
  public Task findBySubject(String subject);

  public List<Task> findByDescription(String description);
}