package com.jac.mvc.final_project_dec13.service;

import org.springframework.stereotype.Service;

import com.jac.mvc.final_project_dec13.model.Book;

import java.util.List;

/**
 * Description:
 * Author: weizhenzhang
 * Date: 2023-12-08
 * Project: team1
 */

@Service
public interface BookService {
    List<Book> getAllBooks();

    void saveBook(Book book);

    Book findBookById (Long bookId);

    void deleteBookById(Long bookId);

}

