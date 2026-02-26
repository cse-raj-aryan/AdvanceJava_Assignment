package com.techm.bookstore;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

class BookManagerTest {

	private BookDao bookDao;
	private BookManager bookManager; 

	@BeforeEach
	void setUp() {
		bookDao = mock(BookDao.class);
		bookManager = new BookManager(bookDao);
	}

	@Test
	void testGetAllBooks() {

		List<Book> mockBooks = Arrays.asList(new Book(1, "Effective Java", "Joshua Bloch", 45.50),
				new Book(2, "Clean Code", "Robert C. Martin", 40.00));
		when(bookDao.getAllBooks()).thenReturn(mockBooks);


		List<Book> books = bookManager.getAllBooks();


		assertNotNull(books);
		assertEquals(2, books.size());
		assertEquals("Effective Java", books.get(0).getTitle());
		verify(bookDao, times(1)).getAllBooks(); // Verify that the DAO method was called once
	}

	@Test
	void testAddBook() {
	
		Book book = new Book(1, "Effective Java", "Joshua Bloch", 45.50);
		when(bookDao.addBook(book)).thenReturn(true);


		boolean result = bookManager.addBook(book);

		assertTrue(result);
		verify(bookDao, times(1)).addBook(book); 
	}

	@Test
	void testDeleteBook() {
	
		int bookId = 1;
//		when(bookDao.deleteBookById(bookId)).thenReturn(true);
		when(bookDao.deleteBookById(anyInt())).thenReturn(true);
	
		boolean result = bookManager.deleteBook(anyInt());

	
		assertTrue(result);
		verify(bookDao, times(1)).deleteBookById(anyInt());
	}
}
