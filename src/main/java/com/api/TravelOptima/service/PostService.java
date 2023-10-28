package com.api.TravelOptima.service;

import com.api.TravelOptima.entity.PostRequestDTO;
import com.api.TravelOptima.model.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();
    Post getPostById(Long maBaiViet);
    Post createPost(PostRequestDTO postRequestDTO);
    Post updatePost(Long maBaiViet, PostRequestDTO postRequestDTO);
    void deletePost(Long maBaiViet);
}
