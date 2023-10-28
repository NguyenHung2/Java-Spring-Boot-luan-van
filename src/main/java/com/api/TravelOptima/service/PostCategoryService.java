package com.api.TravelOptima.service;

import com.api.TravelOptima.model.PostCategory;

import java.util.List;

public interface PostCategoryService {
    List<PostCategory> getAllCategories();
    PostCategory getCategoryById(Long maLoai);
    PostCategory createCategory(PostCategory category);
    PostCategory updateCategory(Long maLoai, PostCategory category);
    void deleteCategory(Long maLoai);
}
