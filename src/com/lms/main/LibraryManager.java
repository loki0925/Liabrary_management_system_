package com.lms.main;

import java.util.List;

import com.lms.Book;
import com.lms.Patron;
import com.lms.service.BookService;
import com.lms.service.IBookService;
import com.lms.service.ILendingService;
import com.lms.service.IPatronService;
import com.lms.service.LendingService;
import com.lms.service.PatronService;

public class LibraryManager {
	private final IBookService bookService;
    private final IPatronService patronService;
    private final ILendingService lendingService;

    public LibraryManager(IBookService bookService, IPatronService patronService, ILendingService lendingService) {
        this.bookService = bookService;
        this.patronService = patronService;
        this.lendingService = lendingService;
    }
    public LibraryManager() {
        this.bookService = new BookService();
        this.patronService = new PatronService();
        this.lendingService = new LendingService(bookService, patronService);
    }

    // Book operations
    public void addBook(String isbn, String title, String author, int year) {
        Book book = new Book(isbn, title, author, year);
        bookService.addBook(book);
    }

    public void removeBook(String isbn) {
        bookService.removeBook(isbn);
    }

    public void updateBook(String isbn, String title, String author, int year) {
        bookService.updateBook(isbn, title, author, year);
    }

    public void searchBooksByTitle(String title) {
        List<Book> results = bookService.searchByTitle(title);
        results.forEach(System.out::println);
    }

    public void searchBooksByAuthor(String author) {
        List<Book> results = bookService.searchByAuthor(author);
        results.forEach(System.out::println);
    }

    public void listAllBooks() {
        bookService.getAllBooks().forEach(System.out::println);
    }

    // Patron operations
    public void addPatron(String id, String name, String email) {
        Patron patron = new Patron(id, name, email);
        patronService.addPatron(patron);
    }

    public void updatePatron(String id, String name, String email) {
        patronService.updatePatron(id, name, email);
    }

    public void listAllPatrons() {
        patronService.getAllPatrons().forEach(System.out::println);
    }

    public void viewBorrowingHistory(String patronId) {
        List<Book> history = patronService.getBorrowingHistory(patronId);
        history.forEach(System.out::println);
    }

    // Lending operations
    public void checkoutBook(String isbn, String patronId) {
        lendingService.checkoutBook(isbn, patronId);
    }

    public void returnBook(String isbn, String patronId) {
        lendingService.returnBook(isbn, patronId);
    }

    public void viewAllLendingRecords() {
        lendingService.getAllLendings().forEach(System.out::println);
    }

    public void viewActiveLendings() {
        lendingService.getAllLendings().forEach(System.out::println);
    }
}

