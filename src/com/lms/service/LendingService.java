package com.lms.service;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.lms.Book;
import com.lms.LendingRecord;
import com.lms.Patron;

public class LendingService {
    private final List<LendingRecord> lendingRecords = new ArrayList<>();
    private final BookService bookService;
    private final PatronService patronService;

    private static final Logger logger = Logger.getLogger(LendingService.class.getName());

    public LendingService(BookService bookService, PatronService patronService) {
        this.bookService = bookService;
        this.patronService = patronService;
    }

    // Checkout a book
    public void checkoutBook(String isbn, String patronId) {
        Book book = bookService.searchByIsbn(isbn);
        Patron patron = patronService.getPatronById(patronId);

        if (book == null) {
            logger.warning("Checkout failed. Book not found: " + isbn);
            return;
        }

        if (!book.isAvailable()) {
            logger.warning("Checkout failed. Book is already borrowed: " + book);
            return;
        }

        if (patron == null) {
            logger.warning("Checkout failed. Patron not found: " + patronId);
            return;
        }

        // Update book availability
        book.setAvailable(false);

        // Create lending record
        LendingRecord record = new LendingRecord(book, patron);
        lendingRecords.add(record);

        // Add to patron history
        patron.addToBorrowingHistory(book);

        logger.info("Book checked out successfully: " + record);
    }

    // Return a book
    public void returnBook(String isbn, String patronId) {
        for (LendingRecord record : lendingRecords) {
            if (record.getBook().getIsbn().equals(isbn)
                    && record.getPatron().getPatronId().equals(patronId)
                    && !record.isReturned()) {

                record.returnBook();
                record.getBook().setAvailable(true);

                logger.info("Book returned successfully: " + record);
                return;
            }
        }

        logger.warning("Return failed. No active lending record found for book " + isbn + " and patron " + patronId);
    }

    // Get all active lending records (not returned yet)
    public List<LendingRecord> getActiveLendings() {
        return lendingRecords.stream()
                .filter(record -> !record.isReturned())
                .collect(Collectors.toList());
    }


    // Get lending records for a specific patron
    public List<LendingRecord> getLendingsByPatron(String patronId) {
        return lendingRecords.stream()
                .filter(record -> record.getPatron().getPatronId().equals(patronId))
                .collect(Collectors.toList());
    }


    // Get all lending records
    public List<LendingRecord> getAllLendings() {
        return new ArrayList<>(lendingRecords);
    }
}

