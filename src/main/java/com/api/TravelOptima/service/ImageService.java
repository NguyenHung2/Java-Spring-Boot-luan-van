package com.api.TravelOptima.service;

import com.api.TravelOptima.entity.ImageRequestDTO;
import com.api.TravelOptima.model.Image;
import java.util.List;

public interface ImageService {

    List<Image> getAllImages();

    Image getImageById(Long maAnh);

    Image createImage(ImageRequestDTO imageRequestDTO);

    Image updateImage(Long maAnh, ImageRequestDTO imageRequestDTO);

    void deleteImage(Long maAnh);
}
