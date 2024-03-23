package com.bookstoreapp.service;

import com.bookstoreapp.exception.BookAlreadyExistsException;
import com.bookstoreapp.exception.BookNotFoundException;
import com.bookstoreapp.model.Book;
import com.bookstoreapp.repository.BookRepository;
import com.bookstoreapp.service.BookstoreServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookstoreServiceTest {

    @InjectMocks
    private BookstoreServiceImpl bookstoreService;

    @Mock
    private BookRepository bookRepository;


    @Test
    public void testGetAllBooks() {

        // Given
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "The Alchemist", "Paulo Coelho", 1988,156266262611L,250.0));
        books.add(new Book(2, "The Great Gatsby", "F. Scott Fitzgerald", 1925,156266262612L,300.0));
        books.add(new Book(3, "The Kite Runner", "Khaled Hosseini", 2003,156266262613L,350.0));
        books.add(new Book(4, "The Little Prince", "Antoine de Saint-Exupery", 1943,156266262614L,400.0));

        // When

        when(bookRepository.findAll()).thenReturn(books);

        // Then

        assertEquals(books, bookstoreService.getAllBooks());

        // check if the method is called only once
        verify(bookRepository, times(1)).findAll();


    }


    @Test
    public void testGetBookById(){

            // Given
            Book book = new Book(1, "The Alchemist", "Paulo Coelho", 1988,156266262611L,250.0);

            // When
            // when(bookRepository.existsById(1)).thenReturn(true);
            when(bookRepository.findById(1)).thenReturn(java.util.Optional.of(book));

            // Then
            assertEquals(book, bookstoreService.getBookById(1));

            // check if the method is called only once
            verify(bookRepository, times(1)).findById(1);

    }


    @Test
    public void testSaveBook(){

            // Given

            Book book = new Book(1, "The Alchemist", "Paulo Coelho", 1988,156266262611L,250.0);

            // When

            when(bookRepository.save(book)).thenReturn(book);

            // Then

            assertEquals(book, bookstoreService.saveBook(book));

            // check if the method is called only once
            verify(bookRepository, times(1)).save(book);

    }


    @Test
    public void testUpdateBook(){

            // Given

            Book book = new Book(1, "The Alchemist", "Paulo Coelho", 1988,156266262611L,250.0);

            // When

     //       when(bookRepository.existsById(1)).thenReturn(true);
            when(bookRepository.save(book)).thenReturn(book);


            // Then

            assertEquals(book, bookstoreService.updateBook(1, book));

            // check if the method is called only once
            verify(bookRepository, times(1)).save(book);

    }


    @Test
    public void testDeleteBook(){


            // When

            // when(bookRepository.existsById(1)).thenReturn(true);
            doNothing().when(bookRepository).deleteById(1);

            // Then
         assertDoesNotThrow(() -> {
            bookstoreService.deleteBook(1);
        });

            // check if the method is called only once
          //  verify(bookRepository, times(1)).existsById(1);
            verify(bookRepository, times(1)).deleteById(1);

    }

    // Test for getBookById() when book is not found
    @Test
    public void testGetBookByIdWhenBookNotFound(){

            // Given
            // Book book = new Book(1, "The Alchemist", "Paulo Coelho", 1988,156266262611L,250.0);

            // When
            when(bookRepository.findById(1)).thenThrow(new BookNotFoundException("Book not found"));

            // Then
            assertThrows(BookNotFoundException.class, () -> {
            bookstoreService.getBookById(1);
            });

            // check if the method is called only once
            verify(bookRepository, times(1)).findById(1);

    }

    // Write test for saveBook when book is already exists

    @Test
    public void testSaveBookWhenBookAlreadyExists(){

            // Given
            // create a book
            Book book = new Book(1, "The Alchemist", "Paulo Coelho", 1988,156266262611L,250.0);

            // When
            // mock the repository
            // when(bookRepository.existsById(1)).thenReturn(true);
            when(bookRepository.save(book)).thenThrow(new BookAlreadyExistsException("Book already exists"));

            // Then
            // check if BookAlreadyExistsException is thrown
            assertThrows(BookAlreadyExistsException.class, () -> {
            bookstoreService.saveBook(book);
            });

            // check if the method is called only once
            // verify(bookRepository, times(1)).existsById(1);
            verify(bookRepository, times(0)).save(book);

    }




}
