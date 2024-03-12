package com.jac.mvc.final_project_dec13.repository;


import com.jac.mvc.final_project_dec13.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description:
 * Author: weizhenzhang
 * Date: 2023-12-08
 * Project: team1
 */
public interface AuthorRepository extends JpaRepository<Author,Long> {
}

