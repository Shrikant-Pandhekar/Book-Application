package com.example.books.service;

import com.example.books.model.Book;
import com.example.books.repository.BookRepository;
import com.example.books.web.dto.BookAddDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(BookAddDto bookAddDto) {
        Book b = new Book(bookAddDto.getBook_name(), bookAddDto.getAuthor());
        return bookRepository.save(b);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public Book update(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
