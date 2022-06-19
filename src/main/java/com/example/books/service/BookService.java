package com.example.books.service;

import com.example.books.model.Book;
import com.example.books.web.dto.BookAddDto;

import java.util.List;

public interface BookService {
    Book save(BookAddDto bookAddDto);
    List<Book> getAllBooks();
    Book getBookById(Long id);
    Book update(Book book);
    void delete(Long id);
}
