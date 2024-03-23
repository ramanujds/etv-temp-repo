package com.bookstoreapp.service;

import com.bookstoreapp.exception.BookAlreadyExistsException;
import com.bookstoreapp.exception.BookNotFoundException;
import com.bookstoreapp.model.Book;
import com.bookstoreapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public class BookstoreServiceImpl implements BookstoreService{

    private BookRepository bookRepository;


    /* TODO:
     Get all books
     */
    @Override
    public List<Book> getAllBooks() {
       return null;
    }

    /* TODO:
       Get book by id
       Check if book exists
          If book exists return book
          else throw exception book not found
     */
    @Override
    public Book getBookById(int id) {
        return null;
    }

    /* TODO:
       Save book
       Check if book exists
          If book exists throw exception book already exists
          else save book
     */
    @Override
    public Book saveBook(Book book) {
        return null;
    }


    /* TODO:
       Update book
       Check if book exists
          If book exists update book
          else throw exception book not found
     */
    @Override
    public Book updateBook(int id, Book book) {

          return null;

    }

    /* TODO:
       Delete book
       Check if book exists
          If book exists delete book
          else throw exception book not found
     */
    @Override
    public void deleteBook(int id) {
    }


}
