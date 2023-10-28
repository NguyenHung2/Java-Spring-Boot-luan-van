package com.api.TravelOptima.controller;

import com.api.TravelOptima.model.DestinationCategory;
import com.api.TravelOptima.repository.DestinationCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/destination-categories")
public class DestinationCategoryController {
    @Autowired
    private DestinationCategoryRepository destinationCategoryRepository;

    @GetMapping
    public List<DestinationCategory> getAllCategories() {
        return destinationCategoryRepository.findAll();
    }

    @GetMapping("/{maDanhMuc}")
    public Optional<DestinationCategory> getCategoryById(@PathVariable Long maDanhMuc) {
        return destinationCategoryRepository.findById(maDanhMuc);
    }

    @PostMapping
    public DestinationCategory createCategory(@RequestBody DestinationCategory category) {
        return destinationCategoryRepository.save(category);
    }

    @PutMapping("/{maDanhMuc}")
    public DestinationCategory updateCategory(@PathVariable Long maDanhMuc, @RequestBody DestinationCategory updatedCategory) {
        if (destinationCategoryRepository.existsById(maDanhMuc)) {
            updatedCategory.setMaDanhMuc(maDanhMuc);
            return destinationCategoryRepository.save(updatedCategory);
        } else {
            throw new RuntimeException("Category not found with ID: " + maDanhMuc);
        }
    }

    @DeleteMapping("/{maDanhMuc}")
    public void deleteCategory(@PathVariable Long maDanhMuc) {
        destinationCategoryRepository.deleteById(maDanhMuc);
    }
}
