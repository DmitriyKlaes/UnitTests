package seminars.fourth.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {
    BookRepository bookRepository;
    BookService bookService;

    @BeforeEach
    void setUp() {
        bookRepository = mock(BookRepository.class);
        bookService = new BookService(bookRepository);
    }

    @Test
    void findByIdTest() {
        Book expectBook = new Book("id-1");

        when(bookRepository.findById("id-1")).thenReturn(expectBook);

        Book actualBook = bookService.findBookById("id-1");

        verify(bookRepository, times(1)).findById("id-1");
        assertEquals(expectBook, actualBook);
    }

    @Test
    void findAllBooksTest() {
        List<Book> expectListBook = new ArrayList<>(Arrays.asList(new Book("id-1"),
                                                                  new Book("id-2"),
                                                                  new Book("id-3")));

        when(bookRepository.findAll()).thenReturn(expectListBook);

        List<Book> actualListBook = bookService.findAllBooks();

        verify(bookRepository, times(1)).findAll();
        assertEquals(expectListBook.size(), actualListBook.size());
    }
}