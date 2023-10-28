package com.api.TravelOptima.service;

import com.api.TravelOptima.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserByMaNguoiDung(Long maNguoiDung);

    User createUser(User user);

    User updateUser(Long maNguoiDung, User user);

    void deleteUser(Long maNguoiDung);
}
