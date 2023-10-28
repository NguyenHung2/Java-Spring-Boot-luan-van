package com.api.TravelOptima.controller;

import com.api.TravelOptima.entity.PostRequestDTO;
import com.api.TravelOptima.model.Post;
import com.api.TravelOptima.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    // Endpoint để lấy tất cả bài viết
    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    // Endpoint để lấy bài viết theo ID
    @GetMapping("/{maBaiViet}")
    public ResponseEntity<Post> getPost(@PathVariable Long maBaiViet) {
        Post post = postService.getPostById(maBaiViet);
        if (post != null) {
            return new ResponseEntity<>(post, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint để tạo mới bài viết
    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostRequestDTO postRequestDTO) {
        Post newPost = postService.createPost(postRequestDTO);
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }

    // Endpoint để cập nhật thông tin bài viết
    @PutMapping("/{maBaiViet}")
    public ResponseEntity<Post> updatePost(@PathVariable Long maBaiViet, @RequestBody PostRequestDTO postRequestDTO) {
        Post updatedPost = postService.updatePost(maBaiViet, postRequestDTO);
        if (updatedPost != null) {
            return new ResponseEntity<>(updatedPost, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint để xóa bài viết theo ID
    @DeleteMapping("/{maBaiViet}")
    public ResponseEntity<Void> deletePost(@PathVariable Long maBaiViet) {
        postService.deletePost(maBaiViet);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
