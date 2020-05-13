package com.example.restMongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.bson.types.ObjectId;

@Repository
public interface TaskRepository extends MongoRepository<Task, ObjectId> {
  
}