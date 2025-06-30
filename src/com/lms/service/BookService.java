package com.lms.service;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.lms.Book;

public class BookService {
    private final Map<String, Book> bookInventory = new HashMap<>();
    private static final Logger logger = Logger.getLogger(BookService.class.getName());

    // Add a book to the inventory
    public void addBook(Book book) {
        if (bookInventory.containsKey(book.getIsbn())) {
            logger.warning("Book with ISBN already exists: " + book.getIsbn());
            return;
        }
        bookInventory.put(book.getIsbn(), book);
        logger.info("Book added: " + book);
    }

    // Remove a book by ISBN
    public void removeBook(String isbn) {
        Book removed = bookInventory.remove(isbn);
        if (removed != null) {
            logger.info("Book removed: " + removed);
        } else {
            logger.warning("No book found with ISBN: " + isbn);
        }
    }

    // Update an existing book
    public void updateBook(String isbn, String title, String author, int year) {
        Book book = bookInventory.get(isbn);
        if (book != null) {
            book.setTitle(title);
            book.setAuthor(author);
            book.setPublicationYear(year);
            logger.info("Book updated: " + book);
        } else {
            logger.warning("No book found to update with ISBN: " + isbn);
        }
    }

    // Search by title (partial match)
    public List<Book> searchByTitle(String title) {
        return bookInventory.values().stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    // Search by author (partial match)
    public List<Book> searchByAuthor(String author) {
        return bookInventory.values().stream()
                .filter(book -> book.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .collect(Collectors.toList());
    }

    // Search by ISBN (exact match)
    public Book searchByIsbn(String isbn) {
        return bookInventory.get(isbn);
    }

    // Get all books
    public List<Book> getAllBooks() {
        return new ArrayList<>(bookInventory.values());
    }

    // Get available books only
    public List<Book> getAvailableBooks() {
        return bookInventory.values().stream()
                .filter(Book::isAvailable)
                .collect(Collectors.toList());
    }
}

