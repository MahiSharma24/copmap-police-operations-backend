package com.copmap.bandobast_service.controller;

import com.copmap.bandobast_service.model.Bandobast;
import com.copmap.bandobast_service.service.BandobastService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bandobasts")
public class BandobastController {

    private final BandobastService service;

    public BandobastController(BandobastService service) {
        this.service = service;
    }

    @PostMapping
    public Bandobast create(@RequestBody Bandobast bandobast) {
        return service.createBandobast(bandobast);
    }

    @GetMapping
    public List<Bandobast> getAll() {
        return service.getAllBandobasts();
    }

    @GetMapping("/{id}")
    public Bandobast getById(@PathVariable String id) {
        return service.getBandobastById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.deleteBandobast(id);
    }

    @PatchMapping("/{id}/assign")
    public Bandobast assignOfficer(@PathVariable String id, @RequestParam String officerId) {
        return service.assignOfficer(id, officerId);
    }

    @PatchMapping("/{id}/close")
    public Bandobast close(@PathVariable String id) {
        return service.closeBandobast(id);
    }

    @PatchMapping("/{id}/cancel")
    public Bandobast cancel(@PathVariable String id) {
        return service.cancelBandobast(id);
    }
}
