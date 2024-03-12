package com.jac.mvc.final_project_dec13.service;





import com.jac.mvc.final_project_dec13.model.Author;

import java.util.List;

/**
 * Description:
 * Author: weizhenzhang
 * Date: 2023-12-08
 * Project: team1
 */
public interface AuthorService {

    List<Author> getAllAuthors();
    void saveAuthor(Author author);
    Author findAuthorById(Long authorId);
    void deleteAuthorById(Long authorId);
}

