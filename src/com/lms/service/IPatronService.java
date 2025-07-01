package com.lms.service;

import java.util.List;

import com.lms.Book;
import com.lms.Patron;

public interface IPatronService {
    void addPatron(Patron patron);
    void updatePatron(String patronId, String name, String email);
    Patron getPatronById(String patronId);
    List<Patron> searchByName(String name);
    List<Patron> getAllPatrons();
    List<Book> getBorrowingHistory(String patronId);
}

