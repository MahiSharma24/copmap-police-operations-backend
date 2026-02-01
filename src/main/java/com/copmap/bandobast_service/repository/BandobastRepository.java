package com.copmap.bandobast_service.repository;

import com.copmap.bandobast_service.model.Bandobast;
import com.copmap.bandobast_service.model.BandobastStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BandobastRepository extends MongoRepository<Bandobast, String> {
    List<Bandobast> findByStatus(BandobastStatus status); // optional filter
}
