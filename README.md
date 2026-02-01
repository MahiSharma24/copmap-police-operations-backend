Copmap – Police Operations Backend (Bandobast Service)
Overview

This project is a backend service designed to manage police bandobast operations and officer assignments.
It models how police operations are planned, activated, and completed, along with how officers are assigned to those operations.

The focus of this assignment is clean domain modeling, clear business rules, and proper backend layering, not overengineering.

Tech Stack

Java 17

Spring Boot

Spring Data MongoDB

MongoDB

Maven

Project Structure
bandobast_service
└── src
    └── main
        ├── java
        │   └── com.copmap.bandobast_service
        │       ├── CopmapApplication.java
        │       ├── bandobast
        │       │   ├── Bandobast.java
        │       │   ├── BandobastStatus.java
        │       │   ├── BandobastController.java
        │       │   ├── BandobastService.java
        │       │   └── BandobastRepository.java
        │       └── assignment
        │           ├── Assignment.java
        │           ├── AssignmentStatus.java
        │           ├── AssignmentController.java
        │           ├── AssignmentService.java
        │           └── AssignmentRepository.java
        └── resources
            └── application.yml

Domain Model
Bandobast

Represents a police operation.

Statuses

PLANNED → ACTIVE → COMPLETED / CANCELLED


Key Fields

name

location

startTime

endTime

status

assignedOfficerIds

Assignment

Represents assignment of an officer to a bandobast.

Statuses

CREATED → ON_DUTY → COMPLETED / CANCELLED


Key Fields

bandobastId

officerId

status

createdAt

updatedAt

Business Rules

Officers cannot be assigned to a bandobast that is CANCELLED or COMPLETED

When an assignment is created, the officer ID is added to the corresponding bandobast

Status transitions are controlled through the service layer

API Endpoints
Bandobast APIs

POST /api/bandobasts

GET /api/bandobasts

GET /api/bandobasts/{id}

PATCH /api/bandobasts/{id}

DELETE /api/bandobasts/{id}

Assignment APIs

POST /api/assignments

GET /api/assignments

Running the Application
Prerequisites

Java 17+

MongoDB (local or Docker)

Run MongoDB using Docker
docker run -d -p 27017:27017 --name copmap-mongo mongo:6

Run Spring Boot Application
mvn spring-boot:run


Application will start at:

http://localhost:8080

Design Decisions

Monolithic Spring Boot service to keep the system simple

MongoDB used for flexible schema and quick iteration

No authentication or authorization added intentionally

Focus kept on domain clarity and business logic

Future Improvements

Authentication and role-based access

Officer shift management

Geo-based deployment tracking

Audit logs and reporting

Author

Mahi Sharma
GitHub: https://github.com/MahiSharma24
