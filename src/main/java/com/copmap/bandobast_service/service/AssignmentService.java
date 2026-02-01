package com.copmap.bandobast_service.service;

import com.copmap.bandobast_service.model.Assignment;
import com.copmap.bandobast_service.model.AssignmentStatus;
import com.copmap.bandobast_service.repository.AssignmentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AssignmentService {

    private final AssignmentRepository repository;

    public AssignmentService(AssignmentRepository repository) {
        this.repository = repository;
    }

    // Create assignment
    public Assignment createAssignment(String bandobastId, String officerId) {
        Assignment a = new Assignment(bandobastId, officerId);
        return repository.save(a);
    }

    // Get all assignments
    public List<Assignment> getAllAssignments() {
        return repository.findAll();
    }

    // Get by ID
    public Assignment getAssignmentById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));
    }

    // Delete assignment
    public void deleteAssignment(String id) {
        repository.deleteById(id);
    }

    // Activate assignment → status ACTIVE
    public Assignment activateAssignment(String id) {
        Assignment a = getAssignmentById(id);

        if (a.getStatus() != AssignmentStatus.CREATED) {
            throw new RuntimeException("Only CREATED assignments can be activated");
        }

        a.setStatus(AssignmentStatus.ACTIVE);
        a.setUpdatedAt(LocalDateTime.now());
        return repository.save(a);
    }

    // Complete assignment → status COMPLETED
    public Assignment completeAssignment(String id) {
        Assignment a = getAssignmentById(id);

        if (a.getStatus() != AssignmentStatus.ACTIVE) {
            throw new RuntimeException("Only ACTIVE assignments can be completed");
        }

        a.setStatus(AssignmentStatus.COMPLETED);
        a.setUpdatedAt(LocalDateTime.now());
        return repository.save(a);
    }
}
