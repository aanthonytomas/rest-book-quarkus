package org.agoncal.quarkus.starting;

import java.util.List;

import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    @Inject
    BookRepository bookRepository;
    @Inject
    Logger logger;

    @GET
    public List<Book> getAllBooks() {
        logger.info("Returns all books");
        return bookRepository.getAllBooks();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countBooks() {
        logger.info("Returns the numvber of books");
        return bookRepository.countAllBooks();
    }

    @GET
    @Path("{id}")
    public Book getBook(@PathParam("id") int id) {
        logger.info("Returns a single book with id " + id);
        return bookRepository.getBook(id);
    }
}
