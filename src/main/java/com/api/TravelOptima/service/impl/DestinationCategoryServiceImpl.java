package com.api.TravelOptima.service.impl;

import com.api.TravelOptima.model.DestinationCategory;
import com.api.TravelOptima.repository.DestinationCategoryRepository;
import com.api.TravelOptima.service.DestinationCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DestinationCategoryServiceImpl implements DestinationCategoryService {
    @Autowired
    private DestinationCategoryRepository destinationCategoryRepository;

    @Override
    public List<DestinationCategory> getAllCategories() {
        return destinationCategoryRepository.findAll();
    }

    @Override
    public Optional<DestinationCategory> getCategoryById(Long maDanhMuc) {
        return destinationCategoryRepository.findById(maDanhMuc);
    }

    @Override
    public DestinationCategory createCategory(DestinationCategory category) {
        return destinationCategoryRepository.save(category);
    }

    @Override
    public DestinationCategory updateCategory(Long maDanhMuc, DestinationCategory updatedCategory) {
        if (destinationCategoryRepository.existsById(maDanhMuc)) {
            updatedCategory.setMaDanhMuc(maDanhMuc);
            return destinationCategoryRepository.save(updatedCategory);
        } else {
            throw new RuntimeException("Category not found with ID: " + maDanhMuc);
        }
    }

    @Override
    public void deleteCategory(Long maDanhMuc) {
        destinationCategoryRepository.deleteById(maDanhMuc);
    }
}
