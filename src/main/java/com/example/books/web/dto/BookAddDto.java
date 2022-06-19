package com.example.books.web.dto;

public class BookAddDto {
    private String book_name;
    private String author;

    public BookAddDto() {
    }

    public BookAddDto(String book_name, String author) {
        this.book_name = book_name;
        this.author = author;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
