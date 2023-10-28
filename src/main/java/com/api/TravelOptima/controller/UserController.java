package com.api.TravelOptima.controller;

import com.api.TravelOptima.model.User;
import com.api.TravelOptima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Lấy danh sách tất cả người dùng
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Lấy thông tin người dùng theo mã người dùng
    @GetMapping("/{maNguoiDung}")
    public User getUserByMaNguoiDung(@PathVariable Long maNguoiDung) {
        return userService.getUserByMaNguoiDung(maNguoiDung);
    }

    // Tạo một người dùng mới
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // Cập nhật thông tin người dùng theo mã người dùng
    @PutMapping("/{maNguoiDung}")
    public User updateUser(@PathVariable Long maNguoiDung, @RequestBody User user) {
        return userService.updateUser(maNguoiDung, user);
    }

    // Xóa người dùng theo mã người dùng
    @DeleteMapping("/{maNguoiDung}")
    public void deleteUser(@PathVariable Long maNguoiDung) {
        userService.deleteUser(maNguoiDung);
    }
}
