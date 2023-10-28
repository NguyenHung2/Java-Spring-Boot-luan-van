package com.api.TravelOptima.repository;

import com.api.TravelOptima.model.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCategoryRepository extends JpaRepository<PostCategory, Long> {
    // Bạn có thể thêm các phương thức tùy chỉnh tại đây nếu cần
}
