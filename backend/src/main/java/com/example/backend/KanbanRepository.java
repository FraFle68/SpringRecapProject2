package com.example.backend;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface KanbanRepository extends MongoRepository<KanbanEntry, String> {

}
