package com.copmap.bandobast_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "bandobasts")
public class Bandobast {

    @Id
    private String id;

    private String name;
    private String location;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private BandobastStatus status;

    private List<String> assignedOfficerIds = new ArrayList<>();

    // Constructors
    public Bandobast() {}

    public Bandobast(String name, String location, LocalDateTime startTime, LocalDateTime endTime) {
        this.name = name;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = BandobastStatus.PLANNED;
    }

    // Getters and setters
    public String getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }

    public BandobastStatus getStatus() { return status; }
    public void setStatus(BandobastStatus status) { this.status = status; }

    public List<String> getAssignedOfficerIds() { return assignedOfficerIds; }
    public void setAssignedOfficerIds(List<String> assignedOfficerIds) { this.assignedOfficerIds = assignedOfficerIds; }
}
