package com.api.TravelOptima.service.impl;

import com.api.TravelOptima.model.PostCategory;
import com.api.TravelOptima.repository.PostCategoryRepository;
import com.api.TravelOptima.service.PostCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostCategoryServiceImpl implements PostCategoryService {
    @Autowired
    private PostCategoryRepository postCategoryRepository;

    @Override
    public List<PostCategory> getAllCategories() {
        return postCategoryRepository.findAll();
    }

    @Override
    public PostCategory getCategoryById(Long maLoai) {
        Optional<PostCategory> categoryOptional = postCategoryRepository.findById(maLoai);
        if (categoryOptional.isPresent()) {
            return categoryOptional.get();
        }
        throw new RuntimeException("Danh mục không tồn tại");
    }

    @Override
    public PostCategory createCategory(PostCategory category) {
        return postCategoryRepository.save(category);
    }

    @Override
    public PostCategory updateCategory(Long maLoai, PostCategory category) {
        if (postCategoryRepository.existsById(maLoai)) {
            category.setMaLoai(maLoai);
            return postCategoryRepository.save(category);
        }
        throw new RuntimeException("Danh mục không tồn tại");
    }

    @Override
    public void deleteCategory(Long maLoai) {
        if (postCategoryRepository.existsById(maLoai)) {
            postCategoryRepository.deleteById(maLoai);
        } else {
            throw new RuntimeException("Danh mục không tồn tại");
        }
    }
}
