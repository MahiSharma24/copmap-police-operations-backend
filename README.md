# Copmap Police Operations Backend

Backend service for managing police Bandobast operations and officer assignments.
This project is developed as part of an assignment to demonstrate Spring Boot,
MongoDB, and REST API design.

## Tech Stack

- Java 17
- Spring Boot
- Spring Data MongoDB
- MongoDB
- Maven

## Features

- Create and manage Bandobast operations
- Assign officers to Bandobast
- Track Bandobast and Assignment status
- RESTful APIs with clean layered architecture

## Project Structure

com.copmap.bandobast_service
├── bandobast
│   ├── Bandobast.java
│   ├── BandobastStatus.java
│   ├── BandobastController.java
│   ├── BandobastService.java
│   └── BandobastRepository.java
├── assignment
│   ├── Assignment.java
│   ├── AssignmentStatus.java
│   ├── AssignmentController.java
│   ├── AssignmentService.java
│   └── AssignmentRepository.java
└── CopmapApplication.java

## API Endpoints

Bandobast APIs
- POST   /api/bandobasts
- GET    /api/bandobasts
- GET    /api/bandobasts/{id}
- PATCH  /api/bandobasts/{id}
- DELETE /api/bandobasts/{id}

Assignment APIs
- POST /api/assignments
- GET  /api/assignments

## MongoDB Configuration

application.yml

spring:
  data:
    mongodb:
      uri: mongodb://localhost:27018/copmap
server:
  port: 8080

## Running the Project

Start MongoDB using Docker

docker run -d -p 27018:27017 --name copmap-mongo mongo:6

Run Spring Boot application

mvn spring-boot:run

## Author

Mahi Sharma
GitHub: https://github.com/MahiSharma24
