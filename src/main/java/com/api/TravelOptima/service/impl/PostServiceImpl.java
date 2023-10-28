package com.api.TravelOptima.service.impl;

import com.api.TravelOptima.entity.PostRequestDTO;
import com.api.TravelOptima.model.Post;
import com.api.TravelOptima.model.PostCategory;
import com.api.TravelOptima.repository.PostCategoryRepository;
import com.api.TravelOptima.repository.PostRepository;
import com.api.TravelOptima.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostCategoryRepository postCategoryRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, PostCategoryRepository postCategoryRepository) {
        this.postRepository = postRepository;
        this.postCategoryRepository = postCategoryRepository;
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Long maBaiViet) {
        Optional<Post> post = postRepository.findById(maBaiViet);
        return post.orElse(null);
    }

    @Override
    public Post createPost(PostRequestDTO postRequestDTO) {
        PostCategory postCategory = postCategoryRepository.findById(postRequestDTO.getMaLoai())
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy danh mục bài viết"));

        Post newPost = new Post(
                postRequestDTO.getTieuDe(),
                postRequestDTO.getTomTat(),
                postRequestDTO.getNoiDung(),
                postRequestDTO.getNgayTao(),
                postCategory
        );

        return postRepository.save(newPost);
    }

    @Override
    public Post updatePost(Long maBaiViet, PostRequestDTO postRequestDTO) {
        Post existingPost = postRepository.findById(maBaiViet)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy bài viết"));

        existingPost.setTieuDe(postRequestDTO.getTieuDe());
        existingPost.setTomTat(postRequestDTO.getTomTat());
        existingPost.setNoiDung(postRequestDTO.getNoiDung());
        existingPost.setNgayTao(postRequestDTO.getNgayTao());

        PostCategory postCategory = postCategoryRepository.findById(postRequestDTO.getMaLoai())
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy danh mục bài viết"));
        existingPost.setLoai(postCategory);

        return postRepository.save(existingPost);
    }

    @Override
    public void deletePost(Long maBaiViet) {
        postRepository.deleteById(maBaiViet);
    }
}
