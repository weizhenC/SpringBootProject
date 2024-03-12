package com.jac.mvc.final_project_dec13.service;

import com.jac.mvc.final_project_dec13.model.Author;
import com.jac.mvc.final_project_dec13.repository.AuthorRepository;
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
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public void saveAuthor(Author author) {
        this.authorRepository.save(author);
    }

    @Override
    public Author findAuthorById(Long id) {
        Optional<Author> optional = authorRepository.findById(id);
        Author author = null;
        if (optional.isPresent()) {
            author = optional.get();
        } else {
            throw new RuntimeException("Author not found for id:: " + id);
        }
        return author;
    }

    @Override
    public void deleteAuthorById(Long id) {
        this.authorRepository.deleteById(id);
    }




}

