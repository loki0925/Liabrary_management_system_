package com.lms.service;

import java.util.List;

import com.lms.Book;

public interface IBookService {
    void addBook(Book book);
    void removeBook(String isbn);
    void updateBook(String isbn, String title, String author, int year);
    List<Book> searchByTitle(String title);
    List<Book> searchByAuthor(String author);
    Book searchByIsbn(String isbn);
    List<Book> getAllBooks();
    List<Book> getAvailableBooks();
}

