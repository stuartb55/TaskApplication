package com.example.restMongo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {

    public List<Task> findBySubject(String subject);

    public List<Task> findByDescription(String description);

    public List<Task> findByImportant(Boolean important);

    public List<Task> findByDueDateTime(LocalDateTime dueDateTime);

    public Page<Task> findAll(Pageable pageable);
}