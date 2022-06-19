package com.example.books.service;

import com.example.books.model.User;
import com.example.books.repository.UserRepository;
import com.example.books.web.dto.UserAddDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserAddDto userAddDto) {
       User user = new User(userAddDto.getFirstName(),userAddDto.getLastName(), userAddDto.getEmail(), userAddDto.getPassword());
       return userRepository.save(user);
    }

    @Override
    public User update(User u) {
        return userRepository.save(u);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
