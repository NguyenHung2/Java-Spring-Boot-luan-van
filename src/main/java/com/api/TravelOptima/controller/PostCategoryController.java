package com.api.TravelOptima.controller;

import com.api.TravelOptima.model.PostCategory;
import com.api.TravelOptima.service.PostCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/post-categories")
public class PostCategoryController {
    @Autowired
    private PostCategoryService postCategoryService;

    // Lấy danh sách tất cả các danh mục
    @GetMapping
    public List<PostCategory> getAllCategories() {
        return postCategoryService.getAllCategories();
    }

    // Lấy một danh mục dựa trên mã loại
    @GetMapping("/{maLoai}")
    public PostCategory getCategoryById(@PathVariable Long maLoai) {
        return postCategoryService.getCategoryById(maLoai);
    }

    // Tạo một danh mục mới
    @PostMapping
    public PostCategory createCategory(@RequestBody PostCategory category) {
        return postCategoryService.createCategory(category);
    }

    // Cập nhật một danh mục dựa trên mã loại
    @PutMapping("/{maLoai}")
    public PostCategory updateCategory(@PathVariable Long maLoai, @RequestBody PostCategory category) {
        return postCategoryService.updateCategory(maLoai, category);
    }

    // Xóa một danh mục dựa trên mã loại
    @DeleteMapping("/{maLoai}")
    public void deleteCategory(@PathVariable Long maLoai) {
        postCategoryService.deleteCategory(maLoai);
    }
}
