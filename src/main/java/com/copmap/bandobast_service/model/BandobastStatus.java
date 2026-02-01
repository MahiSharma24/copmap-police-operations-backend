package com.copmap.bandobast_service.model;

public enum BandobastStatus {
    PLANNED,    // Created but not yet active
    ACTIVE,     // Currently in operation / assigned
    COMPLETED,  // Finished successfully
    CANCELLED   // Aborted
}
