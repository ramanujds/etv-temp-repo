package com.bookstoreapp.controller;

import com.bookstoreapp.model.Book;
import com.bookstoreapp.service.BookstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


public class BookstoreController {


    private BookstoreService bookstoreService;

    /* TODO:
     create a get request to get all books
     Return Response code of 200
     path: /books
     */

    public List<Book> getAllBooks() {
        // TODO: Implement this method
        return null;
    }


   /* TODO:
     create a post request to save a book
     Return Response code of 201
     path: /books
     */

    public Book saveBook(Book book) {
        // TODO: Implement this method
        return null;
    }

    /* TODO:
     create a PUT request to update a book
     Return Response code of 202
     path: /books/{id}
     */


    public Book updateBook( int id,  Book book) {
        // TODO: Implement this method
        return null;
    }

    /* TODO:
     create a DELETE request to delete a book
     Return Response code of 200
     path: /books/{id}
     */
    public void deleteBook(int id) {
        // TODO: Implement this method
    }


    /* TODO:
     create a GET request to get a book by id
     Return Response code of 200
     path: /books/{id}
     */
    public Book getBookById(int id) {
        // TODO: Implement this method
        return null;
    }




}
