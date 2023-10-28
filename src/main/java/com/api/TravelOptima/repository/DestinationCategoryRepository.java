package com.api.TravelOptima.repository;

import com.api.TravelOptima.model.DestinationCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationCategoryRepository extends JpaRepository<DestinationCategory, Long> {
}
