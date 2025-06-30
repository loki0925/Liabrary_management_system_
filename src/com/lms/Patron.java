package com.lms;

import java.util.ArrayList;
import java.util.List;

public class Patron {
    private final String patronId;
    private String name;
    private String email;
    private final List<Book> borrowingHistory = new ArrayList<>();

    public Patron(String patronId, String name, String email) {
        this.patronId = patronId;
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
    public String getPatronId() { return patronId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public List<Book> getBorrowingHistory() { return borrowingHistory; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }

    public void addToBorrowingHistory(Book book) {
        borrowingHistory.add(book);
    }

    @Override
    public String toString() {
        return String.format("Patron [%s]: %s <%s>", patronId, name, email);
    }
}

