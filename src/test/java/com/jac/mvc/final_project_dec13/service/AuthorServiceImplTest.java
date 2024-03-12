package com.jac.mvc.final_project_dec13.service;

import com.jac.mvc.final_project_dec13.model.Author;
import com.jac.mvc.final_project_dec13.repository.AuthorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Description:
 * Author: weizhenzhang
 * Date: 2023-12-13
 * Project: final_project_dec13
 */

@ExtendWith(MockitoExtension.class)
public class AuthorServiceImplTest {


    @InjectMocks
    private AuthorServiceImpl authorService;

    @Mock
    private AuthorRepository authorRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllAuthors() {
        // Arrange
        List<Author> expectedAuthors = new ArrayList<>();
        when(authorRepository.findAll()).thenReturn(expectedAuthors);

        // Act
        List<Author> actualAuthors = authorService.getAllAuthors();

        // Assert
        assertEquals(expectedAuthors, actualAuthors);
    }

    @Test
    void testSaveAuthor() {
        // Arrange
        Author authorToSave = new Author();
        when(authorRepository.save(authorToSave)).thenReturn(authorToSave);

        // Act
        authorService.saveAuthor(authorToSave);

        // Assert
        verify(authorRepository, times(1)).save(authorToSave);
    }

    @Test
    void testFindAuthorById() {
        // Arrange
        Long authorId = 1L;
        Author expectedAuthor = new Author();
        when(authorRepository.findById(authorId)).thenReturn(Optional.of(expectedAuthor));

        // Act
        Author actualAuthor = authorService.findAuthorById(authorId);

        // Assert
        assertNotNull(actualAuthor);
        assertEquals(expectedAuthor, actualAuthor);
    }

    @Test
    void testFindAuthorByIdThrowsException() {
        // Arrange
        Long authorId = 1L;
        when(authorRepository.findById(authorId)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(RuntimeException.class, () -> authorService.findAuthorById(authorId));
    }

    @Test
    void testDeleteAuthorById() {
        // Arrange
        Long authorId = 1L;

        // Act
        authorService.deleteAuthorById(authorId);

        // Assert
        verify(authorRepository, times(1)).deleteById(authorId);
    }
}

