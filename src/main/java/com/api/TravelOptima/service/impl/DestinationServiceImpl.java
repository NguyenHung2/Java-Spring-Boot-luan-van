package com.api.TravelOptima.service.impl;

import com.api.TravelOptima.entity.DestinationRequestDTO;
import com.api.TravelOptima.model.Destination;
import com.api.TravelOptima.model.DestinationCategory;
import com.api.TravelOptima.repository.DestinationCategoryRepository;
import com.api.TravelOptima.repository.DestinationRepository;
import com.api.TravelOptima.service.DestinationService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DestinationServiceImpl implements DestinationService {
    private final DestinationRepository destinationRepository;
    private final DestinationCategoryRepository destinationCategoryRepository;

    @Autowired
    public DestinationServiceImpl(DestinationRepository destinationRepository, DestinationCategoryRepository destinationCategoryRepository) {
        this.destinationRepository = destinationRepository;
        this.destinationCategoryRepository = destinationCategoryRepository;
    }

    @Override
    public List<Destination> getAllDestinations() {
        return destinationRepository.findAll();
    }

    @Override
    public Optional<Destination> getDestinationById(Long id) {
        return destinationRepository.findById(id);
    }

    public Destination createDestination(DestinationRequestDTO requestDTO) {
        // Tạo một đối tượng Destination từ DTO
        Destination destination = new Destination();
        destination.setTenDiemDen(requestDTO.getTenDiemDen());
        destination.setKinhDo(requestDTO.getKinhDo());
        destination.setViDo(requestDTO.getViDo());
        destination.setMoTa(requestDTO.getMoTa());
        destination.setDiaChi(requestDTO.getDiaChi());
        destination.setNgayTao(requestDTO.getNgayTao());

        // Tìm danh mục dựa trên mã danh mục
        DestinationCategory danhMuc = destinationCategoryRepository.findById(requestDTO.getMaDanhMuc()).orElse(null);

        if (danhMuc != null) {
            // DestinationCategory tồn tại, gán nó vào Destination
            destination.setDanhmuc(danhMuc);

            // Lưu Destination
            Destination savedDestination = destinationRepository.save(destination);


            return savedDestination;
        } else {
            // Xử lý trường hợp danh mục không tồn tại
            throw new EntityNotFoundException("Không tìm thấy danh mục với mã danh mục đã cung cấp.");
        }
    }


    @Override
    public Destination updateDestination(Long id, Destination updatedDestination) {
        if (destinationRepository.existsById(id)) {
            updatedDestination.setMaDiemDen(id);
            return destinationRepository.save(updatedDestination);
        }
        return null; // Handle the case when the destination with the given id doesn't exist
    }

    @Override
    public void deleteDestination(Long id) {
        destinationRepository.deleteById(id);
    }
}
