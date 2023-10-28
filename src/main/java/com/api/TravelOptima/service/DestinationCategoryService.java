package com.api.TravelOptima.service;

import com.api.TravelOptima.model.DestinationCategory;

import java.util.List;
import java.util.Optional;

public interface DestinationCategoryService {
    List<DestinationCategory> getAllCategories();
    Optional<DestinationCategory> getCategoryById(Long maDanhMuc);
    DestinationCategory createCategory(DestinationCategory category);
    DestinationCategory updateCategory(Long maDanhMuc, DestinationCategory updatedCategory);
    void deleteCategory(Long maDanhMuc);
}
