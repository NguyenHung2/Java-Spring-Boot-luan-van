package com.api.TravelOptima.service;

import com.api.TravelOptima.entity.DestinationRequestDTO;
import com.api.TravelOptima.model.Destination;

import java.util.List;
import java.util.Optional;

public interface DestinationService {
    List<Destination> getAllDestinations();
    Optional<Destination> getDestinationById(Long id);
    Destination createDestination(DestinationRequestDTO destination);
    Destination updateDestination(Long id, Destination updatedDestination);
    void deleteDestination(Long id);
}
