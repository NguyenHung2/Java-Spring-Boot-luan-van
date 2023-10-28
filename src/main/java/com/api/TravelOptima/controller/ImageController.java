package com.api.TravelOptima.controller;

import com.api.TravelOptima.entity.ImageRequestDTO;
import com.api.TravelOptima.model.Image;
import com.api.TravelOptima.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    // Endpoint để tạo một ảnh mới
    @PostMapping
    public ResponseEntity<Image> createImage(@RequestBody ImageRequestDTO imageRequestDTO) {
        Image newImage = imageService.createImage(imageRequestDTO);
        return new ResponseEntity<>(newImage, HttpStatus.CREATED);
    }

    // Endpoint để cập nhật thông tin một ảnh
    @PutMapping("/{maAnh}")
    public ResponseEntity<Image> updateImage(@PathVariable Long maAnh, @RequestBody ImageRequestDTO imageRequestDTO) {
        Image updatedImage = imageService.updateImage(maAnh, imageRequestDTO);
        return new ResponseEntity<>(updatedImage, HttpStatus.OK);
    }

    // Endpoint để lấy thông tin ảnh theo ID
    @GetMapping("/{maAnh}")
    public ResponseEntity<Image> getImage(@PathVariable Long maAnh) {
        Image image = imageService.getImageById(maAnh);
        if (image != null) {
            return new ResponseEntity<>(image, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint để xóa ảnh theo ID
    @DeleteMapping("/{maAnh}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long maAnh) {
        imageService.deleteImage(maAnh);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Endpoint để lấy danh sách tất cả ảnh
    @GetMapping
    public ResponseEntity<List<Image>> getAllImages() {
        List<Image> images = imageService.getAllImages();
        if (!images.isEmpty()) {
            return new ResponseEntity<>(images, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
