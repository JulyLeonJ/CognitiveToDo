package org.example.infrastructure.adapter.repository;

import org.example.infrastructure.entities.TaskEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskCRUDRepository extends MongoRepository<TaskEntity, String> {

}
