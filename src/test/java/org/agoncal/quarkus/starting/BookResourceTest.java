package org.agoncal.quarkus.starting;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class BookResourceTest {

    @Test
    public void shouldGetABookById() {
        given()
            .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
        .when()
            .get("/api/books/1")
        .then()
            .statusCode(200)
            .body("title", is("The Lord of the Rings"))
            .body("author", is("J.R.R. Tolkien"))
            .body("yearofPublication", is(1954))
            .body("genre", is("Fantasy"));
    }
}
