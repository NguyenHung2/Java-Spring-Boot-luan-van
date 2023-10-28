package com.api.TravelOptima.service.impl;

import com.api.TravelOptima.model.User;
import com.api.TravelOptima.repository.UserRepository;
import com.api.TravelOptima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Lấy danh sách tất cả người dùng.
     */
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Lấy người dùng dựa trên mã người dùng.
     *
     * @param maNguoiDung Mã người dùng cần tìm.
     * @return Người dùng tương ứng hoặc ném ngoại lệ UserNotFoundException nếu không tìm thấy.
     */
    @Override
    public User getUserByMaNguoiDung(Long maNguoiDung) {
        return userRepository.findByMaNguoiDung(maNguoiDung)
                .orElseThrow(() -> new UserNotFoundException(maNguoiDung));
    }

    /**
     * Tạo một người dùng mới.
     */
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Cập nhật thông tin người dùng dựa trên mã người dùng.
     *
     * @param maNguoiDung Mã người dùng cần cập nhật.
     * @param user Thông tin người dùng cần cập nhật.
     * @return Người dùng sau khi cập nhật hoặc ném ngoại lệ UserNotFoundException nếu không tìm thấy.
     */
    @Override
    public User updateUser(Long maNguoiDung, User user) {
        if (userRepository.existsById(maNguoiDung)) {
            user.setMaNguoiDung(maNguoiDung);
            return userRepository.save(user);
        } else {
            throw new UserNotFoundException(maNguoiDung);
        }
    }

    /**
     * Xóa người dùng dựa trên mã người dùng.
     *
     * @param maNguoiDung Mã người dùng cần xóa.
     */
    @Override
    public void deleteUser(Long maNguoiDung) {
        if (userRepository.existsById(maNguoiDung)) {
            userRepository.deleteById(maNguoiDung);
        } else {
            throw new UserNotFoundException(maNguoiDung);
        }
    }

    /**
     * Lớp ngoại lệ tùy chỉnh để xử lý tình huống khi không tìm thấy người dùng.
     */
    public class UserNotFoundException extends RuntimeException {
        private Long maNguoiDung;

        /**
         * Xây dựng một UserNotFoundException mới với ID người dùng cụ thể.
         *
         * @param maNguoiDung ID của người dùng không được tìm thấy.
         */
        public UserNotFoundException(Long maNguoiDung) {
            super("Không tìm thấy người dùng với mã người dùng: " + maNguoiDung);
            this.maNguoiDung = maNguoiDung;
        }

        /**
         * Lấy ID của người dùng liên quan đến ngoại lệ này.
         *
         * @return ID của người dùng không được tìm thấy.
         */
        public Long getMaNguoiDung() {
            return maNguoiDung;
        }
    }
}
