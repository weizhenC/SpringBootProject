package com.jac.mvc.final_project_dec13.repository;


import com.jac.mvc.final_project_dec13.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Description:
 * Author: weizhenzhang
 * Date: 2023-12-08
 * Project: team1
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}

