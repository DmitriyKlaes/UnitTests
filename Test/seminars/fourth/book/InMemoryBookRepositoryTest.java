package seminars.fourth.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InMemoryBookRepositoryTest {
    InMemoryBookRepository bookRepository;

    @BeforeEach
    void setUp() {
        bookRepository = new InMemoryBookRepository();
    }

    @Test
    void findByIdTest() {
        Book book = bookRepository.findById("1");
        assertEquals(book.getId(), "1");
    }

    @Test
    void findAllBooksTest() {
        List<Book> expectListBook = new ArrayList<>(Arrays.asList(bookRepository.findById("1"), bookRepository.findById("2")));
        List<Book> listBook = bookRepository.findAll();
        assertTrue(listBook.containsAll(expectListBook));
    }
}
