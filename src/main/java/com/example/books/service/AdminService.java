package com.example.books.service;

import com.example.books.model.Admin;
import com.example.books.web.dto.AdminRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AdminService extends UserDetailsService {
    Admin save(AdminRegistrationDto registrationDto);
}
