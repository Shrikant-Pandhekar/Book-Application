package com.example.books.service;

import com.example.books.model.User;
import com.example.books.web.dto.UserAddDto;

import java.util.List;

public interface UserService {
    User save(UserAddDto userAddDto);
    User update(User user);

    User getUserById(Long id);

    List<User> getAllUser();


    void deleteUserById(Long id);
}
