package com.api.TravelOptima.controller;

import com.api.TravelOptima.entity.DestinationRequestDTO;
import com.api.TravelOptima.model.Destination;
import com.api.TravelOptima.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/destinations")
public class DestinationController {
    private final DestinationService destinationService;

    @Autowired
    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @GetMapping
    public List<Destination> getAllDestinations() {
        return destinationService.getAllDestinations();
    }

    @GetMapping("/{id}")
    public Destination getDestinationById(@PathVariable Long id) {
        return destinationService.getDestinationById(id).orElse(null);
    }

    @PostMapping
    public ResponseEntity<Destination> createDestination(@RequestBody DestinationRequestDTO requestDTO) {
        Destination createdDestination = destinationService.createDestination(requestDTO);
        return new ResponseEntity<>(createdDestination, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public Destination updateDestination(@PathVariable Long id, @RequestBody Destination updatedDestination) {
        return destinationService.updateDestination(id, updatedDestination);
    }

    @DeleteMapping("/{id}")
    public void deleteDestination(@PathVariable Long id) {
        destinationService.deleteDestination(id);
    }
}
