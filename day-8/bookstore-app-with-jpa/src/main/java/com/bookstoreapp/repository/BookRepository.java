package com.bookstoreapp.repository;

import com.bookstoreapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository{

    List<Book> findAll();

    Optional<Book> findById(int id);

    Book save(Book book);

    void deleteById(int id);


}
