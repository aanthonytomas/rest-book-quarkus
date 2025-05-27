package org.agoncal.quarkus.starting;

import java.util.List;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class BookRepository {

    // Use a properly scoped config name or ensure it's defined in application.properties
    @ConfigProperty(name = "book.genre", defaultValue = "Fantasy")
    String genre;

    public List<Book> getAllBooks() {
        return List.of(
            new Book(1, "The Lord of the Rings", "J.R.R. Tolkien", 1954, genre),
            new Book(2, "1984", "George Orwell", 1949, genre),
            new Book(3, "To Kill a Mockingbird", "Harper Lee", 1960, genre),
            new Book(4, "Pride and Prejudice", "Jane Austen", 1813, genre),
            new Book(5, "The Great Gatsby", "F. Scott Fitzgerald", 1925, genre)
        );
    }

    public int countAllBooks() {
        return getAllBooks().size();
    }

    public Book getBook(int id) {
        return getAllBooks().stream()
            .filter(book -> book.id == id)
            .findFirst()
            .orElseThrow(() -> new NotFoundException("Book not found"));
    }
}
