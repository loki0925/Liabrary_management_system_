package com.lms.service;

import java.util.List;

import com.lms.LendingRecord;

public interface ILendingService {
    void checkoutBook(String isbn, String patronId);
    void returnBook(String isbn, String patronId);
    List<LendingRecord> getActiveLendings();
    List<LendingRecord> getLendingsByPatron(String patronId);
    List<LendingRecord> getAllLendings();
}

