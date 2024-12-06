import java.util.ArrayList;
import java.util.List;


class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean isAvailable;

    
    public Book(int bookId, String title, String author) {
        if (bookId <= 0) {
            throw new IllegalArgumentException("Book ID must be a positive integer.");
        }
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = true; 
    }

    
    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    // Display basic book details
    public void displayInfo() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Borrowed"));
    }
}


class ReferenceBook extends Book {
    private int edition;

    
    public ReferenceBook(int bookId, String title, String author, int edition) {
        super(bookId, title, author);
        if (edition <= 0) {
            throw new IllegalArgumentException("Edition must be a positive integer.");
        }
        this.edition = edition;
    }

    
    public int getEdition() {
        return edition;
    }

    // Display detailed reference book information
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Edition: " + edition);
    }
}


class FictionBook extends Book {
    private String genre;

    
    public FictionBook(int bookId, String title, String author, String genre) {
        super(bookId, title, author);
        this.genre = genre;
    }

    
    public String getGenre() {
        return genre;
    }


    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Genre: " + genre);
    }
}

class Periodical extends ReferenceBook {
    private String issueFrequency;


    public Periodical(int bookId, String title, String author, int edition, String issueFrequency) {
        super(bookId, title, author, edition);
        this.issueFrequency = issueFrequency;
    }


    public String getIssueFrequency() {
        return issueFrequency;
    }


    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Issue Frequency: " + issueFrequency);
    }
}

class LibraryManagementSystem {
    private List<Book> books;
    private int totalBooksBorrowed;

    public LibraryManagementSystem() {
        books = new ArrayList<>();
        totalBooksBorrowed = 0;
    }


    public void addBook(Book book) {
        books.add(book);
    }


    public void borrowBook(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    totalBooksBorrowed++;
                    System.out.println("You have successfully borrowed the book: " + book.getTitle());
                } else {
                    System.out.println("Sorry, this book is already borrowed.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }


    public void returnBook(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    totalBooksBorrowed--;
                    System.out.println("Thank you for returning the book: " + book.getTitle());
                } else {
                    System.out.println("This book was not borrowed.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }


    public void displayAllBooks() {
        for (Book book : books) {
            book.displayInfo();
            System.out.println("---------------");
        }
    }


    public void displayLibraryStats() {
        System.out.println("Total Books in Library: " + books.size());
        System.out.println("Total Books Borrowed: " + totalBooksBorrowed);
        System.out.println("Available Books: " + (books.size() - totalBooksBorrowed));
    }
}

public class Main {
    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();

    
        library.addBook(new ReferenceBook(1, "Data Structures", "Mark Weiss", 3));
        library.addBook(new FictionBook(2, "Harry Potter", "J.K. Rowling", "Fantasy"));
        library.addBook(new Periodical(3, "Nature Journal", "Editorial Board", 12, "Monthly"));

    
        System.out.println("Library Collection:");
        library.displayAllBooks();

    
        System.out.println("Borrowing a book:");
        library.borrowBook(3);

    
        library.borrowBook(3);

    
        library.displayLibraryStats();

    
        System.out.println("Returning a book:");
        library.returnBook(2);

    
        library.displayLibraryStats();
    }
}
