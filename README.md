# 📚 Library Management System (Java)

A simple object-oriented **Library Management System** built using core Java. This project demonstrates OOP principles, SOLID design, and common design patterns (Facade, Factory, etc.) in action.

---

## 🧠 Features

### ✅ Book Management
- Add, update, remove books
- Search by title, author, or ISBN
- View all or only available books

### ✅ Patron Management
- Add and update patron information
- Search by name
- View borrowing history

### ✅ Lending System
- Checkout and return books
- Track active and historical lending records

### ✅ Extensible
- Clean architecture ready for:
  - Multi-branch support
  - Reservation and notification system
  - Book recommendation engine

---

## 💡 Technologies Used

- **Java 8**
- Java Collections (List, Map, Stream)
- OOP, SOLID Principles
- Design Patterns: Facade, Factory
- Java Logging API

---

## 📦 Project Structure

```plaintext
com.library
│
├── entities
│   ├── Book.java
│   ├── Patron.java
│   └── LendingRecord.java
│
├── services
│   ├── BookService.java
│   ├── PatronService.java
│   └── LendingService.java
│
├── manager
│   └── LibraryManager.java
│
└── main
    └── Main.java
