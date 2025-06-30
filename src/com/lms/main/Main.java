package com.lms.main;

public class Main {
    public static void main(String[] args) {
        LibraryManager library = new LibraryManager();

        // Add books
        library.addBook("101", "Java: The Complete Reference", "Herbert Schildt", 2019);
        library.addBook("102", "Clean Code", "Robert Martin", 2008);

        // Add patrons
        library.addPatron("P001", "Shreyash", "shreyash@example.com");

        // Search
        System.out.println("All books:");
        library.listAllBooks();

        // Checkout and return
        library.checkoutBook("101", "P001");
        library.returnBook("101", "P001");

        // Lending records
        System.out.println("Lending Records:");
        library.viewAllLendingRecords();
    }
}

