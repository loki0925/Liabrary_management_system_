package com.lms.service;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.lms.Book;
import com.lms.Patron;

public class PatronService {
    private final Map<String, Patron> patronRegistry = new HashMap<>();
    private static final Logger logger = Logger.getLogger(PatronService.class.getName());

    // Add a new patron
    public void addPatron(Patron patron) {
        if (patronRegistry.containsKey(patron.getPatronId())) {
            logger.warning("Patron with ID already exists: " + patron.getPatronId());
            return;
        }
        patronRegistry.put(patron.getPatronId(), patron);
        logger.info("New patron added: " + patron);
    }

    // Update existing patron details
    public void updatePatron(String patronId, String name, String email) {
        Patron patron = patronRegistry.get(patronId);
        if (patron != null) {
            patron.setName(name);
            patron.setEmail(email);
            logger.info("Patron updated: " + patron);
        } else {
            logger.warning("No patron found with ID: " + patronId);
        }
    }

    // Retrieve a patron by ID
    public Patron getPatronById(String patronId) {
        return patronRegistry.get(patronId);
    }

    // Get a patron's borrowing history
    public List<Book> getBorrowingHistory(String patronId) {
        Patron patron = patronRegistry.get(patronId);
        if (patron != null) {
            return patron.getBorrowingHistory();
        }
        logger.warning("No patron found with ID for history: " + patronId);
        return Collections.emptyList();
    }

    // Search patrons by name (partial match)
    public List<Patron> searchByName(String name) {
        return patronRegistry.values().stream()
                .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    // Get all patrons
    public List<Patron> getAllPatrons() {
        return new ArrayList<>(patronRegistry.values());
    }
}

