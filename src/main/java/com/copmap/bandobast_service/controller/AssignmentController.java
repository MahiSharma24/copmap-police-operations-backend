package com.copmap.bandobast_service.controller;

import com.copmap.bandobast_service.model.Assignment;
import com.copmap.bandobast_service.service.AssignmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

    private final AssignmentService service;

    public AssignmentController(AssignmentService service) {
        this.service = service;
    }

    @PostMapping
    public Assignment create(@RequestParam String bandobastId, @RequestParam String officerId) {
        return service.createAssignment(bandobastId, officerId);
    }

    @GetMapping
    public List<Assignment> getAll() {
        return service.getAllAssignments();
    }

    @GetMapping("/{id}")
    public Assignment getById(@PathVariable String id) {
        return service.getAssignmentById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.deleteAssignment(id);
    }

    @PatchMapping("/{id}/activate")
    public Assignment activate(@PathVariable String id) {
        return service.activateAssignment(id);
    }

    @PatchMapping("/{id}/complete")
    public Assignment complete(@PathVariable String id) {
        return service.completeAssignment(id);
    }
}
