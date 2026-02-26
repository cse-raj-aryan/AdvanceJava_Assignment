package com.techm.bookstore;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

class BookManagerTestWithAnnotations {

	@Mock
	private BookDao bookDao;

	@InjectMocks
	private BookManager bookManager;

	@BeforeEach
	void setUp() {

		MockitoAnnotations.openMocks(this);
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

		verify(bookDao, times(1)).getAllBooks();
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
		when(bookDao.deleteBookById(bookId)).thenReturn(true);


		boolean result = bookManager.deleteBook(bookId);

		assertTrue(result);

		verify(bookDao, times(1)).deleteBookById(bookId);
	}

	
	@Test
	void testCalculateDiscount() {
		
		MockedStatic<BookManager> mockedStatic = mockStatic(BookManager.class);

		mockedStatic.when(() -> BookManager.calculateDiscount(100.0)).thenReturn(80.0);


		double discount = BookManager.calculateDiscount(100.0);

		
		assertEquals(80.0, discount);

		mockedStatic.verify(() -> BookManager.calculateDiscount(100.0), times(1));
	}

	
	@Test
	void testGetDatabaseInfo() {

		when(bookDao.getDatabaseInfo()).thenReturn("Mocked DB Info");

		
		String dbInfo = bookDao.getDatabaseInfo();

	
		assertEquals("Mocked DB Info", dbInfo);
	
		verify(bookDao, times(1)).getDatabaseInfo();
	}

	
	@Test
	void testLogAction() {
		
		doNothing().when(bookDao).logAction("Save");

		
		bookDao.logAction("Save");

		
		verify(bookDao, times(1)).logAction("Save");
	}

	
	@Test
	void testProcessBooksWithSpy() {


		BookManager spyManager = spy(new BookManager(bookDao));
		List<Book> books = Arrays.asList(new Book(1, "Java", "Author", 100.0));

		
		doReturn("Mocked Logic").when(spyManager).additionalLogic();

		
		List<Book> processedBooks = spyManager.processBooks(books);

		
		assertEquals(80.0, processedBooks.get(0).getPrice());
		assertEquals("Mocked Logic", spyManager.additionalLogic());

		verify(spyManager, times(2)).additionalLogic();
	}
}
