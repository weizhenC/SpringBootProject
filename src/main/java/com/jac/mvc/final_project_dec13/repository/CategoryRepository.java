package com.jac.mvc.final_project_dec13.repository;


import com.jac.mvc.final_project_dec13.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description:
 * Author: weizhenzhang
 * Date: 2023-12-08
 * Project: team1
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}

