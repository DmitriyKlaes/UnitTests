package seminars.fourth.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
    Book book;

    @BeforeEach
    void setUp() {
        book = new Book("idTest", "titleTest","authorTest");
    }

    @Test
    void getIdTest() {
        assertEquals(book.getId(), "idTest");
    }

    @Test
    void setIdTest() {
        book.setId("expectedId");
        assertEquals(book.getId(), "expectedId");
    }

    @Test
    void getTitleTest() {
        assertEquals(book.getTitle(), "titleTest");
    }

    @Test
    void setTitleTest() {
        book.setTitle("expectedTitle");
        assertEquals(book.getTitle(), "expectedTitle");
    }

    @Test
    void getAuthorTest() {
        assertEquals(book.getAuthor(), "authorTest");
    }

    @Test
    void setAuthorTest() {
        book.setAuthor("expectedAuthor");
        assertEquals(book.getAuthor(), "expectedAuthor");
    }

}
