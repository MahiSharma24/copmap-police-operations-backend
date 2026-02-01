package com.copmap.bandobast_service.repository;

import com.copmap.bandobast_service.model.Assignment;
import com.copmap.bandobast_service.model.AssignmentStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AssignmentRepository extends MongoRepository<Assignment, String> {
    List<Assignment> findByStatus(AssignmentStatus status); // optional filter
    List<Assignment> findByBandobastId(String bandobastId); // get all assignments for a bandobast
}
