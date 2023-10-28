package com.api.TravelOptima.service.impl;

import com.api.TravelOptima.entity.ImageRequestDTO;
import com.api.TravelOptima.model.Destination;
import com.api.TravelOptima.model.Image;
import com.api.TravelOptima.model.Post;
import com.api.TravelOptima.repository.DestinationRepository;
import com.api.TravelOptima.repository.ImageRepository;
import com.api.TravelOptima.repository.PostRepository;
import com.api.TravelOptima.service.ImageService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;
    private final DestinationRepository destinationRepository;
    private final PostRepository postRepository;

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository, DestinationRepository destinationRepository, PostRepository postRepository) {
        this.imageRepository = imageRepository;
        this.destinationRepository = destinationRepository;
        this.postRepository = postRepository;
    }

    @Override
    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    @Override
    public Image getImageById(Long maAnh) {
        return imageRepository.findById(maAnh).orElse(null);
    }

    @Override
    public Image createImage(ImageRequestDTO imageRequestDTO) {
        // Kiểm tra xem maDiemDen và maBaiViet có tồn tại
        Destination destination = destinationRepository.findById(imageRequestDTO.getMaDiemDen()).orElse(null);
        Post post = postRepository.findById(imageRequestDTO.getMaBaiViet()).orElse(null);

        if (destination == null || post == null) {
            throw new EntityNotFoundException("Không tìm thấy Điểm đến hoặc Bài viết");
        }

        Image newImage = new Image();
        newImage.setTenAnh(imageRequestDTO.getTenAnh());
        newImage.setDuongDan(imageRequestDTO.getDuongDan());
        newImage.setNgayTao(imageRequestDTO.getNgayTao());
        newImage.setDiemDen(destination);
        newImage.setBaiViet(post);

        return imageRepository.save(newImage);
    }

    @Override
    public Image updateImage(Long maAnh, ImageRequestDTO imageRequestDTO) {
        // Kiểm tra xem maDiemDen và maBaiViet có tồn tại
        Destination destination = destinationRepository.findById(imageRequestDTO.getMaDiemDen()).orElse(null);
        Post post = postRepository.findById(imageRequestDTO.getMaBaiViet()).orElse(null);

        if (destination == null || post == null) {
            throw new EntityNotFoundException("Destination or Post not found");
        }

        Image existingImage = imageRepository.findById(maAnh).orElse(null);

        if (existingImage != null) {
            existingImage.setTenAnh(imageRequestDTO.getTenAnh());
            existingImage.setDuongDan(imageRequestDTO.getDuongDan());
            existingImage.setNgayTao(imageRequestDTO.getNgayTao());
            existingImage.setDiemDen(destination);
            existingImage.setBaiViet(post);

            return imageRepository.save(existingImage);
        }

        return null;
    }

    @Override
    public void deleteImage(Long maAnh) {
        imageRepository.deleteById(maAnh);
    }
}

