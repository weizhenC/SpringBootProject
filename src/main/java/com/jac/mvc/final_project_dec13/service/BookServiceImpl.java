package com.jac.mvc.final_project_dec13.service;

import com.jac.mvc.final_project_dec13.model.Book;
import com.jac.mvc.final_project_dec13.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Description:
 * Author: weizhenzhang
 * Date: 2023-12-01
 * Project: thymleaf_crud
 */
@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void saveBook(Book book) {
        this.bookRepository.save(book);
    }

    @Override
    public Book findBookById(Long id) {
        Optional<Book> optional = bookRepository.findById(id);
        Book book = null;
        if (optional.isPresent()) {
            book = optional.get();
        } else {
            throw new RuntimeException("Book not found for id:: " + id);
        }
        return book;
    }

    @Override
    public void deleteBookById(Long id) {
        this.bookRepository.deleteById(id);
    }




}

