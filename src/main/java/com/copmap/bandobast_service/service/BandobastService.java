package com.copmap.bandobast_service.service;

import com.copmap.bandobast_service.model.Bandobast;
import com.copmap.bandobast_service.model.BandobastStatus;
import com.copmap.bandobast_service.repository.BandobastRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BandobastService {

    private final BandobastRepository repository;

    public BandobastService(BandobastRepository repository) {
        this.repository = repository;
    }

    // Create new bandobast
    public Bandobast createBandobast(Bandobast bandobast) {
        if (bandobast.getStatus() == null) {
            bandobast.setStatus(BandobastStatus.PLANNED);
        }
        return repository.save(bandobast);
    }

    // Get all bandobasts
    public List<Bandobast> getAllBandobasts() {
        return repository.findAll();
    }

    // Get bandobast by ID
    public Bandobast getBandobastById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bandobast not found"));
    }

    // Delete bandobast
    public void deleteBandobast(String id) {
        repository.deleteById(id);
    }

    // Assign officer to bandobast → sets status to ACTIVE
    public Bandobast assignOfficer(String bandobastId, String officerId) {
        Bandobast b = getBandobastById(bandobastId);

        if (b.getStatus() == BandobastStatus.COMPLETED || b.getStatus() == BandobastStatus.CANCELLED) {
            throw new RuntimeException("Cannot assign officer to completed or cancelled bandobast");
        }

        if (!b.getAssignedOfficerIds().contains(officerId)) {
            b.getAssignedOfficerIds().add(officerId);
        }

        b.setStatus(BandobastStatus.ACTIVE);
        return repository.save(b);
    }

    // Close bandobast → sets status to COMPLETED
    public Bandobast closeBandobast(String bandobastId) {
        Bandobast b = getBandobastById(bandobastId);

        if (b.getStatus() != BandobastStatus.ACTIVE) {
            throw new RuntimeException("Only ACTIVE bandobasts can be closed");
        }

        b.setStatus(BandobastStatus.COMPLETED);
        return repository.save(b);
    }

    // Cancel bandobast
    public Bandobast cancelBandobast(String bandobastId) {
        Bandobast b = getBandobastById(bandobastId);

        if (b.getStatus() == BandobastStatus.COMPLETED) {
            throw new RuntimeException("Cannot cancel a completed bandobast");
        }

        b.setStatus(BandobastStatus.CANCELLED);
        return repository.save(b);
    }
}
