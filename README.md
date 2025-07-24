# 📚 Library Management System

A Java-based command-line application that simulates a digital library system. It allows users to manage book checkouts, returns, and organize shelves using custom stacks and singly linked lists. No built-in Java collections (like ArrayList or Stack) are used.

---

## 📁 Project Structure

```
src/
├── Book.java
├── BookAlreadyCheckedOutException.java
├── BookAlreadyExistsException.java
├── BookCheckedOutByException.java
├── BookDoesNotExistException.java
├── BookNotCheckedOutException.java
├── BookRepository.java
├── Condition.java
├── Date.java
├── EmptyStackException.java
├── InvalidISBNException.java
├── InvalidReturnDateException.java
├── InvalidSortCriteriaException.java
├── InvalidUserIDException.java
├── LibraryManager.java        ← Main class
├── ReturnLog.java
├── ReturnStack.java
├── Shelf.java
└── SortCriteria.java
```

---

## 🧠 Features

✅ Add, remove, and lookup books in the repository  
✅ Check out and return books using custom validation  
✅ Stack-based return tracking  
✅ Sort shelves by criteria (ISBN, name, author, genre, etc.)  
✅ Input validation with **custom exceptions**  
✅ Uses only **core Java** (no external libraries or collections)

---

## 🛠️ Data Structures Used

- **Singly Linked Lists**: For organizing books and shelves  
- **Custom Stack (ReturnStack.java)**: For managing book returns  
- **Custom Exceptions**: For robust error handling

---

## 🖥️ How to Compile & Run

### ✅ Compile
```bash
javac -d out src/*.java
```

### ▶️ Run
```bash
java -cp out src.LibraryManager
```

---

## 📋 Sample Menu

```
(B) – Manage Book Repository
     (C) – Checkout Book
     (N) – Add New Book
     (R) – Remove Book
     (P) – Print Repository
     (S) – Sort Shelf
(R) – Manage Return Stack
     (R) – Return Book
     (L) – See Last Return
     (C) – Check In Last Return
     (P) – Print Return Stack
(Q) – Quit
```

---

## ✅ Example Output

```
| ISBN        | Title              | Author       | Genre      | Condition | Year |
|-------------|--------------------|--------------|------------|-----------|------|
| 978-3-16-1  | Intro to Java      | John Smith   | Education  | GOOD      | 2020 |
| 978-1-23-4  | Data Structures    | Alice Lin    | CS         | EXCELLENT | 2019 |
```

---

## License

This project is not open source. All rights reserved © 2025 Ansh Saluja.
