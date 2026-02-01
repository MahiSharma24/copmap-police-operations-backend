package com.copmap.bandobast_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "assignments")
public class Assignment {

    @Id
    private String id;

    private String bandobastId;   // Link to the Bandobast
    private String officerId;     // Officer assigned
    private AssignmentStatus status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Constructors
    public Assignment() {}

    public Assignment(String bandobastId, String officerId) {
        this.bandobastId = bandobastId;
        this.officerId = officerId;
        this.status = AssignmentStatus.CREATED;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Getters and setters
    public String getId() { return id; }

    public String getBandobastId() { return bandobastId; }
    public void setBandobastId(String bandobastId) { this.bandobastId = bandobastId; }

    public String getOfficerId() { return officerId; }
    public void setOfficerId(String officerId) { this.officerId = officerId; }

    public AssignmentStatus getStatus() { return status; }
    public void setStatus(AssignmentStatus status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
